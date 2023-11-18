package com.example.fragments_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.fragments_4.databinding.FragmentBBinding



class FragmentB : Fragment() {


    private val binding : FragmentBBinding
        get() = _binding!!
    private var _binding : FragmentBBinding? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnToNextFragment.setOnClickListener {
                val text = "Hello Fragment C"
                setFragmentResult("requestKey", bundleOf("bundleKey" to text))
                (requireActivity() as OnListenerFragmentB).onNextButtonCClicked()
            }
            btnToPrevFragment.setOnClickListener {
                (requireActivity() as OnListenerFragmentB).onBackButtonClicked()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

    interface OnListenerFragmentB{
        fun onNextButtonCClicked()
        fun onBackButtonClicked()
    }

    companion object{
        const val TAG = "second_fragment"
    }
}