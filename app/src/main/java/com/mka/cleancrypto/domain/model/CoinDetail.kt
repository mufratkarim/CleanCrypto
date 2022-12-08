package com.mka.cleancrypto.domain.model

import com.mka.cleancrypto.data.remote.dto.Tag
import com.mka.cleancrypto.data.remote.dto.TeamMembers

data class CoinDetail (
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<String>,
    val teamMembers: List<TeamMembers>
)