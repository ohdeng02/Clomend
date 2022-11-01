package com.example.clomend.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.clomend.R
import com.example.clomend.databinding.FragmentCommunityBinding
import com.example.clomend.databinding.FragmentCommunityInBinding

class CommunityInFragment : Fragment() {
    private var _binding : FragmentCommunityInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(CommunityViewModel::class.java)
        model.data.observe(viewLifecycleOwner, Observer {binding.CoordiInName.text= it.title })
        model.data.observe(viewLifecycleOwner, Observer {binding.ViewCnt.text= it.viewCnt.toString() })
        model.data.observe(viewLifecycleOwner, Observer {binding.ratingBar.rating= it.score.toFloat() })
        model.data.observe(viewLifecycleOwner, Observer {binding.Score.text= it.score.toString() })
        model.data.observe(viewLifecycleOwner, Observer {binding.coordiInImg.setImageResource(it.imgRes) })

        binding.backBtnCommunity.setOnClickListener {
            findNavController().navigate(R.id.action_communityInFragment_to_communityFragment)
        }
    }
}