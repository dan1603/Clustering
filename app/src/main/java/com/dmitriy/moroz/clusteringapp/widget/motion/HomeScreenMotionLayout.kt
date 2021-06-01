package com.dmitriy.moroz.clusteringapp.widget.motion

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationUtils
import androidx.constraintlayout.motion.widget.MotionLayout
import com.dmitriy.moroz.clusteringapp.R

class HomeScreenMotionLayout(context: Context, attrs: AttributeSet): MotionLayout(context, attrs) {

    companion object {
        private const val FADE_OUT_DELAY = 1000L

        const val STATE_EXPANDED = 1.0f
        const val STATE_COLLAPSED = 0.0f
    }

    interface Listener {
        fun onProgressChanged(progress: Float)
    }

    private val transitionListener = object : TransitionListener {
        override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            listener?.onProgressChanged(progress)
            toggleFade(false)
        }

        override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            toggleFade(true)
        }

        override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            if (p3 != STATE_EXPANDED && p3 != STATE_COLLAPSED) {
                viewToAnimateFade.visibility = View.VISIBLE
            }
        }

        override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) = Unit
    }

    private val viewToAnimateFade by lazy { findViewById<View>(R.id.homeCardFade) }

    private var listener: Listener? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setTransitionListener(transitionListener)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeTransitionListener(transitionListener)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    private fun toggleFade(isVisible: Boolean) {
        with(viewToAnimateFade) {
            clearAnimation()
            if (isVisible) {
                visibility = View.VISIBLE
                startAnimation(
                    AnimationUtils.loadAnimation(
                        context,
                        R.anim.home_motion_fade_in
                    )
                )
            } else {
                startAnimation(
                    AnimationUtils.loadAnimation(
                        context,
                        R.anim.home_motion_fade_out
                    )
                )
                Handler(Looper.getMainLooper()).postDelayed({
                    visibility = View.INVISIBLE
                }, FADE_OUT_DELAY)
            }
        }
    }
}