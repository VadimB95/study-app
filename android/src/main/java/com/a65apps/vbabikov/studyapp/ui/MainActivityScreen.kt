package com.a65apps.vbabikov.studyapp.ui

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen

class MainActivityScreen : ActivityScreen(
    intentCreator = {
        Intent(it, MainActivity::class.java)
    }
)
