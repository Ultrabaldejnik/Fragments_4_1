package com.example.fragments_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragments_4.fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag(FirstFragment.TAG) == null){
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragment_container_view,FirstFragment.TAG)
                addToBackStack(FirstFragment.TAG)
                commit()
            }
        }
    }
}