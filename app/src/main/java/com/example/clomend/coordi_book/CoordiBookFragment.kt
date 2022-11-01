package com.example.clomend.coordi_book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R
import com.example.clomend.closet.ClosetAdapter
import com.example.clomend.closet.ClosetData
import com.example.clomend.databinding.FragmentClosetBinding
import com.example.clomend.databinding.FragmentCoordiBookBinding

class CoordiBookFragment : Fragment() {
    private var _binding: FragmentCoordiBookBinding? = null
    private val binding get() = _binding!!
    lateinit var model: CoordiBookViewModel

    private lateinit var  adapter: CoordibookAdapter
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  coordibookArrayList: ArrayList<CoordibookData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoordiBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = GridLayoutManager(context,3)
        recyclerView =view.findViewById(R.id.rv_coordibook)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CoordibookAdapter(coordibookArrayList)
        recyclerView.adapter =adapter

        adapter.setOnItemClickListener(object: CoordibookAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                model = ViewModelProvider(requireActivity()).get(CoordiBookViewModel::class.java)
                model.sendarray(coordibookArrayList[position])
                findNavController().navigate(R.id.action_coordi_BookFragment_to_coordiInFragment)
            }
        })
    }
    private fun dataInitialize(){
        coordibookArrayList = arrayListOf<CoordibookData>()
        coordibookArrayList.add(CoordibookData.COORDI01)
        coordibookArrayList.add(CoordibookData.COORDI02)
        coordibookArrayList.add(CoordibookData.COORDI03)
        coordibookArrayList.add(CoordibookData.COORDI04)
        coordibookArrayList.add(CoordibookData.COORDI05)
        coordibookArrayList.add(CoordibookData.COORDI06)
        coordibookArrayList.add(CoordibookData.COORDI07)
        coordibookArrayList.add(CoordibookData.COORDI08)
        coordibookArrayList.add(CoordibookData.COORDI09)
        coordibookArrayList.add(CoordibookData.COORDI10)
    }
}