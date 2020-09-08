package com.example.ezdndapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ezdndapp.R
import com.example.ezdndapp.fragment.CharacterListFragment
import com.example.ezdndapp.fragment.InventoryFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityNavigationView.setItemSelected(R.id.char_page)
        supportFragmentManager.beginTransaction().add(R.id.frame_main, CharacterListFragment())
            .commit()
        var fragment = Fragment()
        mainActivityNavigationView.setOnItemSelectedListener { id ->
            when (id) {
                R.id.char_page -> fragment = CharacterListFragment()
                R.id.inventory_page -> fragment = InventoryFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.frame_main, fragment).commit()
        }
    }

}
