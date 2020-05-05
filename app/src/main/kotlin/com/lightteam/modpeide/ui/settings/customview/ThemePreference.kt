package com.lightteam.modpeide.ui.settings.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import com.lightteam.modpeide.R

class ThemePreference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.preferenceStyle
) : Preference(context, attrs, defStyleAttr) {

    companion object {
        private const val LEFT_VALUE = "DARK"
        private const val RIGHT_VALUE = "LIGHT"
    }

    private lateinit var leftButton: RadioButton
    private lateinit var rightButton: RadioButton

    private val changeListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked) {
            when (buttonView.id) {
                R.id.theme_dark -> persistString(LEFT_VALUE)
                R.id.theme_light -> persistString(RIGHT_VALUE)
            }
        }
    }

    init {
        layoutResource = R.layout.item_preference_theme
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        leftButton = holder.findViewById(R.id.theme_dark) as RadioButton
        rightButton = holder.findViewById(R.id.theme_light) as RadioButton

        leftButton.setOnCheckedChangeListener(changeListener)
        rightButton.setOnCheckedChangeListener(changeListener)

        when (getPersistedString(LEFT_VALUE)) {
            LEFT_VALUE -> leftButton.isChecked = true
            RIGHT_VALUE -> rightButton.isChecked = true
        }
    }
}