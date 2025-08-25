package com.example.thmanya.domain.network
import com.example.thmanya.data.AudioArticle
import com.example.thmanya.data.Audiobook
import com.example.thmanya.data.Content
import com.example.thmanya.data.Episode
import com.example.thmanya.data.HomeSectionsResponse
import com.example.thmanya.data.Podcast
import com.example.thmanya.data.UnknownContent
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

/**
 * Created by AsmaaHassan on 23,August,2025
 * Cairo, Egypt.
 */

interface ApiService {
    @GET("home_sections")
    suspend fun getHomeSectionsApi(): HomeSectionsResponse
    @GET("search")
    suspend fun searchApi(): HomeSectionsResponse
}

object ApiClient {
    private val apiModule = SerializersModule {
        polymorphic(Content::class) {
            subclass(Podcast::class)
            subclass(Audiobook::class)
            subclass(AudioArticle::class)
            subclass(Episode::class)
            defaultDeserializer { UnknownContent.serializer() }
        }
    }

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        // The class discriminator to use the "content_type" field from the JSON
        classDiscriminator = "content_type"
        serializersModule = apiModule
    }

    private val contentType = "application/json".toMediaType()

    val api: ApiService = Retrofit.Builder()
        .baseUrl("https://api-v2-b2sit6oh3a-uc.a.run.app/")
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()
        .create(ApiService::class.java)

    val apiSearch: ApiService = Retrofit.Builder()
        .baseUrl("https://mock.apidog.com/m1/735111-711675-default/")
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()
        .create(ApiService::class.java)


}
