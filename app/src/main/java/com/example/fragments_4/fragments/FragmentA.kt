package com.example.fragments_4.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments_4.R
import com.example.fragments_4.databinding.FragmentABinding


class FragmentA : Fragment() {

    private val binding: FragmentABinding
        get() = _binding!!
    private var _binding: FragmentABinding? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToNextFragment.setOnClickListener {
            launchSecondFragment()
        }
    }

    private fun launchSecondFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FragmentB>(R.id.fragment_container_view, FragmentB.TAG)
            addToBackStack(FragmentB.TAG)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TAG = "first_fragment"
    }

    interface OnListenerFragmentA{
        fun onNextButtonBClickded()
    }


}