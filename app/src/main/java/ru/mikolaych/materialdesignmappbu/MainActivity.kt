package ru.mikolaych.materialdesignmappbu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import ru.mikolaych.materialdesignmappbu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
    binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        supportFragmentManager.beginTransaction().replace(R.id.content, HomeFragment()).commit()
        setSupportActionBar(binding?.appBar)


        binding?.navigation?.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.home ->{
                    supportFragmentManager.beginTransaction().replace(R.id.content, HomeFragment()).commit()
                }
                R.id.catalog ->{
                    supportFragmentManager.beginTransaction().replace(R.id.content, CatalogFragment()).commit()
                }
                R.id.delivery ->{
                    supportFragmentManager.beginTransaction().replace(R.id.content, DeliveryFragment()).commit()
                }
                R.id.contacts ->{
                    supportFragmentManager.beginTransaction().replace(R.id.content, ContactsFragment()).commit()
                }
            }
            return@setOnItemSelectedListener true
        }

        binding?.appBar?.setOnMenuItemClickListener{menuItem: MenuItem ->
            when(menuItem.itemId){
                R.id.favorites ->{
                    supportFragmentManager.beginTransaction().replace(R.id.topAppBar, BasketFragment()).commit()
                    true
                }


                R.id.settings ->{
                    supportFragmentManager.beginTransaction().replace(R.id.topAppBar, SettingsFragment()).commit()
                    true
                }
               else -> false
            }


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.app_bar, menu)

        return true
    }

}