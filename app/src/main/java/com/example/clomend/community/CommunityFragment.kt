package com.example.clomend.community

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clomend.R
import com.example.clomend.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment() {
    private var _binding : FragmentCommunityBinding? = null
    private val binding get() = _binding!!
    lateinit var model: CommunityViewModel

    private lateinit var  adapter: CommunityAdapter
    private lateinit var  recyclerView: RecyclerView
    private lateinit var  communityArrayList: ArrayList<CommunityData>

    lateinit var imageId : Array<Int>
    lateinit var title : Array<String>
    lateinit var writer : Array<String>
    lateinit var writeT : Array<String>
    lateinit var score: Array<String>
    lateinit var viewCnt : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataIntialize()


        val spinner: Spinner = binding.sortSpinner
        val sex = resources.getStringArray(R.array.sort)
        val spinAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,sex )
        binding.sortSpinner.adapter = spinAdapter


        val layoutManager =GridLayoutManager(context,2)
        recyclerView =view.findViewById(R.id.Community_recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CommunityAdapter(communityArrayList)
        recyclerView.adapter =adapter

        adapter.setOnItemClickListener(object: CommunityAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                model = ViewModelProvider(requireActivity()).get(CommunityViewModel::class.java)
                model.sendarray(communityArrayList[position])
                findNavController().navigate(R.id.action_communityFragment_to_communityInFragment)
            }
        })

        binding.communityWrite.setOnClickListener{
            findNavController().navigate(R.id.action_communityFragment_to_coordiUploadFragment)
        }
    }
    private fun dataIntialize() {
        communityArrayList = arrayListOf<CommunityData>()

        imageId = arrayOf(
            R.drawable.community1,
            R.drawable.community2,
            R.drawable.community3,
            R.drawable.community4
        )
        title = arrayOf(
            getString(R.string.communityTitle1),
            getString(R.string.communityTitle2),
            getString(R.string.communityTitle3),
            getString(R.string.communityTitle4)
        )
        writer = arrayOf(
            getString(R.string.communityWriter1),
            getString(R.string.communityWriter2),
            getString(R.string.communityWriter3),
            getString(R.string.communityWriter4)
        )
        writeT = arrayOf(
            getString(R.string.communityTime1),
            getString(R.string.communityTime2),
            getString(R.string.communityTime3),
            getString(R.string.communityTime4)
        )
        score = arrayOf(
            getString(R.string.communityScore1),
            getString(R.string.communityScore2),
            getString(R.string.communityScore3),
            getString(R.string.communityScore4)
        )
        viewCnt = arrayOf(
            getString(R.string.communityViewCnt1),
            getString(R.string.communityViewCnt2),
            getString(R.string.communityViewCnt3),
            getString(R.string.communityViewCnt4)
        )

        for (i in imageId.indices){
            val community = CommunityData(imageId[i],title[i],writer[i],writeT[i],
                score[i].toDouble(),viewCnt[i].toInt())
            communityArrayList.add(community)
        }
    }
}
