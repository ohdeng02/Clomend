package com.example.clomend.closet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R
import com.example.clomend.databinding.FragmentClosetBinding

class ClosetFragment : Fragment() {
    private var _binding: FragmentClosetBinding? = null
    private val binding get() = _binding!!

    private lateinit var  adapter: ClosetAdapter
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  closetArrayList: ArrayList<ClosetData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment_login 뷰 inflate
        _binding = FragmentClosetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = GridLayoutManager(context,3)
        recyclerView =view.findViewById(R.id.rv_closet)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ClosetAdapter(closetArrayList)
        recyclerView.adapter =adapter

        adapter.setOnItemClickListener(object : ClosetAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                //findNavController().navigate(R.id.)
            }
        })

        binding.styleRecommend.setOnClickListener{
            findNavController().navigate(R.id.action_closetFragment_to_coordiRecommendFragment)
        }
        binding.clothesAdd.setOnClickListener{
            findNavController().navigate(R.id.action_closetFragment_to_clothesAddFragment)
        }
        binding.weatherButton.setOnClickListener{
            findNavController().navigate(R.id.action_closetFragment_to_weatherFragment)
        }
    }

    private fun dataInitialize(){
        closetArrayList = arrayListOf<ClosetData>()
        closetArrayList.add(ClosetData.CLOTHES1)
        closetArrayList.add(ClosetData.CLOTHES2)
        closetArrayList.add(ClosetData.CLOTHES3)
        closetArrayList.add(ClosetData.CLOTHES4)
        closetArrayList.add(ClosetData.CLOTHES5)
        closetArrayList.add(ClosetData.CLOTHES6)
        closetArrayList.add(ClosetData.CLOTHES7)
        closetArrayList.add(ClosetData.CLOTHES8)
        closetArrayList.add(ClosetData.CLOTHES9)
        closetArrayList.add(ClosetData.CLOTHES10)
    }
}