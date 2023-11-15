package com.example.fragments_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResult
import com.example.fragments_4.R
import com.example.fragments_4.databinding.FragmentSecondBinding



class SecondFragment : Fragment() {


    private val binding : FragmentSecondBinding
        get() = _binding!!
    private var _binding : FragmentSecondBinding? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnToNextFragment.setOnClickListener {
                launchNextFragment()
            }
            btnToPrevFragment.setOnClickListener {
                launchBackFragment()
            }
        }
    }

    private fun launchNextFragment(){
        val text = "Hello Fragment C"
        setFragmentResult("requestKey", bundleOf("bundleKey" to text))
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<ThirdFragment>(R.id.fragment_container_view, ThirdFragment.TAG)
            addToBackStack(ThirdFragment.TAG)
        }
    }

    private fun launchBackFragment(){
        parentFragmentManager.popBackStack()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

    companion object{
        const val TAG = "second_fragment"

        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}