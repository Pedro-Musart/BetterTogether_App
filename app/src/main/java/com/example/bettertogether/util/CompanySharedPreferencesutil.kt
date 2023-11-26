package com.example.bettertogether.util

import android.content.Context
import android.content.SharedPreferences
import com.example.bettertogether.model.Company

class CompanySharedPreferencesUtil private constructor(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("company_data", Context.MODE_PRIVATE)

    companion object {
        // Singleton para garantir apenas uma instância da classe SharedPreferencesUtil
        @Volatile
        private var instance: CompanySharedPreferencesUtil? = null

        fun getInstance(context: Context): CompanySharedPreferencesUtil {
            return instance ?: synchronized(this) {
                instance ?: CompanySharedPreferencesUtil(context).also { instance = it }
            }
        }
    }

    fun saveCompanyData(company: Company) {
        val editor = sharedPreferences.edit()
        editor.putString("company_name", company.company_name)
        editor.putString("company_email", company.company_email)
        editor.putString("password", company.password)
        editor.putString("company_id", company.company_id)
        editor.putString("employees", company.employees)
        editor.putString("site", company.site)

        // Adicione outras informações da empresa conforme necessário
        // Por exemplo, se você precisar salvar a lista de tarefas (tasks), precisará de uma lógica adicional

        editor.apply()
    }

    fun getCompanyData(): Company {
        val companyName = sharedPreferences.getString("company_name", "") ?: ""
        val companyEmail = sharedPreferences.getString("company_email", "") ?: ""
        val password = sharedPreferences.getString("password", "") ?: ""
        val companyId = sharedPreferences.getString("company_id", "") ?: ""
        val employees = sharedPreferences.getString("employees", "") ?: ""
        val site = sharedPreferences.getString("site", "") ?: ""

        // Recupere outras informações da empresa conforme necessário
        // Por exemplo, se você precisar recuperar a lista de tarefas (tasks), precisará de uma lógica adicional

        return Company(companyName, companyEmail, password, companyId, employees, emptyList(), site)
    }

    fun clearCompanyData() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}
