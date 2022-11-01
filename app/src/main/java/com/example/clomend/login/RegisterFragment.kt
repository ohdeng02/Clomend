package com.example.clomend.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.clomend.R
import com.example.clomend.databinding.FragmentRegisterBinding
import com.example.clomend.util.hideKeyboard

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

            when {
                id.isEmpty() ->
                    Toast.makeText(requireContext(), "아이디를 입력하세요.", Toast.LENGTH_LONG).show()
                pw.isEmpty() || pw_confirm.isEmpty() ->
                    Toast.makeText(requireContext(),"패스워드를 입력하세요.", Toast.LENGTH_LONG).show()
                pw_confirm != pw ->
                    Toast.makeText(requireContext(),"비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show()
                else -> {
                    //id, pw, pw_confirm 입력값이 정상이면 DB에 아디 비번 저장 후 로그인페이지로 돌아감
                    findNavController().navigate(R.id.action_registerFragment_to_info_InputFragment)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}