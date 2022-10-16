package com.example.clomend.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.clomend.R
import com.example.clomend.databinding.FragmentMyPageBinding

class My_PageFragment : Fragment() {
    private var _binding : FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    fun onCreatedView(inflater: LayoutInflater,
                               container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner: Spinner = binding.sexSpinner
        val sex = resources.getStringArray(R.array.sex)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,sex )
        binding.sexSpinner.adapter = adapter
    }
}