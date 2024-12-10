package com.seth.greenapple.utilities

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavRoute<T: Any>(val name: String, val route: T, val icon: ImageVector, val selectedIcon: ImageVector)
data class Chips(val name: String, val icon: ImageVector, val pressIcon: ImageVector, val updatedState: String)
data class NotificationList(val name: String, val icon: ImageVector, val contentDescription: @Composable () -> Unit)


