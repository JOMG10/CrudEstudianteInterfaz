package com.example.crudestudiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private val thirdFragment = ThirdFragment()
    private val fourFragment = FourFragment ()
    private val fiveFragment = FiveFragment()

    val crudEstudiante = CRUDEstudiante()

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.firstFragment -> {
                    loadFragment(firstFragment)


                    return@OnNavigationItemSelectedListener true
                }
                R.id.secondFragment -> {
                    loadFragment(secondFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.thirdFragment -> {
                    loadFragment(thirdFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.fourFragment -> {
                    loadFragment(fourFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.fiveFragment -> {
                    loadFragment(fiveFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Mostrar el primer fragmento por defecto
        loadFragment(firstFragment)
    }


    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }

}
