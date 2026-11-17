package dev.mj.linkbox.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Ink = Color(0xFF1B1F24)
private val Paper = Color(0xFFF7F5F0)
private val Accent = Color(0xFF2F5E8C)
private val AccentDark = Color(0xFF9CC3EA)

private val LightColors = lightColorScheme(
    primary = Accent,
    background = Paper,
    surface = Paper,
    onBackground = Ink,
    onSurface = Ink,
)

private val DarkColors = darkColorScheme(
    primary = AccentDark,
    background = Ink,
    surface = Ink,
    onBackground = Paper,
    onSurface = Paper,
)

@Composable
fun LinkboxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content,
    )
}
