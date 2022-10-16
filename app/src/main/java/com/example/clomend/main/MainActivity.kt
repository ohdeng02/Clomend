package com.example.clomend.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.clomend.My_PageFragment
import com.example.clomend.R
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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNaviBinding
}
