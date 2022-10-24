package com.example.clomend.util

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    /* inputMethodManager 객체 가져오기(SystemService에서 가져옴). */
    val inputMethodManager =
        requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    /* 현재 사용자가 보고있는 current 화면을 가져옴. */
    requireActivity().currentFocus?.let { focusView ->
        /* 화면에 출력되어있는 소프트 키보드를 숨김으로 전환*/
        inputMethodManager.hideSoftInputFromWindow(
            focusView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}