package com.example.thmanya.home.components

/**
 * Created by AsmaaHassan on 23,August,2025
 * Trufla Technology,
 * Cairo, Egypt.
 */
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thmanya.data.AudioArticle
import com.example.thmanya.data.Audiobook
import com.example.thmanya.data.Podcast
import com.example.thmanya.data.PodcastEpisode
import com.example.thmanya.data.Section
import com.example.thmanya.ui.home.HomeUiState
import com.example.thmanya.ui.home.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is HomeUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is HomeUiState.Error -> {
            val message = (uiState as HomeUiState.Error).message
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: $message")
            }
        }
        is HomeUiState.Success -> {
            val sections = (uiState as HomeUiState.Success).sections as List<Section>
            LazyColumn {
                sections.forEach { section ->
                    item {
                        Text(
                            text = section.name,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

//                    items(itemsList) { item ->
//                        when (item) {
//                            is Podcast -> Text("🎙️ Podcast: ${item.name}")
//                              is PodcastEpisode -> Text("▶️ Episode: ${item.name}")
//                            is Audiobook -> Text("📚 Audiobook: ${item.name} by ${item.authorName}")
//                            is AudioArticle -> Text("📰 Article: ${item.name} by ${item.authorName}")
//                        }
//                    }
                }
            }
        }
    }
}
/*
//                    item {
//                        when(section.type){
//                            LayoutType.QUEUE->
//                            {
//                                                        Text(
//                            text = section.name,
//                            style = MaterialTheme.typography.titleLarge,
//                            modifier = Modifier.padding(8.dp)
//                        )
//                            }
//
//                            LayoutType.BIG_SQUARE -> {
//                                                        Text(
//                            text = section.name,
//                            style = MaterialTheme.typography.titleLarge,
//                            modifier = Modifier.padding(8.dp)
//                        )
//                            }
//                            LayoutType.TWO_LINES_GRID -> {
//                                                        Text(
//                            text = section.name,
//                            style = MaterialTheme.typography.titleLarge,
//                            modifier = Modifier.padding(8.dp)
//                        )
//                            }
//                            LayoutType.UNKNOWN -> {
//                                                        Text(
//                            text = section.name +"unknowns",
//                            style = MaterialTheme.typography.titleLarge,
//                            modifier = Modifier.padding(8.dp)
//                        )
//                            }
//                            else->{
//                                                        Text(
//                            text = "No Typee",
//                            style = MaterialTheme.typography.titleLarge,
//                            modifier = Modifier.padding(8.dp)
//                        )
//                            }
//                        }
 */