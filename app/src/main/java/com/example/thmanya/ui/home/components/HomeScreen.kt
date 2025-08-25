package com.example.thmanya.home.components

/**
 * Created by AsmaaHassan on 23,August,2025
 * Cairo, Egypt.
 */
import TwoLineGridScreen
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.thmanya.data.Section
import com.example.thmanya.ui.home.HomeUiState
import com.example.thmanya.ui.home.HomeViewModel
import com.example.thmanya.ui.home.components.HorizontalImageList
import com.example.thmanya.ui.home.components.LayoutType
import com.example.thmanya.ui.home.components.QueueList
import com.example.thmanya.ui.home.components.sectionView

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
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
                    when (section.type) {
                        LayoutType.SQUARE ->
                            item {
                                sectionView(section.name) {
                                    HorizontalImageList(false, section.content)
                                }
                            }
                        LayoutType.BIG_SQUARE ->
                            item {
                                sectionView(section.name) {
                                    HorizontalImageList(true, section.content)
                                }
                            }
                        LayoutType.TWO_LINES_GRID ->
                        item {
                            sectionView(title = section.name) {
                                TwoLineGridScreen(section.content)
                            }
                        }
                        LayoutType.QUEUE -> item {
                            sectionView(title = section.name) {
                                QueueList(section.content)
                            }
                        }
                    }
                }
            }
        }
    }
}