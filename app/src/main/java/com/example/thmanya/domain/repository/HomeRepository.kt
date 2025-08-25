package com.example.thmanya.domain.repository

import com.example.thmanya.data.Section
import com.example.thmanya.domain.network.ApiClient.apiSearch
import com.example.thmanya.domain.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by AsmaaHassan on 23,August,2025
 * Cairo, Egypt.
 */

class HomeRepository(private val api: ApiService) {

    suspend fun getHomeSections(): List<Section> = withContext(Dispatchers.IO) {
        val response = api.getHomeSectionsApi()

        // Sort the entire list of Section objects by their `order` property
        val sortedSections = response.sections.sortedBy { it.order }

        // Return the sorted list of Section objects directly
        return@withContext sortedSections
    }

    suspend fun searchHomeSections(): List<Section> = withContext(Dispatchers.IO) {
        val response = apiSearch.searchApi()

        // Sort the entire list of Section objects by their `order` property
        val sortedSections = response.sections.sortedBy { it.order }

        // Return the sorted list of Section objects directly
        return@withContext sortedSections
    }
}
