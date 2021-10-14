package com.example.testapp

import androidx.fragment.app.Fragment


fun Fragment.requireMainActivity() = requireActivity() as MainActivity

fun Fragment.requireApp() = requireActivity().application as App

val Fragment.navigator: Navigator
    get() = requireMainActivity()