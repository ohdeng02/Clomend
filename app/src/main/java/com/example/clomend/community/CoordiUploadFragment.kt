package com.example.clomend.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R
import com.example.clomend.coordi_book.CoordiBookViewModel
import com.example.clomend.coordi_book.CoordibookAdapter
import com.example.clomend.coordi_book.CoordibookData

class CoordiUploadFragment : Fragment() {
    private lateinit var  adapter: CoordibookAdapter
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  coordibookArrayList: ArrayList<CoordibookData>

    lateinit var model: CoordiBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coordi_upload, container, false)
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