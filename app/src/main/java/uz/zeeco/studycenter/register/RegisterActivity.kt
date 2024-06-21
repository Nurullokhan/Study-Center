package uz.zeeco.studycenter.register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import uz.zeeco.studycenter.R
import uz.zeeco.studycenter.databinding.ActivityRegisterBinding
import uz.zeeco.studycenter.home.MainActivity

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
            val url =
                "https://script.google.com/macros/s/AKfycbz0xN2q8nETdDC6zUNJ79Y4oGIbQ6KJlu9N_oFHYIkRmEiK4x8kChxfnegP9qhF8XEX/exec"
            val stringRequest =
                object : StringRequest(Method.POST, url, com.android.volley.Response.Listener {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()


                }, com.android.volley.Response.ErrorListener {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }) {
                    override fun getParams(): MutableMap<String, String>? {
                        val params = HashMap<String, String>()
                        params["login"] = binding.reLogin.text.toString()
                        params["password"] = binding.rePassword.text.toString()
                        params["requestType"] = "lead"
                        return params
                    }

                }
            val queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)



        }
    }
}