package com.example.fragments_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments_4.fragments.FragmentA
import com.example.fragments_4.fragments.FragmentB
import com.example.fragments_4.fragments.FragmentC
import com.example.fragments_4.fragments.FragmentD

class MainActivity : AppCompatActivity(), FragmentA.OnListenerFragmentA,
    FragmentB.OnListenerFragmentB, FragmentC.OnListenerFragmentC, FragmentD.OnListenerFragmentD {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag(FragmentA.TAG) == null) {
            launchStartFragment()
        }
    }

    private fun launchStartFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentA>(R.id.fragment_container_view, FragmentA.TAG)
        }
    }


    override fun onNextButtonBClickded() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FragmentB>(R.id.fragment_container_view, FragmentB.TAG)
            addToBackStack(FragmentB.TAG)
        }
    }

    override fun onNextButtonCClicked() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FragmentC>(R.id.fragment_container_view, FragmentC.TAG)
            addToBackStack(FragmentC.TAG)
        }
    }

    override fun onBackButtonClicked() {
        supportFragmentManager.popBackStack()
    }

    override fun onNextButtonDClicked() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FragmentD>(R.id.fragment_container_view, FragmentD.TAG)
            addToBackStack(FragmentD.TAG)
        }
    }

    override fun onBackButtonAClicked() {
        supportFragmentManager.popBackStack(FragmentB.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onBackButtonDClicked() {
        supportFragmentManager.popBackStack(FragmentC.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.fragments.last()
        Log.d("Fragment",currentFragment.tag.toString())
        when (currentFragment) {
            is FragmentB -> onBackButtonAClicked()
            is FragmentC -> onBackButtonClicked()
            is FragmentD -> onBackButtonDClicked()
            else -> super.onBackPressed()
        }

    }
}