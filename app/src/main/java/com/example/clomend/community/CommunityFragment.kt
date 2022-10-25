package com.example.clomend.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.clomend.R
import com.example.clomend.databinding.FragmentCommunityBinding
import com.example.clomend.databinding.FragmentCoordiBookBinding

class CommunityFragment : Fragment() {
    private var _binding : FragmentCommunityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner: Spinner = binding.sortSpinner
        val sex = resources.getStringArray(R.array.sort)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,sex )
        binding.sortSpinner.adapter = adapter
    }
}