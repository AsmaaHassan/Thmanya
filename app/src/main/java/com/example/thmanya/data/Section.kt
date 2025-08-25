package com.example.thmanya.data

import com.example.thmanya.ui.home.components.LayoutType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.json.JsonElement

/**
 * Created by AsmaaHassan on 22,August,2025
 * Trufla Technology,
 * Cairo, Egypt.
 */
//@Serializable
//data class HomeSectionsResponse(
//    val sections: List<Section>
//)
//
//@Serializable
//data class Section(
//    val name: String,
//    val type: String,
//    @SerialName("content_type") val contentType: String,
//    val order: Int,
//    val content: List<ContentItem>
//)
////
////@Serializable
////@JsonClassDiscriminator("content_type") // look at "content_type" to know the type
////sealed class ContentItem {
////    abstract val name: String
////    abstract val description: String?
////    abstract val avatarUrl: String?
////}

@Serializable
data class HomeSectionsResponse(
    val sections: List<Section>
)

@Serializable
sealed class Content {
    abstract val id: String
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

//@JsonClassDiscriminator("content_type")
//@Serializable
//sealed class ContentItem {
//    abstract val name: String
//    abstract val description: String?
//    abstract val avatarUrl: String?
//}

/* ----------- Subtypes ----------- */

//@Serializable
//@SerialName("podcast")
//data class PodcastContent(
//    @SerialName("podcast_id") val podcastId: String,
////    override val name: String,
////    override val description: String?,
////    @SerialName("avatar_url") override val avatarUrl: String?,
//    val name: String,
//    val description: String? = null,
//    @SerialName("avatar_url") val avatarUrl: String? = null,
//    @SerialName("episode_count") val episodeCount: Int,
//    val duration: Long? = null,
//    val language: String? = null,
//    val priority: Int? = null,
//    val popularityScore: Int? = null,
//    val score: Double? = null
//)
//
//@Serializable
//@SerialName("podcast_episode")
//data class PodcastEpisodeContent(
//    @SerialName("episode_id") val episodeId: String,
//    val name: String,
//    val description: String? = null,
//    @SerialName("avatar_url") val avatarUrl: String? = null,
//    @SerialName("podcast_id") val podcastId: String,
//    @SerialName("podcast_name") val podcastName: String? = null,
//    val duration: Long? = null,
//    @SerialName("audio_url") val audioUrl: String? = null,
//    @SerialName("release_date") val releaseDate: String? = null,
//    val score: Double? = null
//) : ContentItem()
//
//@Serializable
//@SerialName("audiobook")
//data class AudiobookContent(
//    @SerialName("audiobook_id") val audiobookId: String,
//    override val name: String,
//    override val description: String?,
//    @SerialName("avatar_url") override val avatarUrl: String?,
//    @SerialName("author_name") val authorName: String,
//    val duration: Long,
//    val language: String,
//    @SerialName("release_date") val releaseDate: String,
//    val score: Int
//)
//
//@Serializable
//@SerialName("audio_article")
//data class AudioArticleContent(
//    @SerialName("article_id") val articleId: String,
//    override val name: String,
//    override val description: String?,
//    @SerialName("avatar_url") override val avatarUrl: String?,
//    @SerialName("author_name") val authorName: String,
//    val duration: Long,
//    @SerialName("release_date") val releaseDate: String,
//    val score: Int
//)
