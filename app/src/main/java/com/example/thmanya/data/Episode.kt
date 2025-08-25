package com.example.thmanya.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by AsmaaHassan on 25,August,2025
 * Cairo, Egypt.
 */

@Serializable
@SerialName("episode")
data class Episode(
    @SerialName("episode_id")
    override val id: String,
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

