package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.infra.MotivationConstants
import com.example.myapplication.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)
        textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        supportActionBar?.hide()

        buttonNewPhrase.setOnClickListener(this)
        image_all.setOnClickListener(this)
        image_happy.setOnClickListener(this)
        image_morning.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(R.id.image_all, R.id.image_happy, R.id.image_morning)

        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        image_all.setColorFilter(R.color.white)
        image_happy.setColorFilter(R.color.white)
        image_morning.setColorFilter(R.color.white)

        when (id) {
            R.id.image_all -> {
                image_all.setColorFilter(R.color.colorAccent)
            }
            R.id.image_happy -> {
                image_happy.setColorFilter(R.color.colorAccent)
            }
            R.id.image_morning -> {
                image_morning.setColorFilter(R.color.colorAccent)
            }
        }
    }

    private fun handleNewPhrase() {

    }
}