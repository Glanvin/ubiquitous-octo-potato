package com.seth.greenapple.ui.screens.home


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seth.greenapple.R
import com.seth.greenapple.utilities.Chips


@Composable
@Preview
fun HomeScreenViewPreview() {
    HomeView()
}

//TODO: Optimize
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    Scaffold {
        Card(
            modifier = Modifier
                .padding(8.dp),

            ) {
            Column(
                modifier = Modifier
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.bocchi),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
                )
                Spacer(Modifier.height(8.dp))
                Box(modifier = Modifier.align(alignment = Alignment.Start)) {

                    Column {
                        Text(
                            text = "Title",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "Body",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    //TODO: Move to ViewModel
                    val chipList = listOf(
                        Chips(
                            name = "Like",
                            icon = Icons.Outlined.FavoriteBorder,
                            pressIcon = Icons.Filled.Favorite,
                            updatedState = "Liked"
                        ),
                        Chips(
                            name = "Favorite",
                            icon = Icons.Outlined.Bookmark,
                            pressIcon = Icons.Filled.Bookmark,
                            updatedState = "Favorites"
                        ),
                        Chips(
                            name = "Share",
                            icon = Icons.Outlined.Share,
                            pressIcon = Icons.Filled.Share,
                            updatedState = "Shared"
                        )
                    )
                    chipList.forEachIndexed { index, chips ->
                        AssistChip(
                            leadingIcon = {
                                Icon(
                                    imageVector = chips.icon,
                                    contentDescription = chips.name
                                )
                            },
                            onClick = { },
                            label = { Text(chips.name) },
                            border = AssistChipDefaults.assistChipBorder(enabled = true),
                        )
                        Spacer(Modifier.width(8.dp))
                    }
                }

            }

        }
    }
}