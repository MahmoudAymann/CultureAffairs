package com.easwaaq.cultureaffairs.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.easwaaq.cultureaffairs.R
import com.easwaaq.cultureaffairs.extension.UiComponents.CreateButton
import com.easwaaq.cultureaffairs.extension.UiComponents.CreateInputField
import com.easwaaq.cultureaffairs.extension.UiExtensions.advanceShadow
import com.easwaaq.cultureaffairs.ui.theme.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            setView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    setView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun setView() {
    CultureAffairsTheme {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryColor),
        ) {
            val (image, bottomSurface) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "app logo",
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(bottomSurface.top)
                    }
                    .background(
                        color = Color.White, shape =
                        RoundedCornerShape(
                            topStart = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .padding(15.dp)
                    .size(60.dp)
            )

            Surface(
                shape = RoundedCornerShape(topStart = 60.dp),
                shadowElevation = 1.5.dp,
                color = Color.White,
                modifier = Modifier
                    .constrainAs(bottomSurface) {
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .fillMaxHeight(.7f)
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp)
                        .scrollable(
                            rememberScrollState(),
                            orientation = Orientation.Vertical
                        )
                ) {
                    val (titleLogin, etMail, etPassword, btnLogin) = createRefs()
                    //TitleLogin
                    Text(
                        text = stringResource(R.string.login),
                        modifier = Modifier.constrainAs(titleLogin) {
                            end.linkTo(parent.end)
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    CreateInputField(
                        modifier = Modifier
                            .constrainAs(etMail) {
                                top.linkTo(titleLogin.bottom, 60.dp)
                            }
                            .advanceShadow(
                                color = ShadowColor,
                                borderRadius = 16.dp,
                                elevation = 5.dp,
                            ),
                        label = R.string.mail,
                        valueCallBack = { value ->
                        }
                    )

                    CreateInputField(
                        modifier = Modifier
                            .constrainAs(etPassword) {
                                top.linkTo(etMail.bottom, 24.dp)
                            }
                            .advanceShadow(
                                color = ShadowColor,
                                borderRadius = 16.dp,
                                elevation = 5.dp,
                            ),
                        label = R.string.password,
                        isPassword = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        valueCallBack = { password ->
                            Log.e("tag", password)
                        }
                    )
                    //Button
                    CreateButton(modifier = Modifier
                        .constrainAs(btnLogin) {
                            top.linkTo(etPassword.bottom, 45.dp)
                        }
                        .fillMaxWidth()
                        .height(50.dp)
                        .advanceShadow(
                            color = ShadowColor,
                            borderRadius = 16.dp,
                            elevation = 3.dp,
                        ), shape = RoundedCornerShape(
                        topEnd = 0.dp,
                        topStart = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    ), text = R.string.login) {
                        Log.e("tag", "asdasdasd")
                    }

                }
            }
        }
    }
}