package uz.zeeco.studycenter.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.zeeco.studycenter.home.HomeFragment

class VpAdapter(fragmentManager: FragmentManager, private val titleList: List<String>) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return titleList.size
    }

    override fun getItem(position: Int): Fragment {
        return HomeFragment.newInstance("$position", "")

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}