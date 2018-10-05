package com.arthurivanets.sharedpreferenceshandler.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.arthurivanets.sharedpreferenceshandler.R
import com.arthurivanets.sharedpreferenceshandler.R.id.infoTv
import com.arthurivanets.sharedpreferenceshandler.R.id.retrieveButton
import com.arthurivanets.sharedpreferenceshandler.ktx.getSharedPreferencesManager
import com.arthurivanets.sharedpreferenceshandler.model.AppSettings
import com.arthurivanets.sharedpreferenceshandler.util.shortToast
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {


    private lateinit var viewModel : MainViewModel
    private var appSettings : AppSettings? = null




    companion object {

        const val PREFERENCES_FILE_NAME = "app_preferences"


        fun newInstance() : Fragment {
            return MainFragment()
        }


    }




    override fun onCreateView(inflater : LayoutInflater,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?) : View {
        appSettings = AppSettings().also {
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




    private fun showAppSettings(settings : AppSettings?) {
        settings?.let {
            infoTv.text = it.toString()
        }
    }




    private fun getAppSettings() : AppSettings? {
        return context?.getSharedPreferencesManager(PREFERENCES_FILE_NAME)?.run {
            get(AppSettings::class.java)
        }
    }




    private fun saveAppSettings(settings : AppSettings) {
        context?.getSharedPreferencesManager(PREFERENCES_FILE_NAME)?.run {
            putAndApply(settings)
        }
    }




}
