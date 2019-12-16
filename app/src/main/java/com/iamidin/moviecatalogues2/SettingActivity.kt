package com.iamidin.moviecatalogues2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val btnChangeLanguage: Button = btn_change_language
        btnChangeLanguage.setOnClickListener(this)

        supportActionBar?.title = R.string.title_settings.toString()

        setActionBarTitle(resources.getString(R.string.title_settings))
    }

    private fun setActionBarTitle(title: String?) {
        supportActionBar?.title = title
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_change_language -> {
                val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(mIntent)
            }
        }
    }
}
