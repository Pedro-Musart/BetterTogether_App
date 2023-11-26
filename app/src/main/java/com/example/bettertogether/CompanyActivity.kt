package com.example.bettertogether

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bettertogether.model.Company
import com.example.bettertogether.util.CompanySharedPreferencesUtil

class CompanyActivity : AppCompatActivity() {

    private lateinit var textCompanyName: TextView
    private lateinit var textCompanyEmail: TextView
    private lateinit var textCompanyId: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)

        textCompanyName = findViewById(R.id.textCompanyName)
        textCompanyEmail = findViewById(R.id.textCompanyEmail)
        textCompanyId = findViewById(R.id.textCompanyId)

        // Obtenha os dados da empresa das preferências compartilhadas
        val sharedPreferencesUtil = CompanySharedPreferencesUtil.getInstance(applicationContext)
        val company = sharedPreferencesUtil.getCompanyData()

        // Exiba as informações nas TextViews
        textCompanyName.text = company.company_name
        textCompanyEmail.text = company.company_email
        textCompanyId.text = company.company_id
    }
}
