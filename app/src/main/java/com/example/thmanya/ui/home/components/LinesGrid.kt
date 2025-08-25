import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.R
import coil.compose.AsyncImage
import com.example.thmanya.data.Content
import com.example.thmanya.ui.theme.plexsansArabicMedium

@Composable
fun GridItem(item: Content) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .width(300.dp), // Adjust width as needed
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = item.avatarUrl,
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ic_call_answer_video), // add a drawable in res/drawable
            error = painterResource(R.drawable.ic_call_answer_video) // add a drawable in res/drawable
        )

        // Text Content
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(text = item.name, fontFamily = plexsansArabicMedium)
        }
    }
}
@Composable
fun HorizontalGridRow(itemList: List<Content>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth().height(100.dp), // Adjust height as needed
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(itemList) { item ->
            GridItem(item)
        }
    }
}
@Composable
fun TwoLineGridScreen(allItems: List<Content>) {
    // Split the list in half
    val midPoint = allItems.size / 2
    val topRowItems = allItems.take(midPoint)
    val bottomRowItems = allItems.drop(midPoint)

    LazyColumn(
        Modifier.height(250.dp)
    ) {
        // Top row
        item {
            HorizontalGridRow(itemList = topRowItems)
        }

        // Bottom row
        item {
            HorizontalGridRow(itemList = bottomRowItems)
        }
    }
}

