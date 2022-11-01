package com.example.clomend.closet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.clomend.R
import com.example.clomend.databinding.FragmentClothesAddBinding

class ClothesAddFragment : Fragment() {
    private var _binding: FragmentClothesAddBinding? =null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClothesAddBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val seasonSpinner: Spinner = binding.seasonSpinner
        val season = resources.getStringArray(R.array.season)
        val seasonAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, season)
        binding.seasonSpinner.adapter = seasonAdapter

        val topBottomSpinner: Spinner = binding.topBottomSpinner
        val topBottom = resources.getStringArray(R.array.top_bottom)
        val topBottomAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, topBottom)
        binding.topBottomSpinner.adapter = topBottomAdapter
    }
}