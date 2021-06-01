package com.dmitriy.moroz.clusteringapp.utils.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.hideKeyboard() {
    this.clearFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.clickable() { isClickable = true }

fun View.unClickable() { isClickable = false }

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.showIf(showcase: Boolean) {
    if (showcase) visible() else gone()
}

fun View.visibleIf(showcase: Boolean) { if (showcase) visible() else invisible() }

fun View.toggleVisibility() {
    if (visibility == View.VISIBLE) gone() else visible()
}

fun View.isVisible(): Boolean = visibility == View.VISIBLE

fun View.isGone(): Boolean = visibility == View.GONE

fun View.clip() { clipToOutline = true }

fun clip(vararg views: View) { for (item in views) item.clip() }