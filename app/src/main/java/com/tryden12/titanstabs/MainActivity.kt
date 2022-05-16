package com.tryden12.titanstabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.tryden12.titanstabs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var toggle :ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggleMenu()
        window.statusBarColor = resources.getColor(R.color.dark_blue)

    }




    fun toggleMenu() {
        /***************** Toggle Menu ****************************************************/
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_menu1 -> Toast.makeText(applicationContext,
                    "Clicked item 1", Toast.LENGTH_SHORT).show()
                R.id.action_menu2 -> Toast.makeText(applicationContext,
                    "Clicked item 2", Toast.LENGTH_SHORT).show()
                R.id.action_menu3 -> Toast.makeText(applicationContext,
                    "Clicked item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}