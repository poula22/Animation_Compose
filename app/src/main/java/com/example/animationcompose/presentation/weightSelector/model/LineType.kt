package com.example.animationcompose.presentation.weightSelector.model

sealed interface LineType {
    data object Normal: LineType
    data object FiveStep: LineType
    data object TenStep: LineType
}