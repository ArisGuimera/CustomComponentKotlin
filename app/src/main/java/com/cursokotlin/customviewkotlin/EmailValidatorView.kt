package com.cursokotlin.customviewkotlin

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.password_validator.view.*
import java.util.regex.Pattern

/**
 * Created by aristidesguimeraorozco on 30/9/18.
 */
class EmailValidatorView(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs), TextWatcher {


    var successColor: Int
    var errorColor: Int

    init {
        inflate(context, R.layout.password_validator, this)


        val attributes = context.obtainStyledAttributes(attrs, R.styleable.MailValidator)
        tvErrorCode.text = attributes.getString(R.styleable.MailValidator_textError)
        errorColor = attributes.getColor(R.styleable.MailValidator_underlineErrorColor, ContextCompat.getColor(context, R.color.colorAccent))
        successColor = attributes.getColor(R.styleable.MailValidator_underlineSuccessColor, ContextCompat.getColor(context, R.color.colorAccent))
        attributes.recycle()
        etMail.addTextChangedListener(this)
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


        val pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")
        val matcher = pattern.matcher(s.toString())
        val valid = matcher.matches()
        if (valid) {
            tvErrorCode.visibility = View.INVISIBLE
            etMail.background.setColorFilter(successColor, PorterDuff.Mode.SRC_IN)
        } else {
            tvErrorCode.visibility = View.VISIBLE
            etMail.background.setColorFilter(errorColor, PorterDuff.Mode.SRC_IN)
        }
    }
}