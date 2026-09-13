package com.oanatopan.artproject.design.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * The chevron back button used on the player and credits screens (Figma's "Back Button Bar").
 * A real [IconButton] + [Icon] rather than a plain [androidx.compose.material3.Text] glyph, so it
 * gets a proper minimum touch target, ripple, and accessibility semantics for free instead of
 * being a piece of styled text that happens to be clickable.
 */
@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
            contentDescription = "Back",
            tint = SumarTheme.colors.heading,
        )
    }
}
