package com.easwaaq.cultureaffairs.extension

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.easwaaq.cultureaffairs.ui.theme.*

object UiComponents {

    @Composable
    fun LinearProgressBar(modifier: Modifier, show: Boolean): Unit {
        val progress = LinearProgressIndicator(modifier = modifier, color = getDynamicColor())
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CreateInputField(
        modifier: Modifier,
        @StringRes label: Int,
        isPassword: Boolean = false,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        valueCallBack: (String) -> Unit
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        var passwordHidden by rememberSaveable { mutableStateOf(true) }
        val visualTransformation: VisualTransformation = if (isPassword) {
            if (passwordHidden)
                PasswordVisualTransformation() else VisualTransformation.None
        } else
            VisualTransformation.None
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                valueCallBack.invoke(text.text)
            },
            label = {
                Text(text = stringResource(label))
            },
            modifier = Modifier
                .fillMaxWidth()
                .then(modifier),
            shape = RoundedCornerShape(
                topEnd = 0.dp,
                topStart = 16.dp,
                bottomStart = 16.dp,
                bottomEnd = 16.dp
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                textColor = ETTextColor,
                focusedLabelColor = PrimaryColor,
                unfocusedLabelColor = PrimaryColor,
                containerColor = Color.White,
            ),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            trailingIcon = {
                if (isPassword)
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        val visibilityIcon =
                            if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        // Please provide localized description for accessibility services
                        val description = if (passwordHidden) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
            }
        )
    }

    @Composable
    fun CreateButton(
        modifier: Modifier,
        @StringRes text: Int,
        shape: Shape = RoundedCornerShape(16.dp),
        onClick: () -> Unit
    ) {
        ElevatedButton(onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = getDynamicColor()
            ),
            shape = shape, content = {
                Text(text = stringResource(id = text), color = Color.White)
            }
        )
    }
}