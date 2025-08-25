package com.example.thmanya.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by AsmaaHassan on 25,August,2025
 * Cairo, Egypt.
 */

@Serializable
@SerialName("audio_book")
data class Audiobook(
    @SerialName("audiobook_id")
    override val id: String,
    @SerialName("author_name") val authorName: String = "",
    val duration: Int = 0,
    val language: String = "",
    @SerialName("release_date") val releaseDate: String = "",
    val score: Int = 0
): Content()