package com.cursokotlin.customviewkotlin

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.password_validator.view.*

/**
 * Created by aristidesguimeraorozco on 30/9/18.
 */
class PasswordValidatorView (context: Context, attrs: AttributeSet): RelativeLayout(context, attrs) {

    init {
        inflate(context, R.layout.password_validator, this)

        val etPassword:EditText = findViewById(R.id.etPassword)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.PasswordValidator)
        tvErrorCode.text = attributes.getString(R.styleable.PasswordValidator_textError)
        attributes.recycle()

        etPassword.setOnFocusChangeListener { v, hasFocus -> checkFocus(hasFocus) }
    }

    private fun checkFocus(hasFocus: Boolean) {
        if(!hasFocus){
            tvErrorCode.visibility = View.VISIBLE
        }else{
            tvErrorCode.visibility = View.INVISIBLE
        }
    }

}