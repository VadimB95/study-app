package com.a65apps.vbabikov.studyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a65apps.vbabikov.studyapp.Screens.HomeFragmentScreen
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = AppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StudyApplication.INSTANCE.appComponent.inject(this)
        Timber.d("onCreate(), savedInstanceState = $savedInstanceState")
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.applyCommands(arrayOf<Command>(Replace(HomeFragmentScreen())))
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
        Timber.d("onResumeFragments()")
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
        Timber.d("onPause()")
    }
}