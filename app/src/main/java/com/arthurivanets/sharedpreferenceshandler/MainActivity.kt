package com.arthurivanets.sharedpreferenceshandler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arthurivanets.sharedpreferenceshandler.ui.main.MainFragment

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }




}
