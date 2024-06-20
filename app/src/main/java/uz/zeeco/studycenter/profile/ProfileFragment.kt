package uz.zeeco.studycenter.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.zeeco.studycenter.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        val intent=Intent()
        val profile = intent.getParcelableExtra<StudentData>("profile")
        profile?.let {

            //updateProfileUI(it)

        }
        return binding.root
    }
       /* private fun updateProfileUI(profile: StudentData) {
            // Assuming you have TextViews or EditTexts in your layout
            binding.name.text = profile.name
            binding.surname.text = profile.surname
            binding.age.text = profile.age.toString()
            binding.gender.text = profile.gender
            binding.phone1.text = profile.phone_1
            binding.phone2.text = profile.phone_2
            binding.courseName.text = profile.course_name
            binding.courseLevel.text = profile.course_level
            binding.courseDay.text = profile.course_day
            binding.status.text = profile.status
            binding.groupName.text = profile.group_name
            binding.id.text = profile.id
            binding.contract.text = profile.contract
            binding.login.text = profile.login
            binding.password.text = profile.password
        }*/


    }