package com.example.clomend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.clomend.calendar.CalendarFragment
import com.example.clomend.closet.ClosetFragment
import com.example.clomend.community.CommunityFragment
import com.example.clomend.coordi_book.Coordi_BookFragment
import com.example.clomend.databinding.ActivityNaviBinding

private const val TAG_COORDI_BOOK= "coordi_book_fragment"
private const val TAG_CALENDER = "calender_fragment"
private const val TAG_CLOSET = "closet_fragment"
private const val TAG_COMMUNITY = "community_fragment"
private const val TAG_MY_PAGE = "my_page_fragment"

class NaviActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(TAG_CLOSET, ClosetFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.Coordi_BookFragment-> setFragment(TAG_COORDI_BOOK, Coordi_BookFragment())
                R.id.CalenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                R.id.ClosetFragment -> setFragment(TAG_CLOSET, ClosetFragment())
                R.id.CommunityFragment-> setFragment(TAG_COMMUNITY, CommunityFragment())
                R.id.MyPageFragment-> setFragment(TAG_MY_PAGE, My_PageFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val coordiBook = manager.findFragmentByTag(TAG_COORDI_BOOK)
        val calender = manager.findFragmentByTag(TAG_CALENDER)
        val closet = manager.findFragmentByTag(TAG_CLOSET)
        val community = manager.findFragmentByTag(TAG_COMMUNITY)
        val myPage = manager.findFragmentByTag(TAG_MY_PAGE)

        if (coordiBook != null){
            fragTransaction.hide(coordiBook)
        }

        if (calender != null){
            fragTransaction.hide(calender)
        }

        if (closet != null){
            fragTransaction.hide(closet)
        }

        if (community != null) {
            fragTransaction.hide(community)
        }

        if (myPage != null) {
            fragTransaction.hide(myPage)
        }

        if (tag == TAG_COORDI_BOOK) {
            if (calender!=null){
                fragTransaction.show(calender)
            }
        }
        else if (tag == TAG_CALENDER) {
            if (calender != null) {
                fragTransaction.show(calender)
            }
        }
        else if (tag == TAG_CLOSET){
            if (closet != null){
                fragTransaction.show(closet)
            }
        }
        else if (tag == TAG_COMMUNITY){
            if (community != null){
                fragTransaction.show(community)
            }
        }
        else if (tag == TAG_MY_PAGE){
            if (myPage != null){
                fragTransaction.show(myPage)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}