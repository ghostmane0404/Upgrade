package com.example.upgrade.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.upgrade.R
import com.example.upgrade.weather.five_days.FIveFragment
import com.example.upgrade.weather.sixteen_days.StxnFragment
import com.example.upgrade.weather.today.TodayFragment
import kotlinx.android.synthetic.main.weather.*

class WeatherFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.weather,null)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MyViewPagerAdapter(fragmentManager)
        adapter.addFragment(TodayFragment(),"Today")
        adapter.addFragment(FIveFragment()  ,"Five Days")
        adapter.addFragment(StxnFragment(),"Sixteen Days")
        viewPager.adapter= adapter
        tabs.setupWithViewPager(viewPager)
    }
    class MyViewPagerAdapter  (manager: FragmentManager?): FragmentPagerAdapter(manager)
    {
        private val fragmentList:MutableList<Fragment> = ArrayList()
        private val titleList:MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int
        {
            return fragmentList.size
        }
        fun addFragment(fragment:Fragment,title: String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}