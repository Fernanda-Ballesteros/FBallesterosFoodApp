package com.example.fballesterosfoodapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fballesterosfoodapp.R

// Set of Material typography styles to start with
val outfitFontFamily = FontFamily(
    Font(R.font.outfit)
)

val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = outfitFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = outfitFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )
)
