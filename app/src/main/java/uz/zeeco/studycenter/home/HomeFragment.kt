package uz.zeeco.studycenter.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.zeeco.studycenter.databinding.FragmentHomeBinding




    class HomeFragment : Fragment() {

        private lateinit var binding: FragmentHomeBinding


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
        ): View {
            // Inflate the layout for this fragment
            binding = FragmentHomeBinding.inflate(layoutInflater)

            return binding.root
        }


    }
