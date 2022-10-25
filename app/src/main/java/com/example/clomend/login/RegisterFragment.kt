package com.example.clomend.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clomend.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment_register 뷰 inflate
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //회원 가입 버튼을 클릭한 경우
        binding.btnRegister.setOnClickListener {
            //id, pw, pw_confirm 값 가져오기
            val id = binding.fieldRegisterId.text.toString()
            val pw = binding.fieldRegisterPw.text.toString()
            val pw_confirm = binding.fieldRegisterPwConfirm.text.toString()
        }//end of view.btn_register.setOnClickListener
    }//end of onViewCreated

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}