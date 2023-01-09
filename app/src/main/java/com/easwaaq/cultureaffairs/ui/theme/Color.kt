package com.easwaaq.cultureaffairs.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

fun String.fromHexToColor():Color = Color(this.removePrefix("#").toLong(16) or 0x00000000FF000000)

val PrimaryColor = "#1034a6".fromHexToColor()
val PLightColor = "#585ed8".fromHexToColor()
val PDarkColor = "#001076".fromHexToColor()
val SecondaryColor = "#fae168".fromHexToColor()
val SLightColor = "#ffff99".fromHexToColor()
val SDarkColor = "#c4af37".fromHexToColor()

val TertiaryColor = PrimaryColor

val ETTextColor = "#B9B9B9".fromHexToColor()
val ShadowColor = "#B9B9B9".fromHexToColor()

@Composable
fun getDynamicColor() = if (isSystemInDarkTheme()) PDarkColor else PrimaryColor