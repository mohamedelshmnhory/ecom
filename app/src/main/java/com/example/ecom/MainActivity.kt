 package com.example.ecom

import android.os.Bundle
import android.util.Log.d
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecom.model.Product
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*


 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportFragmentManager.beginTransaction()
                .replace(R.id.FrameLayout, MainFragment())
                .commit()

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.actionHome ->  {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.FrameLayout,MainFragment())
                            .commit()
                }
                R.id.actionJeans -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.FrameLayout,JeansFragment())
                            .commit()
                }
                R.id.actionShorts -> d("daniel", "shorts...")
                R.id.actionsSocks -> d("daniel","socks...")
            }
            it.isChecked = true
            drawer_layout.closeDrawers()
            true
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        }


    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         drawer_layout.openDrawer(GravityCompat.START)
         return true
     }

}