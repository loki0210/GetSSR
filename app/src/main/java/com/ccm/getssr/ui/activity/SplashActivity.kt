package com.ccm.getssr.ui.activity

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.ccm.getssr.R
import com.ccm.getssr.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationEnd(view: View?) {
        startActivity<GetSsrActivity>()
        finish()
    }

    override fun onAnimationStart(view: View?) {
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun init() {
        super.init()
        ViewCompat.animate(splash_image).scaleX(1.0f).scaleY(1.0f).setListener(this).duration = 1000
    }
}