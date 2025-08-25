package com.example.thmanya.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by AsmaaHassan on 25,August,2025
 * Cairo, Egypt.
 */

@Serializable
@SerialName("audio_article")
data class AudioArticle(
    @SerialName("article_id")
    override val id: String,
    @SerialName("author_name") val authorName: String = "",
    val duration: Int = 0,
    @SerialName("release_date") val releaseDate: String = "",
    val score: Int = 0
):Content()
