package com.example.thmanya.domain.repository

import com.example.thmanya.data.AudioArticle
import com.example.thmanya.data.Audiobook
import com.example.thmanya.data.HomeSectionsResponse
import com.example.thmanya.data.Podcast
import com.example.thmanya.data.PodcastEpisode
import com.example.thmanya.data.Section
import com.example.thmanya.domain.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by AsmaaHassan on 23,August,2025
 * Trufla Technology,
 * Cairo, Egypt.
 */
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class HomeRepository(private val api: ApiService) {

    suspend fun getHomeSections(): List<Section> = withContext(Dispatchers.IO) {
        val response = api.getHomeSections()

        // Sort the entire list of Section objects by their `order` property
        val sortedSections = response.sections.sortedBy { it.order }

        // Return the sorted list of Section objects directly
        return@withContext sortedSections
    }
}
//class HomeRepository(private val api: ApiService) {
//    private val json = Json { ignoreUnknownKeys = true }
//
//    suspend fun getHomeSections(): List<Pair<String, List<Any>>> {
//        val response = api.getHomeSections()
//
//        return response.sections.map { section ->
//            val items: List<Any> = when (section.contentType) {
//                "podcast" -> section.content.map { json.decodeFromJsonElement<Podcast>(it) }
//                "podcast_episode" -> section.content.map { json.decodeFromJsonElement<PodcastEpisode>(it) }
//                "audio_article" -> section.content.map { json.decodeFromJsonElement<AudioArticle>(it) }
//                "audio_book" -> section.content.map { json.decodeFromJsonElement<Audiobook>(it) }
//                else -> emptyList()
//            }
//            section.name to items
//        }
//    }
//}
