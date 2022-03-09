package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.infra.MotivationConstants
import com.example.myapplication.infra.SecurityPreferences
import com.example.myapplication.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        textName.text = "Olá, $name!"

        //Lógica inicial de seleção
        image_all.setColorFilter(R.color.colorAccent)
        handleNewPhrase()

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
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.image_happy -> {
                image_happy.setColorFilter(R.color.colorAccent)
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.image_morning -> {
                image_morning.setColorFilter(R.color.colorAccent)
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }

    private fun handleNewPhrase() {
        textPhrase.text = Mock().getPhrase(mPhraseFilter)
    }
}