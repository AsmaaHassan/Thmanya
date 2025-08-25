package com.example.thmanya.data

import com.example.thmanya.ui.home.components.LayoutType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.json.JsonElement

/**
 * Created by AsmaaHassan on 23,August,2025
 * Cairo, Egypt.
 */

@Serializable
data class HomeSectionsResponse(
    val sections: List<Section>
)

@Serializable
sealed class Content {
    abstract val id: String
    @SerialName("avatar_url") val avatarUrl: String = ""
    val name: String = ""
    val description: String = ""
}
@Serializable
data class Section(
    val name: String,
    val type: String,
    @SerialName("content_type")
    val contentType: String,
    val order: Int,
    val content: List<Content>  // could be type of [podcast, audio_book, episode]
)