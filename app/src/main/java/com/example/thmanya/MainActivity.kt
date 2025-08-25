package com.example.thmanya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.thmanya.home.components.HomeScreen
import com.example.thmanya.ui.theme.ThmanyaTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thmanya.ui.home.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ThmanyaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainAppScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainAppScreen() {
        // State to hold the user's search query
        var searchQuery by remember { mutableStateOf("") }

        val snackbarHostState = remember { SnackbarHostState() }

        val scope = rememberCoroutineScope()

        // This LaunchedEffect implements the 200ms debounce
        LaunchedEffect(searchQuery) {
            delay(200) // The debounce delay
            if (searchQuery.isNotBlank()) {
                homeViewModel.search()

            }
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.black),
                        titleContentColor = colorResource(id = R.color.white),
                    ),
                    title = {
                        Row {


                            Image(
                                painterResource(id = R.drawable.thmnya),
                                contentDescription = "Thmanya",
                                Modifier
                                    .size(55.dp)
                                    .padding(start = 10.dp, end = 10.dp)
                            )
                            Text(stringResource(id = R.string.app_name), modifier= Modifier.align(Alignment.CenterVertically))
                        }
                    },
                    navigationIcon = {


                    },
                )
            },
            snackbarHost = { SnackbarHost(snackbarHostState) },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    homeViewModel.showSearchField.value = !homeViewModel.showSearchField.value
                }) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                if (homeViewModel.showSearchField.value) {
                    // The TextField where the user types
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = { Text("Search...") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                HomeScreen(homeViewModel)
            }
            if (homeViewModel.noSearchData.value) {
                val message = "No search data found"
                // Show snackbar when error occurs
                LaunchedEffect(message) {
                    launch {
                        snackbarHostState.showSnackbar(
                            message = message,
                            withDismissAction = true
                        )
                    }
                    // الرجوع الى القيمة الاساسية حتى نمكه من الظهور مرة اخرى
                    homeViewModel.noSearchData.value = false
                }
            }
        }
    }
}