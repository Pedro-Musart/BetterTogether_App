package br.com.bettertogether

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bettertogether.CompanyLoginActivity
import com.example.bettertogether.LoginActivity
import com.example.bettertogether.R
import com.example.bettertogether.network.ApiService
import com.example.bettertogether.network.retrofit
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.ResponseBody

class CompanySignUpActivity : AppCompatActivity() {

    private val apiService: ApiService = retrofit().create(ApiService::class.java)
    private lateinit var backToMainBtn: Button
    private lateinit var companySignup: Button
    private lateinit var alreadyHaveCompany: Button
    private lateinit var companyNameEditText: EditText
    private lateinit var companyEmailEditText: EditText
    private lateinit var companyIdEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var employeesEditText: EditText
    private lateinit var websiteEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_signup)

        backToMainBtn = findViewById(R.id.backToMain)
        alreadyHaveCompany = findViewById(R.id.alreadyHaveCompany)
        companySignup = findViewById(R.id.buttonSignupCompany)
        companyNameEditText = findViewById(R.id.editTextCompanyName)
        companyEmailEditText = findViewById(R.id.editTextCompanyEmail)
        companyIdEditText = findViewById(R.id.editTextCompanyCNPJ)
        passwordEditText = findViewById(R.id.editTextCompanyPass)
        employeesEditText = findViewById(R.id.editTextCompanyEmployees)
        websiteEditText = findViewById(R.id.editTextCompanySite)

        backToMainBtn.setOnClickListener {
            onBackPressed()
        }

        alreadyHaveCompany.setOnClickListener{
            startActivity(Intent(this, CompanyLoginActivity::class.java))
            finish()
        }

        companySignup.setOnClickListener {
            val companyName = companyNameEditText.text.toString()
            val companyEmail = companyEmailEditText.text.toString()
            val companyId = companyIdEditText.text.toString()
            val password = passwordEditText.text.toString()
            val employees = employeesEditText.text.toString()
            val site = websiteEditText.text.toString()

            if (companyName.isNotEmpty() && companyEmail.isNotEmpty() && companyId.isNotEmpty() && password.isNotEmpty() && employees.isNotEmpty() && site.isNotEmpty()) {
                val requestBody = createSignUpRequestBody(companyName,companyEmail, companyId, password, employees,site)
                sendSignUpRequest(requestBody)
            } else {
                Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createSignUpRequestBody(companyName: String, companyEmail: String, companyId: String, password: String, employees: String, site: String): RequestBody {
        val json = JSONObject().apply {
            put("company_name", companyName)
            put("company_email", companyEmail)
            put("company_id", companyId)
            put("password", password)
            put("employees", employees)
            put("site", site)
        }

        return RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json.toString())
    }

    private fun sendSignUpRequest(requestBody: RequestBody) {
        val call = apiService.signUpCompany(requestBody)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val intent = Intent(this@CompanySignUpActivity, CompanyLoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // A requisição falhou
                    // Você pode lidar com o erro aqui
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // A requisição falhou devido a um erro de rede ou algo semelhante
                // Você pode lidar com o erro aqui
            }
        })
    }
}
