package com.indrajeet.chauhan.dittormapp.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.indrajeet.chauhan.dittormapp.R
import com.indrajeet.chauhan.dittormapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mAppBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        val drawerLayout = mainBinding.drawerLayout

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        mAppBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        mainBinding.navigationView.setNavigationItemSelectedListener { item ->
//            item.isChecked = true
            drawerLayout.closeDrawers()
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Open Home Selected", Toast.LENGTH_SHORT)
                        .show()
                    navController.navigate(R.id.navigation_home)
                    true
                }

                R.id.nav_favorites -> {
                    Toast.makeText(this, "Open Favorite Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.navigation_favorites)
                    true
                }

                R.id.nav_profile -> {
                    Toast.makeText(this, "Open Profile Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.navigation_profile)
                    true
                }

                R.id.nav_search -> {
                    Toast.makeText(this, "Open Search Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.navigation_search)
                    true
                }

                R.id.nav_settings -> {
                    Toast.makeText(this, "Open Settings Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_faq -> {
                    Toast.makeText(this, "Open FAQ Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_privacy_policy -> {
                    Toast.makeText(this, "Open Privacy Policy Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_app_info -> {
                    Toast.makeText(this, "Open App info Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_logout -> {
                    Toast.makeText(this, "Logout Selected", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        setupActionBarWithNavController(navController, mAppBarConfiguration)
//        mainBinding.navigationView.setupWithNavController(navController)
        mainBinding.bottomNavView.setupWithNavController(navController)
    }

    // For Navigation drawer
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(mAppBarConfiguration) || super.onSupportNavigateUp()
    }

    // For Toolbar options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // For Toolbar options menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notification -> Toast.makeText(this, "Notification Selected", Toast.LENGTH_SHORT)
                .show()

            R.id.share -> Toast.makeText(this, "Share Selected", Toast.LENGTH_SHORT).show()
            R.id.exit -> Toast.makeText(this, "Exit Selected", Toast.LENGTH_SHORT).show()
            R.id.add -> Toast.makeText(this, "Add Selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

//    private fun openFragment()
}