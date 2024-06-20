package uz.zeeco.studycenter.atttendance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.zeeco.studycenter.adapters.VpAdapter
import uz.zeeco.studycenter.databinding.FragmentAttendanceBinding
import uz.zeeco.studycenter.databinding.FragmentHomeBinding


class AttendanceFragment : Fragment() {
    private lateinit var binding: FragmentAttendanceBinding
    private lateinit var adapter: VpAdapter
    private lateinit var titleList:ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAttendanceBinding.inflate(layoutInflater)

        return binding.root
    }
}