package uz.zeeco.studycenter.register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.zeeco.studycenter.R
import uz.zeeco.studycenter.databinding.ActivityRegisterBinding
import uz.zeeco.studycenter.home.MainActivity
import uz.zeeco.studycenter.profile.ProfileFragment
import uz.zeeco.studycenter.profile.RetrofitClient
import uz.zeeco.studycenter.profile.StudentData

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.loginButton.setOnClickListener {
            val login = binding.reLogin.text.toString()
            val password = binding.rePassword.text.toString()


            registerAndFetchProfile(login, password)
        }
    }

    private fun registerAndFetchProfile(login: String, password: String) {

        val apiService = RetrofitClient.apiService
        val call = apiService.readProfile(login,password)
        call.enqueue(object : Callback<StudentData> {
            override fun onResponse(
                call: Call<StudentData>,
                response: Response<StudentData>,
            ) {
                if (response.isSuccessful) {
                    val profile = response.body()
                    profile?.let {
                        // Navigate to profile activity and pass profile data
                        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                        intent.putExtra("profile", it)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Error: ${response.errorBody()?.string()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("RegisterActivity", "Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<StudentData>, t: Throwable) {
                Toast.makeText(applicationContext, "Failure: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
                Log.e("RegisterActivity", "Failure: ${t.message}")
            }
        })
    }

}