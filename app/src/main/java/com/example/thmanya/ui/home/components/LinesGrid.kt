//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//// Video composable remains the same
//@Composable
//fun VideoItem(video: Video) {
//    Column(
//        modifier = Modifier
//            .width(200.dp)
//            .padding(8.dp)
//    ) {
//        Image(
//            painter = painterResource(id = video.imageUrl),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(16f / 9f)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Column {
//            Text(text = video.timeAgo)
//            Text(text = video.author, maxLines = 1, overflow = TextOverflow.Ellipsis)
//            Text(text = video.title, maxLines = 2, overflow = TextOverflow.Ellipsis)
//        }
//    }
//}
//
//@Composable
//fun UnifiedGridScreen() {
//    // Single list containing all grid items
//    val gridItems = listOf(
//        GridItem.HorizontalRow(
//            listOf(
//                Video(
//                    title = "د. فيصل الرفاعي | هل استطاع الإنسان مواكبة التطور؟",
//                    imageUrl = R.drawable.video_thumbnail_1,
//                    timeAgo = "قبل 5 ساعات",
//                    author = "د. فيصل الرفاعي"
//                ),
//                Video(
//                    title = "The Subscription Trap",
//                    imageUrl = R.drawable.video_thumbnail_2,
//                    timeAgo = "قبل 5 ساعات",
//                    author = "Planet Money"
//                )
//            )
//        ),
//        GridItem.HorizontalRow(
//            listOf(
//                Video(
//                    title = "Video Title for Row 2, Item 1",
//                    imageUrl = R.drawable.video_thumbnail_3,
//                    timeAgo = "2 hours ago",
//                    author = "Creator 1"
//                ),
//                Video(
//                    title = "Another title for the second row",
//                    imageUrl = R.drawable.video_thumbnail_4,
//                    timeAgo = "1 day ago",
//                    author = "Creator 2"
//                )
//            )
//        )
//    )
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // `items` with a key to handle different item types
//        items(gridItems) { item ->
//            when (item) {
//                is GridItem.HorizontalRow -> {
//                    LazyRow(
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        items(item.videos) { video ->
//                            VideoItem(video = video)
//                        }
//                    }
//                }
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewUnifiedGridScreen() {
//    UnifiedGridScreen()
//}
//sealed interface GridItem {
//    data class HorizontalRow(val videos: List<Video>) : GridItem
//}
//
//data class Video(
//    val title: String,
//    val imageUrl: Int,
//    val timeAgo: String,
//    val author: String
//)