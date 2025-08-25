package com.example.thmanya.ui.home

import com.example.thmanya.data.Section

/**
 * Created by AsmaaHassan on 23,August,2025
 * Cairo, Egypt.
 */
sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val sections: List<Section>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}
