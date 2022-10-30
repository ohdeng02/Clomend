package com.example.clomend.closet

import android.os.Parcel
import android.os.Parcelable
import com.example.clomend.R

enum class ClosetData(val imgRes: Int,val clothesName : String) {
    CLOTHES1(R.drawable.top_1,"빨강 후드티"),
    CLOTHES2(R.drawable.top_2,"흰 반팔티"),
    CLOTHES3(R.drawable.top_3,"하늘색 셔츠"),
    CLOTHES4(R.drawable.top_4,"노랑 스웨터"),
    CLOTHES5(R.drawable.top_5,"베이지 가디건"),
    CLOTHES6(R.drawable.top_6,"검정 맨투맨"),
    CLOTHES7(R.drawable.bottom_1,"슬랙스"),
    CLOTHES8(R.drawable.bottom_2,"청바지"),
    CLOTHES9(R.drawable.bottom_3,"트레이닝바지"),
    CLOTHES10(R.drawable.bottom_4,"아이보리반바지"),
}