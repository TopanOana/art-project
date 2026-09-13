package com.oanatopan.artproject.sumar

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import com.alexgabor.design.navigation.RisoNavigation
import com.alexgabor.design.navigation.rememberDeepLinkedBackStack
import com.oanatopan.artproject.sumar.feature.credits.CreditsScreen
import com.oanatopan.artproject.sumar.feature.player.PlayerScreen
import com.oanatopan.artproject.sumar.feature.title.TitleScreen
import kotlinx.serialization.Serializable

/**
 * The app's three screens.
 *
 * No deep-linking wired up yet — `rememberDeepLinkedBackStack` always falls back to [initial]
 * until something calls `pacer`'s `DeepLinks.kt` equivalent for SUMAR (e.g. sumar://player).
 *
 * `RisoNavigation` comes from `design:navigation` (still `com.alexgabor`'s module — it's a
 * generic NavDisplay wrapper with slide transitions + deep-link plumbing, not tied to the Riso
 * theme, despite the name). Reused as-is rather than forked, since SUMAR only needed a fresh
 * *theme*, not fresh navigation infrastructure.
 */
@Serializable
internal sealed interface RootDestination : NavKey {
    @Serializable
    data object Title : RootDestination

    @Serializable
    data object Player : RootDestination

    @Serializable
    data object Credits : RootDestination
}

@Composable
fun RootNavigation() {
    val nav = rememberDeepLinkedBackStack(RootDestination.serializer()) {
        listOf(RootDestination.Title)
    }

    RisoNavigation(
        nav = nav,
        entryProvider = entryProvider {
            entry<RootDestination.Title> {
                TitleScreen(
                    onStartClick = { nav.backStack.add(RootDestination.Player) },
                    onCreditsClick = { nav.backStack.add(RootDestination.Credits) },
                )
            }
            entry<RootDestination.Player> {
                PlayerScreen(onBackClick = { nav.backStack.removeLastOrNull() })
            }
            entry<RootDestination.Credits> {
                CreditsScreen(onBackClick = { nav.backStack.removeLastOrNull() })
            }
        },
    )
}
