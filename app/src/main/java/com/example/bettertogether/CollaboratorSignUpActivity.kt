package br.com.bettertogether

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bettertogether.CompanyLoginActivity
import com.example.bettertogether.LoginActivity
import com.example.bettertogether.R

class CollaboratorSignUpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collaborator_signup)

        val backToMainBtn = findViewById<Button>(R.id.backToMain)


        backToMainBtn.setOnClickListener{
            val i = Intent(this,  LoginActivity::class.java)
            startActivity(i)
            finish()

        }
    }
}