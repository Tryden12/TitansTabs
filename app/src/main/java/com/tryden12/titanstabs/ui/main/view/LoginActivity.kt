package com.tryden12.titanstabs.ui.main.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.WindowManager
import androidx.core.view.isVisible
import com.tryden12.titanstabs.R
import com.tryden12.titanstabs.data.database.AppDatabase
import com.tryden12.titanstabs.databinding.ActivityLoginBinding
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var email : String = ""
    private var password : String = ""
    private var isAllowed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStatusBar()
        initViews()
        setListeners()
    }

    fun initViews() {
        // Transform password to dots
        binding.editTextPassword.transformationMethod = PasswordTransformationMethod()
    }

    fun setListeners() {
        binding.buttonLogin.setOnClickListener{ toMainActivity() }
        binding.buttonSignUp.setOnClickListener {
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }
        binding.forgotPassword.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    /*** Method for Testing **/
    fun toMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



    /*** Validation & Check User Credentials **/
    private fun checkUserCredentials() {
        email = binding.editTextEmail.text.toString().trim()
        password = binding.editTextPassword.text.toString().trim()


        if (email.isEmpty() || password.isEmpty()) {
            binding.textViewWarning.isVisible = true
        } else {
            /*** Coroutine for Checking Credentials **/
            CoroutineScope(Dispatchers.IO).launch {
                val userDao = AppDatabase.getDatabase(applicationContext).userDao()

                if (userDao.loginUser(email,password)) {
                    withContext(Dispatchers.Main) {
                        delay(100L)
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        binding.textViewWarning.text = getString(R.string.incorrect_field)
                        binding.textViewWarning.isVisible = true
                    }
                }
            }
        }
    }




    private fun setStatusBar() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

    }



}