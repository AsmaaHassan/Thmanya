package com.example.thmanya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thmanya.home.components.HomeScreen
import com.example.thmanya.ui.home.components.HorizontalImageList
import com.example.thmanya.ui.home.components.sectionView
import com.example.thmanya.ui.theme.ThmanyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val urls = listOf(
            "https://images.stockcake.com/public/6/f/6/6f6a0565-96eb-4dda-8c8f-9c0d9a8afdf0_large/vivid-sunset-sky-stockcake.jpg",
            "https://images.stockcake.com/public/6/f/6/6f6a0565-96eb-4dda-8c8f-9c0d9a8afdf0_large/vivid-sunset-sky-stockcake.jpg",
            "https://images.stockcake.com/public/6/f/6/6f6a0565-96eb-4dda-8c8f-9c0d9a8afdf0_large/vivid-sunset-sky-stockcake.jpg"
        )


        setContent {
            ThmanyaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    sectionView("اسماء حسن"){
                        HorizontalImageList(imageUrls = urls)
                    }
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val urls = listOf(
        "https://picsum.photos/200/300",
        "https://picsum.photos/300/300",
        "https://picsum.photos/400/300"
    )
    ThmanyaTheme {
//        Greeting("Android")
        sectionView("اسماء حسن"){
            HorizontalImageList(imageUrls = urls)
        }
    }
}