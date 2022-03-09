package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.infra.MotivationConstants
import com.example.myapplication.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mSecurityPreferences = SecurityPreferences((this))

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener(this)


        val securityPreferences = SecurityPreferences(this)
        securityPreferences.storeString("", "")

    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttonSave){
            handleSave()
        }
    }

    private fun handleSave(){
        val name = editName.text.toString()

        //Inicia uma nova activity ou passa notificação de erro

        if(name != ""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, R.string.informe_o_nome, Toast.LENGTH_SHORT).show()
        }
    }
}