package com.oanatopan.artproject.sumar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.oanatopan.artproject.design.theme.SumarTheme

@Composable
fun App() {
    SumarTheme {
        RootNavigation()
    }
}

@Preview
@Composable
private fun AppPreview() {
    App()
}
