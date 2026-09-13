package com.oanatopan.artproject.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font

internal val LocalTypography = staticCompositionLocalOf { Typography() }

/**
 * The Figma file sets every piece of type in this app (other than the player's timestamps) in
 * "Arial Black". That's a system font on most platforms, not something we can bundle, so we use
 * Archivo Black instead — an OFL-licensed, freely bundleable display face with the same
 * ultra-bold, condensed-ish personality — packaged as a compose resource so it renders
 * identically on Android and iOS instead of falling back to whatever black-weight approximation
 * each platform's default sans happens to have.
 *
 * Timestamps use "Inter Medium" in the design; Inter ships from Google Fonts as a variable font
 * only, which Compose Multiplatform doesn't reliably pin to a single static weight across every
 * target, so timestamps stay on the platform default font at [FontWeight.Medium] instead of
 * bundling a font just for two small numbers.
 */
@Stable
@Composable
internal fun archivoBlackFamily(): FontFamily = FontFamily(
    Font(resource = Res.font.archivo_black, weight = FontWeight.Black),
)

/**
 * Exact type sizes pulled from the SUMAR Figma file via the Figma dev-mode MCP connector.
 */
@Immutable
data class Typography(
    private val displayFamily: FontFamily? = null,
    /** The "SUMAR" wordmark on the title screen — carries the white drop shadow from Figma. */
    val title: TextStyle = TextStyle(
        fontFamily = displayFamily,
        fontWeight = FontWeight.Black,
        fontSize = 64.sp,
        shadow = Shadow(color = Color.White, offset = Offset(9f, 12f), blurRadius = 9.4f),
    ),
    /** "ECHIPA" on the credits screen, and other section headings. */
    val heading: TextStyle = TextStyle(
        fontFamily = displayFamily,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp,
    ),
    /** The START button's label. */
    val buttonLarge: TextStyle = TextStyle(
        fontFamily = displayFamily,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp,
    ),
    /** The CREDITS button's label. */
    val buttonSmall: TextStyle = TextStyle(
        fontFamily = displayFamily,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp,
    ),
    /** Credits screen team names, and other short body copy. */
    val body: TextStyle = TextStyle(
        fontFamily = displayFamily,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp,
    ),
    /** Player screen elapsed/remaining timestamps — "Inter Medium" in Figma; see class doc. */
    val timestamp: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
)
