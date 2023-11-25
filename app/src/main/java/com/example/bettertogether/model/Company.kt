package com.example.bettertogether.model

data class Company (
    val company_name: String,
    val password: String,
    val company_id: String,
    val tasks: List<Task>
)