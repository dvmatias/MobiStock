package com.samuraicmdv.featurelogin.compose

import android.content.res.Configuration
import android.net.Credentials
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuraicmdv.common.theme.MobiStockTheme
import com.samuraicmdv.ui.widget.MobiTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = com.samuraicmdv.featurelogin.R.drawable.login_screen_bgr),
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(MobiStockTheme.colors.backgroundTertiary),
                alpha = 0.3F
            )
            .padding(
                horizontal = MobiStockTheme.spaces.grid_2,
                vertical = MobiStockTheme.spaces.grid_2
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_5))
            Image(
                painterResource(com.samuraicmdv.featurelogin.R.drawable.logo_1),
                contentDescription = "",
                contentScale = ContentScale.Inside,
                //colorFilter = ColorFilter.tint(MobiStockTheme.colors.brandPrimary),
                modifier = Modifier.size(110.dp)
            )
            LoginGreetingContent()
            LoginFormContent(
                modifier.weight(1F)
            )
            SignUpContent()
        }
    }
}

@Composable
fun LoginFormContent(
    modifier: Modifier = Modifier,
) {
    var credentials by remember { mutableStateOf(Credentials()) }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        LoginField(
            value = credentials.login,
            onChange = { data -> credentials = credentials.copy(login = data) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_1))
        PasswordField(
            value = credentials.pwd,
            onChange = { data -> credentials = credentials.copy(pwd = data) },
            submit = {
                /*TODO*/
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_0_75))
        Text(
            "forgot password?",
            fontSize = 14.sp,
            color = MobiStockTheme.colors.linkEnabled
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_4))
        Button(
            onClick = {
                /*TODO*/
            },
            enabled = credentials.isNotEmpty(),
            shape = RoundedCornerShape(MobiStockTheme.spaces.grid_0_5),
            colors = ButtonDefaults.buttonColors(
                containerColor = MobiStockTheme.colors.brandPrimary,
                disabledContainerColor = MobiStockTheme.colors.backgroundDisabled,
                contentColor = Color.White,
                disabledContentColor = MobiStockTheme.colors.foregroundDisabled
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Login")
        }
    }
}

@Composable
fun LoginGreetingContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome!",
            color = MobiStockTheme.colors.foregroundPrimary,
            fontSize = 36.sp // TODO
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_1))
        Text(
            text = "Happy to see you!",
            color = MobiStockTheme.colors.foregroundSecondary,
            fontSize = 14.sp, // TODO
            lineHeight = 18.sp, // TODO
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7F) // TODO
        )
        Text(
            text = "Sign in user your credentials or signup if you don't have an account yet.",
            color = MobiStockTheme.colors.foregroundSecondary,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7F) // TODO
        )
    }
}

@Composable
fun LoginField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
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

@Composable
fun PasswordField(
    value: String,
    onChange: (String) -> Unit,
    submit: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Password",
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Key,
            contentDescription = ""
        )
    }
    val trailingIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = ""
            )
        }
    }
    MobiTextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { submit() }
        ),
        placeholder = { Text(placeholder) },
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun SignUpContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Don't have an account?",
            color = MobiStockTheme.colors.foregroundPrimary,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(MobiStockTheme.spaces.grid_0_75))
        Button(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.5.dp, MobiStockTheme.colors.brandPrimary),
            shape = RoundedCornerShape(MobiStockTheme.spaces.grid_0_5),
            colors = ButtonDefaults.buttonColors(
                containerColor = MobiStockTheme.colors.backgroundPrimary,
                disabledContainerColor = MobiStockTheme.colors.backgroundDisabled,
                contentColor = Color.White,
                disabledContentColor = MobiStockTheme.colors.foregroundDisabled
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Sign up", color = MobiStockTheme.colors.brandPrimary)
        }
    }
}

// TODO move to proper location
data class Credentials(
    var login: String = "",
    var pwd: String = "",
    var remember: Boolean = false,
) {
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty() && pwd.isNotEmpty()
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    MobiStockTheme {
        Surface(color = MobiStockTheme.colors.backgroundPrimary) {
            LoginScreen()
        }
    }
}