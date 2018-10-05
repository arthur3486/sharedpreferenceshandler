package com.arthurivanets.sharedpreferencesdemo.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.arthurivanets.sharedpreferencesdemo.R
import com.arthurivanets.sharedpreferencesdemo.util.shortToast
import com.arthurivanets.sharedpreferenceshandler.ktx.getSharedPreferencesManager
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {


    private lateinit var viewModel : MainViewModel
    private var appSettings : com.arthurivanets.sharedpreferencesdemo.model.AppSettings? = null




    companion object {

        const val PREFERENCES_FILE_NAME = "app_preferences"


        fun newInstance() : Fragment {
            return MainFragment()
        }


    }




    override fun onCreateView(inflater : LayoutInflater,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View {
        appSettings = com.arthurivanets.sharedpreferencesdemo.model.AppSettings().also {
            it.mainId = 13
            it.openCount = 1
            it.homeMessage = "This is the Home message."
            it.greetingMessage = "Hello there my friend!"
            it.isSoundEnabled = true
        }

        return inflater.inflate(R.layout.main_fragment, container, false)
    }




    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }




    override fun onActivityCreated(savedInstanceState : Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }




    private fun initUi() {
        infoTv.text = ""

        retrieveButton.setOnClickListener {
            appSettings = getAppSettings()
            context?.shortToast("Successfully Retrieved the App Settings!")
            showAppSettings(appSettings)
        }
        saveButton.setOnClickListener {
            appSettings?.let {
                saveAppSettings(it)
            }

            context?.shortToast("Successfully Saved App Settings!")
        }
    }




    private fun showAppSettings(settings : com.arthurivanets.sharedpreferencesdemo.model.AppSettings?) {
        settings?.let {
            infoTv.text = it.toString()
        }
    }




    private fun getAppSettings() : com.arthurivanets.sharedpreferencesdemo.model.AppSettings? {
        return context?.getSharedPreferencesManager(PREFERENCES_FILE_NAME)?.run {
            get(com.arthurivanets.sharedpreferencesdemo.model.AppSettings::class.java)
        }
    }




    private fun saveAppSettings(settings : com.arthurivanets.sharedpreferencesdemo.model.AppSettings) {
        context?.getSharedPreferencesManager(PREFERENCES_FILE_NAME)?.run {
            putAndApply(settings)
        }
    }




}
