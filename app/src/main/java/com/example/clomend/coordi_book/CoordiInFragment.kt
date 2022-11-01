package com.example.clomend.coordi_book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.clomend.R
import com.example.clomend.community.CommunityViewModel
import com.example.clomend.databinding.FragmentCoordiInBinding


class CoordiInFragment : Fragment() {
    private var _binding : FragmentCoordiInBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoordiInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(CoordiBookViewModel::class.java)
        model.data.observe(viewLifecycleOwner, Observer {binding.coordiName.text= it.coordiTitle })
        model.data.observe(viewLifecycleOwner, Observer {binding.CoordiGen.text= it.gen_date })
        model.data.observe(viewLifecycleOwner, Observer {binding.coordiBookImg.setImageResource(it.img) })

        binding.backBtnCoordi.setOnClickListener {
            findNavController().navigate(R.id.action_coordiInFragment_to_coordiBookFragment)
        }

    }
}