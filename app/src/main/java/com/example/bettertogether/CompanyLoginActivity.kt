package com.example.bettertogether

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.bettertogether.CompanySignUpActivity

class CompanyLoginActivity : AppCompatActivity() {

    private lateinit var noHaveCompany: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_login)

        noHaveCompany = findViewById(R.id.noHaveCompany)


        noHaveCompany.setOnClickListener{
            startActivity(Intent(this, CompanySignUpActivity::class.java))

        }
    }
}