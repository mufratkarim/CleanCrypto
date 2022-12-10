package com.mka.cleancrypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.mka.cleancrypto.presentation.coin_list.CoinListViewModel
import com.mka.cleancrypto.presentation.Screen
import com.mka.cleancrypto.presentation.coin_detail.CoinDetailViewModel
import com.mka.cleancrypto.presentation.coin_detail.components.CoinTag
import com.mka.cleancrypto.presentation.coin_detail.components.TeamListItem

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coinDetail?.let { coin ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            listOf(
                                Color.Red,
                                Color.Yellow,
                                Color.DarkGray
                            )
                        )
                    ),
                contentPadding = PaddingValues(5.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = androidx.compose.material.MaterialTheme.typography.h4,
                            modifier = Modifier.weight(2f).padding(4.dp)
                        )
                        Text(
                            text = if (coin.is_active) "active" else "inactive",
                            color = if (coin.is_active) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }
                    Divider(thickness = 6.dp, color = Color.White)
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description,
                        style = androidx.compose.material.MaterialTheme.typography.body2,
                        modifier = Modifier.padding(12.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        style = androidx.compose.material.MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 20.dp,
                        crossAxisSpacing = 20.dp,
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        crossAxisAlignment = FlowCrossAxisAlignment.Center
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team Members",
                        style = androidx.compose.material.MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                }
                items(coin.teamMembers) { teamMember ->
                    TeamListItem(
                        teamMembers = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .align(Center)
                    )
                    Divider()

                }
            }
        }



        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Center)

            )
        }

        if (state.loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Center)
            )
        }

    }
}