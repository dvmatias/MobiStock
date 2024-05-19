package com.samuraicmdv.ui.widget

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.ui.widget.SegmentColors.Companion.getNextColor
import kotlin.random.Random
import kotlin.random.nextInt

private const val MIN_PERCENT = 10
private const val MAX_PERCENT = 40
private const val SEGMENT_SPAWN_INTERVAL = 100
private const val SEGMENT_GROW_INTERVAL = 700
private const val STROKE_WIDTH = 14
private const val INNER_GAP_WIDTH = 14
private const val STROKES_EXTRA = 4

@Composable
fun LinearLoadingIndicator(
    modifier: Modifier = Modifier,
) {
    var playTime by remember {
        mutableLongStateOf(0L)
    }
    val segments = remember {
        mutableStateListOf(Segment())
    }

    Canvas(modifier = modifier.clip(RoundedCornerShape(percent = 100))) {
        val stroke = STROKE_WIDTH + this.density
        val innerGap = INNER_GAP_WIDTH + this.density
        val percentWidth = this.size.width / 100F
        var next = 0F
        var segRemove: Segment? = null

        segments.forEach { segment ->
            val length = (segment.length.toFloat() * percentWidth)
            val start = next + segment.deltaX
            var end = next + length + segment.deltaX

            if (end > this.size.width + stroke * STROKES_EXTRA) {
                end = this.size.width + stroke * STROKES_EXTRA
            }
            if (start <= end) {
                this.drawLine(
                    color = segment.color,
                    start = Offset(start + innerGap - stroke * 2, this.center.y),
                    end = Offset(end - innerGap - stroke * 2, this.center.y),
                    strokeWidth = stroke,
                    cap = StrokeCap.Round
                )
                next += length
            } else {
                segRemove = segment
            }
            segRemove?.let { segments.remove(it) }
        }
    }

    LaunchedEffect(true) {
        initSegments(segments)

        val startTime = withFrameMillis { it }
        var lastLaunchTime = 0L
        var currentColor = getNextColor()

        do {
            playTime = withFrameMillis { it } - startTime

            if (playTime - lastLaunchTime > SEGMENT_SPAWN_INTERVAL) {
                lastLaunchTime = playTime
                val segment = Segment(
                    maxLength = Random.nextInt(MIN_PERCENT..MAX_PERCENT),
                    color = currentColor,
                    state = SegmentState.GROWING,
                    initialTime = playTime
                )
                segments.add(0, segment)
                currentColor = getNextColor(currentColor)
            }
            var deltaGrow = 0
            segments.forEach { segment ->
                segment.deltaX = deltaGrow.toLong()
                if (segment.state == SegmentState.GROWING) {
                    val oldLength = segment.length
                    segment.length =
                        ((playTime - segment.initialTime) * segment.maxLength / SEGMENT_GROW_INTERVAL).toInt()
                    if (segment.length > segment.maxLength) {
                        segment.length = segment.maxLength
                        segment.state = SegmentState.FINAL
                    }
                    deltaGrow += segment.length - oldLength
                }
            }
        } while (true)
    }
}

private fun initSegments(segments: SnapshotStateList<Segment>) {
    segments.clear()
    var color = getNextColor()
    var totalpercent = 100
    var segmentId = 0

    fun addSegment(length: Int) {
        segments.add(
            Segment(
                length = length,
                maxLength = length,
                color = color,
                state = SegmentState.FINAL
            )
        )
        color = getNextColor(color)
        totalpercent -= segments[segmentId].length
        segmentId++
    }
    addSegment(Random.nextInt(MIN_PERCENT..MAX_PERCENT))

    var rng = (totalpercent - MIN_PERCENT * 3).coerceAtMost(MAX_PERCENT - MIN_PERCENT)
    addSegment(Random.nextInt(MIN_PERCENT..rng + MIN_PERCENT))
    rng = (totalpercent - MIN_PERCENT * 2).coerceAtMost(MAX_PERCENT - MIN_PERCENT)
    addSegment(Random.nextInt(MIN_PERCENT..rng + MIN_PERCENT))
    addSegment(totalpercent)
}

private data class Segment(
    var length: Int = 0,
    val maxLength: Int = 0,
    val color: Color = Color.Transparent,
    var deltaX: Long = 0L,
    var state: SegmentState = SegmentState.GROWING,
    val initialTime: Long = 0L,
)

private enum class SegmentState {
    GROWING,
    FINAL
}

private class SegmentColors {
    companion object {
        val Color1 = Color(0xFFDE458E)
        val Color2 = Color(0xFF17C28F)
        val Color3 = Color(0xFFDE458E)
        val Color4 = Color(0xFF17C28F)

        fun getNextColor(color: Color? = null): Color =
            when (color) {
                Color1 -> Color2
                Color2 -> Color3
                Color3 -> Color4
                Color4 -> Color1
                null -> Color1
                else -> Color1
            }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLinearLoadingIndicator() {
    MobiTheme {
        Surface {
            LinearLoadingIndicator(Modifier.fillMaxWidth().height(MobiTheme.dimens.dimen_3))
        }
    }
}