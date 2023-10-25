package com.carlos.classmanager.domain.model

data class Fee (
    val totalValue: String,
    val feeMouth: String,
    val feeMouthDay: String? = null
)

