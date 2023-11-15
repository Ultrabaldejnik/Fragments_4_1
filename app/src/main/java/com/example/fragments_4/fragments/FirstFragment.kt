package com.example.fragments_4.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments_4.R
import com.example.fragments_4.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private val binding: FragmentFirstBinding
        get() = _binding!!
    private var _binding: FragmentFirstBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToNextFragment.setOnClickListener {
            launchNextFragment()
        }
    }

    private fun launchNextFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<SecondFragment>(R.id.fragment_container_view, SecondFragment.TAG)
            addToBackStack(SecondFragment.TAG)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TAG = "first_fragment"
    }

}