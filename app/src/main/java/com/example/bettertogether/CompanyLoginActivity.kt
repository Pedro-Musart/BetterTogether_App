package com.example.bettertogether

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.bettertogether.CompanySignUpActivity
import com.example.bettertogether.model.Company
import com.example.bettertogether.network.ApiService
import com.example.bettertogether.network.apiService
import com.example.bettertogether.network.retrofit
import com.example.bettertogether.util.CompanySharedPreferencesUtil
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompanyLoginActivity : AppCompatActivity() {

    private lateinit var noHaveCompany: Button
    private lateinit var companyNameEditText: EditText
    private lateinit var companyIdEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var companyLogin: Button

    private val apiService: ApiService = retrofit().create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_login)

        companyNameEditText = findViewById(R.id.editTextCompanyNameLogin)
        companyIdEditText = findViewById(R.id.editTextCompanyCNPJLogin)
        passwordEditText = findViewById(R.id.editTextCompanyPassLogin)
        companyLogin = findViewById(R.id.buttonLoginCompany)

        companyLogin.setOnClickListener {
            val companyName = companyNameEditText.text.toString()
            val companyId = companyIdEditText.text.toString()
            val password = passwordEditText.text.toString()

            try {
                if (companyName.isEmpty()) {
                    throw IllegalArgumentException("Insira o E-mail!")
                }

                if (companyId.isEmpty()) {
                    throw IllegalArgumentException("Insira o CNPJ!")
                }

                if (password.isEmpty()) {
                    throw IllegalArgumentException("Insira a Senha!")
                }

                val requestBody = createLoginRequestBody(companyName, companyId, password)
                sendLoginRequest(requestBody)

            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

        noHaveCompany = findViewById(R.id.noHaveCompany)
        noHaveCompany.setOnClickListener {
            startActivity(Intent(this, CompanySignUpActivity::class.java))
        }

        val backBtn = findViewById<Button>(R.id.back)
        backBtn.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun createLoginRequestBody(companyName: String, companyId: String, password: String): RequestBody {
        val json = JSONObject().apply {
            put("company_name", companyName)
            put("company_id", companyId)
            put("password", password)
        }
        return RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json.toString())
    }

    private fun sendLoginRequest(requestBody: RequestBody) {
        val call = apiService.loginCompany(requestBody)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    handleLoginSuccess(response.body())
                } else {
                    // Você pode lidar com o erro aqui
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // A requisição falhou devido a um erro de rede ou algo semelhante
                // Você pode lidar com o erro aqui
            }
        })
    }

    private fun handleLoginSuccess(companyResponseBody: ResponseBody?) {
        companyResponseBody?.let {
            val companyJson = it.string()
            val company = Company.fromJson(companyJson)

            // Salve os dados da empresa nas preferências compartilhadas
            val sharedPreferencesUtil = CompanySharedPreferencesUtil.getInstance(applicationContext)
            sharedPreferencesUtil.saveCompanyData(company)

            // Agora você pode navegar para a próxima tela ou realizar outras ações
            val intent = Intent(this@CompanyLoginActivity, CompanyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

