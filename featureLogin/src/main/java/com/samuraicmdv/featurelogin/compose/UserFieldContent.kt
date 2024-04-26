package com.samuraicmdv.featurelogin.compose

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import com.samuraicmdv.ui.widget.MobiTextField

@Composable
fun UserFieldContent(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    placeholder: String = "User name or email",
) {
    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Person,
            contentDescription = ""
        )
    }
    val trailingIcon = @Composable {
        Icon(
            Icons.Default.Close,
            contentDescription = ""
        )
    }

    MobiTextField(
        value = value,
        onValueChange = onChange,
        enabled = !isLoading,
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { Text(placeholder) },
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
}