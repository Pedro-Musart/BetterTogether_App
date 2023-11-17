package com.example.bettertogether

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.bettertogether.CollaboratorSignUpActivity
import br.com.bettertogether.CompanySignUpActivity

class LoginActivity : AppCompatActivity() {
    lateinit var collaboratorButton: Button
    lateinit var companyButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        collaboratorButton = findViewById(R.id.collaborator_btn)
        companyButton = findViewById(R.id.company_btn)

        collaboratorButton.setOnClickListener{
            val openSignup = Intent(this, CollaboratorSignUpActivity::class.java)
            startActivity(openSignup)
        }
        companyButton.setOnClickListener{
            val openCompanySignup = Intent(this, CompanySignUpActivity::class.java)
            startActivity(openCompanySignup)
        }

    }
}