package com.mka.cleancrypto.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.mka.cleancrypto.data.remote.dto.TeamMembers

@Composable
fun TeamListItem(
    teamMembers: TeamMembers,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMembers.name,
            style = androidx.compose.material.MaterialTheme.typography.h6,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMembers.position,
            style = androidx.compose.material.MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
            color = Color.DarkGray
        )
    }
}