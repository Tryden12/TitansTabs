package com.tryden12.titanstabs

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.isVisible
import com.tryden12.titanstabs.data.database.AppDatabase
import com.tryden12.titanstabs.data.model.User
import com.tryden12.titanstabs.databinding.ActivityCreateUserBinding
import kotlinx.coroutines.*

class CreateUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateUserBinding
    private var email : String = ""
    private var password : String = ""
    private var phoneNumber : String = ""
    private var userID : Long = -1

    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bind the button
        binding.buttonSignUp.setOnClickListener {
            addUser()
        }

        // Transform password to dots
        binding.editTextConfirmPasswordSignup.transformationMethod = PasswordTransformationMethod()

        setStatusBar()
    }



    /*** Method for Testing ***********************************/
    fun toMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



    /********* Add User Method ********************************************************************/
    private fun addUser() {
        // Bind edittext to variable
        email               = binding.editTextEmail.text.toString().trim()
        password            = binding.editTextPassword.text.toString().trim()
        val confirmPassword = binding.editTextConfirmPasswordSignup.text.toString().trim()
        phoneNumber         = binding.editTextPhoneNumSignup.text.toString().trim()




        /********* Validations ********************************************************************/
        if (email.isEmpty() || password.isEmpty() ||
            confirmPassword.isEmpty() || phoneNumber.isEmpty()) {
                binding.textViewWarning.text = getString(R.string.all_required)
                binding.textViewWarning.isVisible = true
        }else if (!email.contains("@")) {
            binding.textViewWarning.text = getString(R.string.email_character)
            binding.textViewWarning.isVisible = true
        } else if (password != confirmPassword) {
            binding.textViewWarning.text = getString(R.string.pw_do_not_match)
            binding.textViewWarning.isVisible = true
        } else if (phoneNumber.length != 10) {
            binding.textViewWarning.text = getString(R.string.phone_num_length)
            binding.textViewWarning.isVisible = true
        } else {
            binding.textViewWarning.isVisible = false




            /*** Coroutine for Adding User ********************************************************/
            CoroutineScope(Dispatchers.IO).launch {
                val userDao = AppDatabase.getDatabase(applicationContext).userDao()

                val user = User(0, email, password, phoneNumber)
                userID = userDao.addUser(user)

                withContext(Dispatchers.Main) {
                    delay(100L)
                    startActivity(Intent(applicationContext, MainActivity::class.java))
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