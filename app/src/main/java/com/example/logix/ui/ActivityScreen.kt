package com.example.logix.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.logix.R
import com.example.logix.data.LogixItem
import com.example.logix.data.searchOptions
import com.example.logix.ui.theme.LogixTheme

@Composable
fun ActivityScreen (
    logixItem: List<LogixItem>,
    modifier: Modifier = Modifier,
    navController: NavController,
    onBackButtonPressed: () -> Unit
) {

    val activity = LocalActivity.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ActivityTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onBackButtonPressed = { activity?.finish() }
        )

        ActivityFeedSubject(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        ActivitySearchBox(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        ActivityFeedList(
            activityFeed = logixItem,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}



@Composable
fun ActivityFeedList(
    modifier: Modifier,
    activityFeed: List<LogixItem>
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(activityFeed) { activityFeedItem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                ActivityFeedCard(
                    drawableResource = activityFeedItem.image ,
                    title = activityFeedItem.title,
                    date = activityFeedItem.date,
                    description = activityFeedItem.description,
                )
            }
        }
    }
}


@Composable
fun ActivityFeedCard(
    @DrawableRes drawableResource: Int,
    @StringRes title: Int,
    @StringRes date: Int,
    @StringRes description: Int,
) {

    val isDarkTheme = isSystemInDarkTheme()

    val textColor = if (isDarkTheme) {
        Color(0xFFF4E1C1)
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Image(
            painter = painterResource(id = drawableResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
                )

            Text(
                text = stringResource(id = description),
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Serif,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
            )

            Text(
                text = stringResource(id = date),
                style = MaterialTheme.typography.bodySmall,
                color = textColor
            )
        }
    }
}

@Composable
fun ActivityFeedSubject(
    modifier: Modifier
) {
    Box(
        Modifier
            .padding(top = 8.dp,start = 10.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.discover),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
            )
            Text(
                text = stringResource(id = R.string.subheading),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
            )
        }
    }
}


@Composable
fun ActivityTopBar(
    modifier: Modifier = Modifier,
    onBackButtonPressed: () -> Unit
){
    val activity = LocalActivity.current as? Activity

    val isDarkTheme = isSystemInDarkTheme()


    val textColor = if (isDarkTheme) {
        Color(0xFFF4E1C1)
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 10.dp, height = 60.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)

        ) {
            IconButton(onClick = { activity?.finish() },
                enabled = true) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_button),
                    tint = textColor,
                    modifier = Modifier
                        .padding(horizontal = 2.dp)
                )
            }

            Text(text = stringResource(id = R.string.your_feed),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center

           )

//            Spacer(modifier = Modifier.width(100.dp))

            IconButton(onClick = {  }) {
                Image(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    colorFilter = ColorFilter.tint(color = textColor),
                    contentDescription = stringResource(id = R.string.menu),
                    modifier = Modifier

                )
            }

            BackHandler {
                activity?.finish()
            }
        }
    }
}

@Composable
fun ActivitySearchBox(
    modifier: Modifier = Modifier,
    placeholderText: String = stringResource(id = R.string.searching)
) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text(text = placeholderText) },
            shape = RoundedCornerShape(32.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .border(1.dp, Color.DarkGray, RoundedCornerShape(32.dp))
        )

        Spacer(modifier = Modifier.height(12.dp))

        SearchOptions(searchOptions = searchOptions  ) { }
    }
}

@Composable
fun SearchOptions(
    searchOptions: List<String>,
    onTextClick: (String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(searchOptions) { text ->
            Text(
                text = text,
                modifier = Modifier
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(12.dp))
                    .padding(horizontal = 8.dp)
                    .clickable { onTextClick(text) },
                style = MaterialTheme.typography.titleMedium,
                )
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ActivityScreenPreview() {
//    LogixTheme {
//        // Mock data for preview
//        val mockLogixItems = listOf(
//            LogixItem(
//                title = R.string.tech,
//                description = R.string.tech_news,
//                image = R.drawable.windows11,
//                date = R.string.tech_date
//            ),
//            LogixItem(
//                title = R.string.sports,
//                description = R.string.sports_news,
//                image = R.drawable.tilak,
//                date = R.string.sports_date
//            ),
//            LogixItem(
//                title = R.string.international,
//                description = R.string.international_news,
//                image = R.drawable.trump,
//                date = R.string.international_date
//            ),
//            LogixItem(
//                title = R.string.politics,
//                description = R.string.politics_news,
//                image = R.drawable.flights,
//                date = R.string.politics_date
//            ),
//            LogixItem(
//                title = R.string.latest,
//                description = R.string.latest_news,
//                image = R.drawable.republic,
//                date = R.string.latest_date
//            )
//        )
//
//        // Display the ActivityScreen with mock data
//        ActivityScreen(logixItem = mockLogixItems)
//    }
//}




@Preview(showBackground = true)
@Composable
private fun ActivityTopBarPreview() {
    LogixTheme {
        ActivityTopBar {

        }
    }
}
//
//@Preview (showBackground = true)
//@Composable
//private fun ActivityFeedSubjectPreview() {
//    LogixTheme {
//        ActivityFeedSubject(modifier = Modifier)
//    }
//}
//
//@Preview (showBackground = true)
//@Composable
//private fun ActivitySearchBoxPreview() {
//    LogixTheme {
//        ActivitySearchBox()
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ActivityFeedListPreview() {
//    LogixTheme {
//        ActivityFeedList(
//            modifier = Modifier,
//            activityFeed =
//            listOf(
//            LogixItem(
//                title = R.string.tech,
//                description = R.string.tech_news,
//                image = R.drawable.windows11,
//                date = R.string.tech_date
//            ),
//
//            LogixItem(
//                title = R.string.sports,
//                description = R.string.sports_news,
//                image = R.drawable.tilak,
//                date = R.string.sports_date
//            ),
//
//            LogixItem(
//                title = R.string.international,
//                description = R.string.international_news,
//                image = R.drawable.trump,
//                date = R.string.international_date
//            ),
//
//            LogixItem(
//                title = R.string.politics,
//                description = R.string.politics_news,
//                image = R.drawable.flights,
//                date = R.string.politics_date
//            ),
//
//            LogixItem(
//                title = R.string.republic_day,
//                description = R.string.latest_news,
//                image = R.drawable.republic,
//                date = R.string.latest_date
//            ),
//
//            LogixItem(
//                title = R.string.latest,
//                description = R.string.cbi_news,
//                image = R.drawable.cbi,
//                date = R.string.cbi_date
//            ),
//
//            LogixItem(
//                title = R.string.latest,
//                description = R.string.doctor_news,
//                image = R.drawable.doctor,
//                date = R.string.doctor_date
//            )
//        )
//        )

//         Call the NewsFeedList with the sample data
//        MaterialTheme {
//            ActivityFeedList(activityFeed = sampleNewsFeed)
//        }
//    }
//}


