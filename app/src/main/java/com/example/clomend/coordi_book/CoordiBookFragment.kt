package com.example.clomend.coordi_book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clomend.databinding.FragmentClosetBinding
import com.example.clomend.databinding.FragmentCoordiBookBinding

class CoordiBookFragment : Fragment() {
    private var _binding: FragmentCoordiBookBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment_login 뷰 inflate
        _binding = FragmentCoordiBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}