package com.laurentvrevin.animatedclockjetpackcompose.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = ClockBorderColor, // Utilisez ClockBorderColor comme base
    secondary = HourHandColor,
    tertiary = MinuteHandColor,
    background = BackgroundColor,
    surface = ClockBackgroundColor,
    onPrimary = TextColor,
    onSecondary = TextColor,
    onTertiary = TextColor,
    onBackground = TextColor,
    onSurface = TextColor
)

private val LightColorScheme = lightColorScheme(
    primary = ClockBorderColor, // Utilisez ClockBorderColor comme base
    secondary = HourHandColor,
    tertiary = MinuteHandColor,
    background = BackgroundColor,
    surface = ClockBackgroundColor,
    onPrimary = TextColor,
    onSecondary = TextColor,
    onTertiary = TextColor,
    onBackground = TextColor,
    onSurface = TextColor
)

@Composable
fun AnimatedClockJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}