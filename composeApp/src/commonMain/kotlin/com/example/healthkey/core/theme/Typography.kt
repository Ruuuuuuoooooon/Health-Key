package com.example.healthkey.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(
    displayLarge  = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold,     lineHeight = 32.sp),
    displayMedium = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold,     lineHeight = 28.sp),
    displaySmall  = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold, lineHeight = 26.sp),
    headlineLarge = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold, lineHeight = 24.sp),
    headlineMedium= TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold, lineHeight = 22.sp),
    headlineSmall = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium,   lineHeight = 20.sp),
    titleLarge    = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold, lineHeight = 20.sp),
    titleMedium   = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Medium,   lineHeight = 18.sp),
    titleSmall    = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium,   lineHeight = 16.sp),
    bodyLarge     = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal,   lineHeight = 20.sp),
    bodyMedium    = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Normal,   lineHeight = 18.sp),
    bodySmall     = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal,   lineHeight = 16.sp),
    labelLarge    = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium,   lineHeight = 16.sp),
    labelMedium   = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Medium,   lineHeight = 14.sp),
    labelSmall    = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Normal,   lineHeight = 14.sp),
)
