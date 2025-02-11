package com.example.logix.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define colors for Light and Dark mode
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF007BFF), // Electric Blue
    secondary = Color(0xFF647D91), // Stone Blue
    background = Color.White, // White Background
    surface = Color(0xFFB0C4DE), // Pastel Blue
    onPrimary = Color(0xFF240775), // White text on primary
    onSecondary = Color.Black, // Black text on secondary
    onBackground = Color(0xFF1E3A8A), // Dark Navy text
    onSurface = Color.Black // Black text on surface
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFFFFF), // Electric Blue
    secondary = Color(0xFF647D91), // Stone Blue
    background = Color(0xFF121C2D), // Blue-Gray Background
    surface = Color(0xFF121C2D), // Deep Navy
    onPrimary = Color(0xFFFFC107), // White text on primary
    onSecondary = Color.Red, // White text on secondary
    onBackground = Color(0xFFF4E1C1), // Sand-colored text
    onSurface = Color(0xFFF4E1C1) // White text on surface
)

@Composable
fun LogixTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
