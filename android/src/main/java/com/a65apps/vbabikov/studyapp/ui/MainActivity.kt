package com.a65apps.vbabikov.studyapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a65apps.vbabikov.studyapp.R
import com.a65apps.vbabikov.studyapp.Screens.HomeFragmentScreen
import com.a65apps.vbabikov.studyapp.StudyApplication
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    private val navigator: Navigator = AppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        StudyApplication.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        Timber.d("onCreate(), savedInstanceState = $savedInstanceState")
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            router.replaceScreen(HomeFragmentScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.main_container)
        if (fragment != null && fragment is BackButtonListener) {
            fragment.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }
}