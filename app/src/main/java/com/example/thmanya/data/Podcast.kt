package com.example.thmanya.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by AsmaaHassan on 23,August,2025
 * Cairo, Egypt.
 */


@Serializable
@SerialName("podcast")
data class Podcast(
    @SerialName("podcast_id")
    override val id: String,
    @SerialName("episode_count") val episodeCount: Int = 0,
    val duration: Int = 0,
    val language: String = "",
    val priority: Int = 0,
    val popularityScore: Int = 0,
    val score: Double = 0.0
):Content()

@Serializable
@SerialName("unknown")
data class UnknownContent(
    override val id: String = ""
) : Content()