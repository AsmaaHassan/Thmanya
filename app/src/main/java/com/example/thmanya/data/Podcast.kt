package com.example.thmanya.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by AsmaaHassan on 22,August,2025
 * Trufla Technology,
 * Cairo, Egypt.
 */


//@JsonClassDiscriminator("content_type")
//@Serializable
//sealed class ContentItem {
//    abstract val name: String
//    abstract val description: String?
//    abstract val avatarUrl: String?
//}

@Serializable
@SerialName("podcast")
data class Podcast(
    @SerialName("podcast_id")
    override val id: String,
    val name: String = "",
    val description: String = "",
    @SerialName("avatar_url") val avatarUrl: String = "",
    @SerialName("episode_count") val episodeCount: Int = 0,
    val duration: Int = 0,
    val language: String = "",
    val priority: Int = 0,
    val popularityScore: Int = 0,
    val score: Double = 0.0
):Content()

@Serializable
@SerialName("podcast_episode")
data class PodcastEpisode(
    @SerialName("episode_id")
    override val id: String,
    val name: String = "",
    val description: String = "",
    @SerialName("avatar_url") val avatarUrl: String = "",
    @SerialName("podcastPopularityScore") val podcastPopularityScore: Int = 0,
    @SerialName("podcastPriority") val podcastPriority: Int = 0,

    @SerialName("season_number") val seasonNumber: Int = 0,
    @SerialName("episode_type") val episodeType: String = "",
    @SerialName("podcast_name") val podcastName: String = "",
    @SerialName("author_name") val authorName: String = "",
    val number: Int = 0,
    val duration: Int = 0,
    @SerialName("separated_audio_url") val separatedAudioUrl: String = "",
    @SerialName("audio_url") val audioUrl: String = "",
    @SerialName("release_date") val releaseDate: String = "",
    @SerialName("podcast_id") val podcastId: String = "",
    val chapters: List<String> = emptyList(),
    @SerialName("paid_is_early_access") val paidIsEarlyAccess: Boolean = false,
    @SerialName("paid_is_now_early_access") val paidIsNowEarlyAccess: Boolean = false,
    @SerialName("paid_is_exclusive") val paidIsExclusive: Boolean = false,
    @SerialName("paid_transcript_url") val paidTranscriptUrl: String = "",
    @SerialName("free_transcript_url") val freeTranscriptUrl: String = "",
    @SerialName("paid_is_exclusive_partially") val paidIsExclusivePartially: Boolean = false,
    @SerialName("paid_exclusive_start_time") val paidExclusiveStartTime: Int = 0,
    @SerialName("paid_early_access_date") val paidEarlyAccessDate: String = "",
    @SerialName("paid_early_access_audio_url") val paidEarlyAccessAudioUrl: String = "",
    @SerialName("paid_exclusivity_type") val paidExclusivityType: String = "",
    val score: Double = 0.0
):Content()

@Serializable
@SerialName("audio_article")
data class AudioArticle(
    @SerialName("article_id")
    override val id: String,
    val name: String = "",
    val description: String = "",
    @SerialName("avatar_url") val avatarUrl: String = "",
    @SerialName("author_name") val authorName: String = "",
    val duration: Int = 0,
    @SerialName("release_date") val releaseDate: String = "",
    val score: Int = 0
):Content()
/*
   {
                    "article_id": "article_001",
                    "name": "The Future of AI",
                    "author_name": "Tech World",
                    "description": "An in-depth look at the future impact of artificial intelligence.",
                    "avatar_url": "https://bookbrush.com/wp-content/uploads/BookBrushImage-2021-5-11-20-5227-1024x1024.jpg",
                    "duration": 1200,
                    "release_date": "2023-05-10T10:00:00Z",
                    "score": 300
                },
 */
@Serializable
@SerialName("audiobook")
data class Audiobook(
    @SerialName("audiobook_id")
    override val id: String,
    val name: String = "",
    val description: String = "",
    @SerialName("avatar_url") val avatarUrl: String = "",
    @SerialName("author_name") val authorName: String = "",
    val duration: Int = 0,
    val language: String = "",
    @SerialName("release_date") val releaseDate: String = "",
    val score: Int = 0
): Content()


