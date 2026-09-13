package com.oanatopan.artproject.sumar.feature.title

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.oanatopan.artproject.design.theme.Res
import com.oanatopan.artproject.design.theme.SumarTheme
import com.oanatopan.artproject.design.theme.title_map_background
import org.jetbrains.compose.resources.painterResource

/**
 * The app's title screen: wordmark, subtitle, and the START/CREDITS actions, over the full-bleed
 * Bucharest metro map illustration from the Figma file.
 *
 * Positions below are exact values read from the Figma dev-mode connector: the wordmark sits
 * 61dp below the (real, OS-drawn) status bar rather than being vertically centered, and the two
 * buttons are pinned to the bottom of the screen with a 38dp gap between them. The background
 * image is the exact crop Figma uses here — the whole map scaled to the screen's height and
 * shifted left, per the "HARTA_2" instance's transform on the Start Page frame.
 */
@Composable
fun TitleScreen(
    onStartClick: () -> Unit,
    onCreditsClick: () -> Unit,
) {
    Box(
        modifier = Modifier.background(SumarTheme.colors.background).fillMaxSize(),
    ) {
        Image(
            painter = painterResource(Res.drawable.title_map_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .safeDrawingPadding()
                .padding(top = 61.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "SUMAR",
                style = SumarTheme.typography.title,
                color = SumarTheme.colors.heading,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "(1000 DE SEMNE)",
                style = SumarTheme.typography.body,
                color = SumarTheme.colors.heading,
                textAlign = TextAlign.Center,
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(38.dp),
        ) {
            TitleButton(
                text = "START",
                background = SumarTheme.colors.primaryAction,
                cornerRadius = 27.dp,
                horizontalPadding = 50.dp,
                verticalPadding = 16.dp,
                textStyle = SumarTheme.typography.buttonLarge,
                onClick = onStartClick,
            )
            TitleButton(
                text = "CREDITS",
                background = SumarTheme.colors.secondaryAction,
                cornerRadius = 22.dp,
                horizontalPadding = 20.dp,
                verticalPadding = 6.dp,
                textStyle = SumarTheme.typography.buttonSmall,
                onClick = onCreditsClick,
            )
        }
    }
}

@Composable
private fun TitleButton(
    text: String,
    background: Color,
    cornerRadius: Dp,
    horizontalPadding: Dp,
    verticalPadding: Dp,
    textStyle: TextStyle,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(background, RoundedCornerShape(cornerRadius))
            .clickable(onClick = onClick)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = textStyle,
            color = SumarTheme.colors.onAction,
        )
    }
}

@Preview
@Composable
private fun TitleScreenPreview() {
    SumarTheme {
        TitleScreen(onStartClick = {}, onCreditsClick = {})
    }
}
