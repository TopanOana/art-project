package com.oanatopan.artproject.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalColors = staticCompositionLocalOf { SumarColors }

val SumarColors = Colors()

/**
 * Exact hex values pulled from the SUMAR Figma file (title/player/credits screens) via the
 * Figma dev-mode MCP connector.
 */
@Immutable
data class Colors(
    /** Warm off-white background shared by the title and credits screens. */
    val background: Color = Color(0xFFFFF8EE),
    /** Dark teal-green used for the "SUMAR" wordmark and other headings. */
    val heading: Color = Color(0xFF396E69),
    /** Default body/label text color (credits names render in pure black). */
    val content: Color = Color(0xFF000000),
    /** Orange "START" pill button. */
    val primaryAction: Color = Color(0xFFEE773F),
    /** Teal "CREDITS" pill button / secondary accent (also the progress-bar fill + timestamps). */
    val secondaryAction: Color = Color(0xFF5A9893),
    /** Text/icon color on top of [primaryAction] or [secondaryAction]. */
    val onAction: Color = Color(0xFFFFF2DE),
    /** Cream background of the Audio Bar on the player screen (distinct from [background]). */
    val playerBarBackground: Color = Color(0xFFFBF0DE),
)
