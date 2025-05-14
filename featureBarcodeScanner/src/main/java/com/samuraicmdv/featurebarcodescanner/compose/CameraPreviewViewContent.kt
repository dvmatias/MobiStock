package com.samuraicmdv.featurebarcodescanner.compose

import android.annotation.SuppressLint
import android.hardware.camera2.CaptureRequest
import android.os.SystemClock
import android.util.Size
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.camera.camera2.interop.Camera2Interop
import androidx.camera.camera2.interop.ExperimentalCamera2Interop
import androidx.camera.core.AspectRatio
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerEvent
import com.samuraicmdv.featurebarcodescanner.event.BarcodeScannerPresentationEvent
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

private const val MIN_IMAGE_ANALYSIS_DELAY = 500L

private var lastAnalyzedTimestamp = 0L

private var shouldEmitBarcodeLost = true

@OptIn(ExperimentalCamera2Interop::class)
@Composable
fun CameraPreviewViewContent(modifier: Modifier = Modifier, callback: (BarcodeScannerEvent) -> Unit) {
    val context = LocalContext.current
    val lifecycleOwner = context as LifecycleOwner
    val cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    AndroidView(
        factory = { ctx ->
            val previewView = PreviewView(ctx).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }

            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()
                val previewBuilder = Preview.Builder()
                    .setTargetResolution(Size(1280, 720))
                    .setTargetRotation(previewView.display.rotation)

                val barcodeScanner = BarcodeScanning.getClient()
                val imageAnalyzer = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .setTargetResolution(Size(1280, 720))
                    .build()
                    .also {
                        it.setAnalyzer(cameraExecutor) { imageProxy ->
                            processImageProxy(imageProxy, barcodeScanner, callback)
                        }
                    }

                val cameraSelector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

                // Use Camera2Interop to set focus to infinity
                val camera2InteropConfig = Camera2Interop.Extender(previewBuilder)
                camera2InteropConfig.setCaptureRequestOption(
                    CaptureRequest.CONTROL_AF_MODE,
                    CaptureRequest.CONTROL_AF_MODE_OFF
                )
                camera2InteropConfig.setCaptureRequestOption(
                    CaptureRequest.LENS_FOCUS_DISTANCE,
                    8.0f // Focus at infinity
                )
                val preview = previewBuilder.build()
                preview.surfaceProvider = previewView.surfaceProvider

                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageAnalyzer
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }, ContextCompat.getMainExecutor(context))

            previewView
        },
        modifier = modifier
    )
}

@SuppressLint("UnsafeOptInUsageError")
private fun processImageProxy(
    imageProxy: ImageProxy,
    barcodeScanner: com.google.mlkit.vision.barcode.BarcodeScanner,
    callback: (BarcodeScannerEvent) -> Unit
) {
    val currentTimestamp = SystemClock.elapsedRealtime()
    val timeSinceLastAnalysis = currentTimestamp - lastAnalyzedTimestamp

    // Throttle image analysis to once every 500ms
    if (timeSinceLastAnalysis < MIN_IMAGE_ANALYSIS_DELAY) {
        imageProxy.close()
        return
    }

    lastAnalyzedTimestamp = currentTimestamp

    val mediaImage = imageProxy.image
    if (mediaImage != null) {
        val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
        barcodeScanner.process(image)
            .addOnSuccessListener { barcodes ->
                if (barcodes.isEmpty()) {
                    if (shouldEmitBarcodeLost) {
                        shouldEmitBarcodeLost = false
                        // Emit barcode lost event if no barcodes are detected
                        callback(BarcodeScannerPresentationEvent.OnBarcodeLost)
                    }
                } else {
                    shouldEmitBarcodeLost = true
                    for (barcode in barcodes.toSet()) {
                        barcode.rawValue?.let {
                            callback(BarcodeScannerPresentationEvent.OnBarcodeScanned(it))
                        }
                    }
                }
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
            .addOnCompleteListener {
                imageProxy.close()
            }
    } else {
        imageProxy.close()
    }
}