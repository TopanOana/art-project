package com.oanatopan.artproject.sumar.feature.credits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oanatopan.artproject.design.theme.BackButton
import com.oanatopan.artproject.design.theme.SumarTheme

/** Names as listed under "ECHIPA" on the Figma credits screen. */
private val team = listOf("Ilinca Stihi", "Andrei Pop", "Oana Topan")

/**
 * The credits screen sits content right under the back-button bar rather than centered in the
 * screen — per the Figma frame there's no large top gap, just some breathing room, with the rest
 * of the screen left empty below.
 */
@Composable
fun CreditsScreen(
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(SumarTheme.colors.background)
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BackButton(
            onClick = onBackClick,
            modifier = Modifier.align(Alignment.Start),
        )

        Column(
            modifier = Modifier.padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = "ECHIPA",
                style = SumarTheme.typography.heading,
                color = SumarTheme.colors.secondaryAction,
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                team.forEach { name ->
                    Text(
                        text = name,
                        style = SumarTheme.typography.body,
                        color = SumarTheme.colors.content,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CreditsScreenPreview() {
    SumarTheme {
        CreditsScreen(onBackClick = {})
    }
}
