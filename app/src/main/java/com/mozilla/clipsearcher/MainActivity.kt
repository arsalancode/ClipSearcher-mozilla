package com.mozilla.clipsearcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mozilla.clipsearcher.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

// Check copy content length and trim if longer than 250 chars

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        setSupportActionBar(toolbar)
    }
}