package com.cbellmont.menulateralejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.cbellmont.menulateralejemplo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topBar.ivHamburger.setOnClickListener {
            binding.drawerLayout.openDrawer(Gravity.LEFT)
        }

        binding.navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_1 -> {
                    Log.d(MainActivity::class.java.name, "Menu 1")
                    Toast.makeText(this, "Menu 1", Toast.LENGTH_LONG).show()
                }
                R.id.menu_2 -> {
                    Log.d(MainActivity::class.java.name, "Menu 2")
                    Toast.makeText(this, "Menu 2", Toast.LENGTH_LONG).show()
                }
                R.id.menu_3 -> {
                    Log.d(MainActivity::class.java.name, "Menu 3")
                    Toast.makeText(this, "Menu 3", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Log.e(MainActivity::class.java.name, "Unknown item on navigationView")
                    return@setNavigationItemSelectedListener false
                }
            }
            binding.drawerLayout.closeDrawers()
            true
        }
    }
}