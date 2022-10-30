package com.example.clomend.closet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.clomend.R
import com.example.clomend.databinding.FragmentCommunityBinding
import com.example.clomend.databinding.FragmentCoordiRecommendBinding

class CoordiRecommendFragment : Fragment() {
    private var _binding : FragmentCoordiRecommendBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoordiRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtnCoordiReco.setOnClickListener{
            findNavController().navigate(R.id.action_global_closetFragment)
        }
    }
}