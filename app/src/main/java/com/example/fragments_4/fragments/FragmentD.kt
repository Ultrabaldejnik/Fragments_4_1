package com.example.fragments_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments_4.databinding.FragmentDBinding


class FragmentD : Fragment() {

    private val binding : FragmentDBinding
        get() = _binding!!
    private var _binding : FragmentDBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToSecondFragment.setOnClickListener {
            (requireActivity() as OnListenerFragmentD).onBackButtonDClicked()
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    interface OnListenerFragmentD{
        fun onBackButtonDClicked()
    }

    companion object {
    const val TAG = "fourth_fragment"
    }
}