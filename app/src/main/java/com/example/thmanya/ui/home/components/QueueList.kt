package com.example.thmanya.ui.home.components

import coil.compose.AsyncImage
import com.example.thmanya.data.Content
import com.example.thmanya.ui.theme.plexsansArabicLight
import com.example.thmanya.ui.theme.plexsansArabicSemiBold
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QueueCard(modifier: Modifier = Modifier, item:Content) {
    // This is the main container with a dark background and rounded corners
    Box(
        modifier = modifier
            .width(300.dp) // Adjust width as needed for your design
            .height(100.dp) // Adjust height as needed
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF2E2E33))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // The play button icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.White.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.width(12.dp))

            // Text content
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    color = Color.White,
                    fontFamily = plexsansArabicSemiBold
                )
                Text(
                    text = item.description,
                    color = Color.White.copy(alpha = 0.6f),
                    fontFamily = plexsansArabicLight
                )
            }

            AsyncImage(
                model = item.avatarUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(androidx.core.R.drawable.ic_call_answer_video), // add a drawable in res/drawable
                error = painterResource(androidx.core.R.drawable.ic_call_answer_video) // add a drawable in res/drawable
            )
        }
    }
}
@Composable
fun QueueList(items: List<Content>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            // Pass data to the composable if needed
            QueueCard(Modifier,item)
        }
    }
}