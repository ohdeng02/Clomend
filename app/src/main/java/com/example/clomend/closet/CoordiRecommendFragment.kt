package com.example.clomend.closet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.clomend.R
import com.example.clomend.databinding.FragmentCoordiRecommendBinding
import java.util.*

class CoordiRecommendFragment : Fragment() {
    private var _binding : FragmentCoordiRecommendBinding? =null
    private val binding get() = _binding!!

    private val random = Random()
    private fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }
    private val tops = arrayOf(
        ClosetData.CLOTHES4.imgRes, //0
        ClosetData.CLOTHES5.imgRes, //1
        ClosetData.CLOTHES3.imgRes, //2
        ClosetData.CLOTHES6.imgRes, //3
        ClosetData.CLOTHES1.imgRes, //4
        ClosetData.CLOTHES2.imgRes, //5


        )
    private val bottoms = arrayOf(
        ClosetData.CLOTHES7.imgRes,
        ClosetData.CLOTHES8.imgRes,
        ClosetData.CLOTHES9.imgRes,
        ClosetData.CLOTHES10.imgRes,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoordiRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var topIndex =0
        binding.leftMinus.setOnClickListener {
            if(topIndex > 0){
                topIndex -= 1
                binding.selTop.setImageResource(tops[topIndex])
                binding.recoBottom1.setImageResource(R.drawable.n_bar_mypage_ic)
                binding.recoBottom2.setImageResource(R.drawable.n_bar_mypage_ic)
            }
        }
        binding.rightPlus.setOnClickListener {
            if(topIndex<5){
                topIndex += 1
                binding.selTop.setImageResource(tops[topIndex])
                binding.recoBottom1.setImageResource(R.drawable.n_bar_mypage_ic)
                binding.recoBottom2.setImageResource(R.drawable.n_bar_mypage_ic)
            }
        }

        binding.recommendBtn.setOnClickListener{
            if (topIndex==2) {
                binding.recoBottom1.setImageResource(bottoms[0])
                binding.recoBottom2.setImageResource(bottoms[1])
            }
            if (topIndex==3) {
                binding.recoBottom1.setImageResource(bottoms[1])
                binding.recoBottom2.setImageResource(bottoms[2])
            }
            if (topIndex==4) {
                binding.recoBottom1.setImageResource(bottoms[2])
            }
            if (topIndex==5) {
                binding.recoBottom1.setImageResource(bottoms[3])
            }
        }

        binding.backBtnCoordiReco.setOnClickListener{
            findNavController().navigate(R.id.action_global_closetFragment)
        }
    }
}