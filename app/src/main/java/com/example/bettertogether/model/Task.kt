package com.example.bettertogether.model



data class Task(

    val task_id: String,
    val task_name: String,
    val task_image_url: String,
    val task_description: String,
    val task_score: String,
    val company_id: String,
    val created_at: String,
    val updated_at: String?,
    val associated_users: List<String>,

)