package uz.zeeco.studycenter

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
import uz.zeeco.studycenter.databinding.ActivityRegisterBinding

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
        binding.buttonRegister.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val surname = binding.editTextSurname.text.toString()


            registerAndFetchProfile(name, surname)
        }
    }

    private fun registerAndFetchProfile(name: String, surname: String) {

        val apiService = RetrofitClient.apiService
        val call = apiService.readProfile(name, surname)
        call.enqueue(object : Callback<ProfileResponse> {
            override fun onResponse(
                call: Call<ProfileResponse>,
                response: Response<ProfileResponse>,
            ) {
                if (response.isSuccessful) {
                    val profile = response.body()
                    profile?.let {
                        // Navigate to profile activity and pass profile data
                        val intent = Intent(this@RegisterActivity, ProfileActivity::class.java)
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

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Failure: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
                Log.e("RegisterActivity", "Failure: ${t.message}")
            }
        })
    }

}