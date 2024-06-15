package uz.zeeco.studycenter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.zeeco.studycenter.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_profile)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val profile = intent.getParcelableExtra<ProfileResponse>("profile")
        profile?.let {

            updateProfileUI(it)

        }
    }

    private fun updateProfileUI(profile: ProfileResponse) {
        // Assuming you have TextViews or EditTexts in your layout
        binding.name.text = profile.name
        binding.surname.text = profile.surname
        binding.age.text = profile.age.toString()
        binding.gender.text = profile.gender
        binding.phone1.text = profile.phoneNumber1
        binding.phone2.text = profile.phoneNumber2
        binding.courseId.text = profile.courseId
        binding.courseLevel.text = profile.level
        binding.courseDay.text = profile.lessonDays
        binding.status.text = profile.status
        binding.groupId.text = profile.groupId
        binding.marketing.text = profile.marketing
        binding.contract.text = profile.contract
    }
}

