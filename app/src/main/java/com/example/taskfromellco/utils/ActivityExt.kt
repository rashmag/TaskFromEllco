package com.example.taskfromellco.utils

import android.app.Activity
import com.example.taskfromellco.R


fun Activity.animStepForwardTransparent() {
    overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero)
}

