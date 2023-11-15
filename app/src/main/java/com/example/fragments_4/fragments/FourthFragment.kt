package com.example.fragments_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.fragments_4.R
import com.example.fragments_4.databinding.FragmentFourthBinding


class FourthFragment : Fragment() {

    private val binding : FragmentFourthBinding
        get() = _binding!!
    private var _binding : FragmentFourthBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToSecondFragment.setOnClickListener {
            launchSecondFragment()
        }
    }

    private fun launchSecondFragment(){
        parentFragmentManager.commit {
            parentFragmentManager.popBackStack(ThirdFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
    const val TAG = "fourth_fragment"
    }
}