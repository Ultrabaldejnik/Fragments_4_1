package com.example.fragments_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments_4.databinding.FragmentThirdBinding
import androidx.fragment.app.setFragmentResultListener
import com.example.fragments_4.R


class ThirdFragment : Fragment() {

    private val binding : FragmentThirdBinding
        get() = _binding!!
    private var _binding : FragmentThirdBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setFragmentResultListener("requestKey"){_,bundle->
            binding.tvFragment.text = bundle.getString("bundleKey")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnToFirstFragment.setOnClickListener{
                launchToStartFragment()
            }
            btnToNextFragment.setOnClickListener {
                launchNextFragment()
            }
        }
    }

    private fun launchNextFragment(){
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FourthFragment>(R.id.fragment_container_view,FourthFragment.TAG)
            addToBackStack(FourthFragment.TAG)
        }
    }

    private fun launchToStartFragment(){
        parentFragmentManager.popBackStack(SecondFragment.TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TAG = "third_fragment"


    }
}