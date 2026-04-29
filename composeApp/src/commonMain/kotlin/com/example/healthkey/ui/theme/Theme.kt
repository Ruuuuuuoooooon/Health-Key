package com.example.healthkey.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AppColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    onPrimary = Color.White,
    primaryContainer = PrimaryGreenContainer,
    onPrimaryContainer = TagGreenText,
    secondary = AthleteTeal,
    onSecondary = Color.White,
    secondaryContainer = AthleteTealContainer,
    tertiary = DoctorBlue,
    onTertiary = Color.White,
    tertiaryContainer = DoctorBlueContainer,
    background = Surface,
    onBackground = OnSurface,
    surface = Color.White,
    onSurface = OnSurface,
    surfaceVariant = CardGreen,
    onSurfaceVariant = TextSecondary,
    outline = CardBorder,
    error = TagRedText,
    onError = Color.White,
    errorContainer = TagRedBg,
)

@Composable
fun HealthKeyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = AppTypography,
        content = content,
    )
}
