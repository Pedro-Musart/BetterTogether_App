package com.example.bettertogether.model

import org.json.JSONObject

data class Company(
    val company_name: String,
    val company_email: String,
    val password: String,
    val company_id: String,
    val employees: String,
    val tasks: List<Task>,
    val site: String
) {
    companion object {
        fun fromJson(json: String): Company {
            val jsonObject = JSONObject(json)
            return Company(
                jsonObject.getString("company_name"),
                jsonObject.getString("company_email"),
                jsonObject.getString("password"),
                jsonObject.getString("company_id"),
                jsonObject.getString("employees"),
                emptyList(),  // Você pode adicionar a lógica para desserializar a lista de tarefas
                jsonObject.getString("site")
            )
        }
    }
}
