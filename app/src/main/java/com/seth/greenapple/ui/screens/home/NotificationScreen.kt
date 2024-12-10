package com.seth.greenapple.ui.screens.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seth.greenapple.utilities.NotificationList

@Preview
@Composable
fun NotificationPreview() {
    NotificationView()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotificationView() {

    val notificationList = List(25) { index ->
        NotificationList(
            name = "Exam week ${index + 1}",
            icon = Icons.Outlined.Info,
            contentDescription = {
                Text(
                    text = "The exam will start on January 3 - 4 2025!"
                )
            },
        )
    }

    Scaffold {
        LazyColumn {
            items(notificationList) { notification ->
                NotificationItem(notification)
            }
        }
    }
}

@Composable
fun NotificationItem(notification: NotificationList) {

    val context = LocalContext.current

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        onClick = {
            Toast.makeText(
                context,
                "You've click this text",
                Toast.LENGTH_SHORT
            ).show()
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Text(
                text = notification.name,
                style = MaterialTheme.typography.titleMedium
            )
            notification.contentDescription()

        }
        Box(
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Icon(
                imageVector = notification.icon,
                contentDescription = notification.name,
                modifier = Modifier
                    .size(40.dp)
                    .padding(4.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }

    }
}
