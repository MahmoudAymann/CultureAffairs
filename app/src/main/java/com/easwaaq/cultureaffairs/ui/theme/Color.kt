package com.easwaaq.cultureaffairs.ui.theme

import androidx.compose.ui.graphics.Color

fun String.fromHexToColor():Color = Color(this.removePrefix("#").toLong(16) or 0x00000000FF000000)

val PrimaryColor = Color.Black
val SecondaryColor = Color.White
val TertiaryColor = Color.White