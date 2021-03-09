package com.jproject.demodesa.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jproject.demodesa.R
import com.jproject.demodesa.login.fragment.HomeScreenFragment

class LoginAwalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_awal)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.content, HomeScreenFragment())
            .commit()
    }
}