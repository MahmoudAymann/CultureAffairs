package com.easwaaq.cultureaffairs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.easwaaq.cultureaffairs.ui.theme.CultureAffairsTheme
import com.easwaaq.cultureaffairs.ui.theme.PrimaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CultureAffairsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CultureAffairsTheme {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryColor),
        ) {
            val (image, bottomSurface) = tcreateRef()
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "app logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(20.dp)
                    .background(color = Color.White, shape =
                    RoundedCornerShape(
                        topStart = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    ))
            )

            Surface(
                shape = RoundedCornerShape(topStart = 16.dp), shadowElevation = 1.5.dp,
                modifier = Modifier
                    .background(Color.White)
                    .padding(top = 60.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(.8f)
            ) {
            }
        }
    }
}