package com.example.thmanya.ui.home.components
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.thmanya.data.Content

/**
 * Created by AsmaaHassan on 22,August,2025
 * Cairo, Egypt.
 */

@Composable
fun HorizontalImageList(
    isBig:Boolean=false,
    imageUrls: List<Content>
) {
    Column {

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
//                .height(300.dp)
                .padding(top=20.dp, bottom = 20.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(imageUrls) { imageUrl ->
                AsyncImage(
                    model = imageUrl.avatarUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .width(if (isBig) 170.dp else 120.dp)
                        .height(120.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(androidx.core.R.drawable.ic_call_answer_video), // add a drawable in res/drawable
                    error = painterResource(androidx.core.R.drawable.ic_call_answer_video) // add a drawable in res/drawable
                )
            }


    }
}}
@Preview
@Composable
fun previewList(){
    val urls = listOf(
        "https://picsum.photos/200/300",
        "https://picsum.photos/300/300",
        "https://picsum.photos/400/300"
    )

//    HorizontalImageList(imageUrls = urls)
}