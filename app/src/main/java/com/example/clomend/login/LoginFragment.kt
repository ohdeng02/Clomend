package com.example.clomend.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.clomend.R
import com.example.clomend.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragment_login 뷰 inflate
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            //등록페이지로 넘어갑니다.
        }

        binding.btnLogin.setOnClickListener {
            //입력한 id와 password 가져오기
            val id = binding.fieldId.text.toString()
            val password = binding.fieldPassword.text.toString()
            findNavController().navigate(R.id.action_global_closetFragment)
            //일단 로그인 페이지에서 아이디 비번 받는 받아서 변수로 변환 까지 되어있고, 로그인 누르면 옷장페이지로 넘어가게만 해 두었습니다.

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}