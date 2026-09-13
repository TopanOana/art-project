package com.oanatopan.artproject.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object SumarTheme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Composable
fun SumarTheme(content: @Composable () -> Unit) {
    val typography = Typography(displayFamily = archivoBlackFamily())
    CompositionLocalProvider(
        LocalColors provides SumarColors,
        LocalTypography provides typography,
        content = content,
    )
}
