package uz.zeeco.studycenter.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.zeeco.studycenter.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var profile: StudentData
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        updateProfileUI(profile)
        return binding.root
    }

    fun updateProfileUI(profile: StudentData) {
        binding.name.text = profile.name
        binding.surname.text = profile.surname
        binding.age.text = profile.age
        binding.gender.text = profile.gender
        binding.phoneNumber1.text = profile.phone_1
        binding.phoneNumber2.text = profile.phone_2
        binding.courseName.text = profile.course_name
        binding.level.text = profile.course_level
        binding.days.text = profile.course_day
        binding.status.text = profile.status
        binding.groupName.text = profile.group_name
        binding.id.text = profile.id
        binding.contract.text = profile.contract
        binding.login.text = profile.login
        binding.password.text = profile.password
    }
}