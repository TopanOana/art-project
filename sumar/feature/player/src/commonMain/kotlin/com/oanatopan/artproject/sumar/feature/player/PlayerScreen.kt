package com.oanatopan.artproject.sumar.feature.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oanatopan.artproject.design.theme.BackButton
import com.oanatopan.artproject.design.theme.Res
import com.oanatopan.artproject.design.theme.SumarTheme
import com.oanatopan.artproject.design.theme.listen_1_map_background
import org.jetbrains.compose.resources.painterResource

/**
 * The main "listening" screen: back navigation, the map background, and playback controls.
 *
 * The Figma file has four variants of this screen (Listen_1..4), each panned to a different part
 * of the shared metro-map illustration as narration progresses. This scaffold shows the Listen_1
 * crop as a static background; wiring the crop to advance with playback (Listen_1 → 2 → 3 → 4)
 * is still TODO, pending the real audio engine driving a chapter index instead of a raw float.
 * In the reference 812dp-tall frame the map fills the top 648dp and the Audio Bar is a
 * fixed-padding section below it — reproduced here with the map taking the remaining space via
 * `weight` (so it still fills the screen on other device heights) and the Audio Bar keeping
 * Figma's exact padding.
 *
 * That 58dp bottom padding on the Audio Bar already reads as a safe-area-aware value from Figma
 * (roughly home-indicator-height + a visual gap), so it's applied on its own here rather than
 * stacked on top of [Modifier.safeDrawingPadding] — doing both double-pads the bottom of this
 * section, which was pushing the progress bar and controls row far enough down to clip against
 * the bottom of the screen instead of sitting just above it.
 *
 * The Figma "Controls" glyph is a single flattened image containing prev/play/next together;
 * since this needs three independent tap targets it's rebuilt here as three separate elements
 * using the standard Material play/pause/skip icons, tinted to match the design, instead of
 * reusing that asset as-is or drawing custom glyphs by hand.
 */
@Composable
fun PlayerScreen(
    onBackClick: () -> Unit,
) {
    var isPlaying by remember { mutableStateOf(false) }
    // Placeholder position: 1:24 of 3:45, matching the examples state shown in the Figma file.
    var progress by remember { mutableFloatStateOf(84f / 225f) }

    Column(modifier = Modifier.fillMaxSize().background(SumarTheme.colors.background)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            Image(
                painter = painterResource(Res.drawable.listen_1_map_background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            BackButton(
                onClick = onBackClick,
                modifier = Modifier.safeDrawingPadding(),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(SumarTheme.colors.playerBarBackground)
                .padding(top = 16.dp, bottom = 58.dp, start = 25.dp, end = 25.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth(),
                color = SumarTheme.colors.secondaryAction,
                // Figma's unfilled track is plain white, not a tinted/translucent teal.
                trackColor = Color.White,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "1:24",
                    style = SumarTheme.typography.timestamp,
                    color = SumarTheme.colors.secondaryAction,
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.SkipPrevious,
                        contentDescription = "Previous",
                        tint = SumarTheme.colors.secondaryAction,
                        // TODO: wire to a real "skip back" action once the audio engine exists.
                        modifier = Modifier.size(32.dp).clickable { },
                    )
                    Icon(
                        imageVector = if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                        contentDescription = if (isPlaying) "Pause" else "Play",
                        tint = SumarTheme.colors.secondaryAction,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { isPlaying = !isPlaying },
                    )
                    Icon(
                        imageVector = Icons.Filled.SkipNext,
                        contentDescription = "Next",
                        tint = SumarTheme.colors.secondaryAction,
                        // TODO: wire to a real "skip forward" action once the audio engine exists.
                        modifier = Modifier.size(32.dp).clickable { },
                    )
                }

                Text(
                    text = "3:45",
                    style = SumarTheme.typography.timestamp,
                    color = SumarTheme.colors.secondaryAction,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PlayerScreenPreview() {
    SumarTheme {
        PlayerScreen(onBackClick = {})
    }
}
