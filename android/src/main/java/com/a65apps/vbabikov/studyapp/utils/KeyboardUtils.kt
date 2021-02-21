package com.a65apps.vbabikov.studyapp.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object KeyboardUtils {
    fun showKeyboard(view: View?) {
        view?.also {
            if (view.requestFocus()) {
                val inputMethodManager =
                        view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
            }
        }
    }

    fun hideKeyboard(view: View?) {
        view?.also {
            val inputMethodManager =
                    view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                    view.windowToken,
                    0
            )
        }
    }
}
