package com.example.thmanya.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thmanya.domain.network.ApiClient
import com.example.thmanya.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
/**
 * Created by AsmaaHassan on 23,August,2025
 * Cairo, Egypt.
 */


class HomeViewModel(
    private val repository: HomeRepository = HomeRepository(ApiClient.api)
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState
    // State to control the visibility of the search dialog/field
    val showSearchField=  mutableStateOf(false)

    val noSearchData=  mutableStateOf(false)

    init {
        fetchSections()
    }

    fun fetchSections() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val response = repository.getHomeSections()
                _uiState.value = HomeUiState.Success(response)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun search() {
        viewModelScope.launch {
            try {
                val response = repository.searchHomeSections()
                // عرض المعلومات اذا كانت موجودة
                if (response.isEmpty())
                    noSearchData.value = true
                else {
                    // عرض رسالة لا يوجد معلومات اذا كانت خالية
                    _uiState.value = HomeUiState.Success(response)
                }

                showSearchField.value= false
            } catch (e: Exception) {
                // عرض رسالة لا يوجد معلومات اذا حدث خطأ
                noSearchData.value = true
            }
        }
    }
}
