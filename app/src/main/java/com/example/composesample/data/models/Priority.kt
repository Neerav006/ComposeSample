package com.example.composesample.data.models

import androidx.compose.ui.graphics.Color
import com.example.composesample.ui.theme.HighPriorityColor
import com.example.composesample.ui.theme.LowPriorityColor
import com.example.composesample.ui.theme.MediumPriorityColor
import com.example.composesample.ui.theme.NonePriorityColor


enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}