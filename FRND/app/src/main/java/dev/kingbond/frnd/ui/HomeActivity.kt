package dev.kingbond.frnd.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import dev.kingbond.frnd.R
import dev.kingbond.frnd.databinding.ActivityHomeBinding

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    // Drawer Toggle
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        drawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Menu drawer
        onClickOfDrawer()
    }

    // On click of navigation item open Menu drawer
    private fun onClickOfDrawer() {
        homeBinding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_task -> {
                    val intent =
                        Intent(this@HomeActivity, CreateTaskActivity::class.java)
                    startActivity(intent)
                    homeBinding.drawerLayout.closeDrawer(GravityCompat.START)
                    // showNotifications("Create Task")
                }

                R.id.nav_completed -> {
                    val intent =
                        Intent(this@HomeActivity, ShowTaskActivity::class.java)
                    startActivity(intent)
                    homeBinding.drawerLayout.closeDrawer(GravityCompat.START)
                    //  showNotifications("Show Task - List")
                }

                R.id.nav_about -> {
                    showNotifications("About")
                }

                R.id.nav_settings -> {
                    showNotifications("Settings")
                }

                R.id.nav_help -> {
                    showNotifications("Help")
                }
            }
            true
        })

    }

    // Any Menu Item selected : return true
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }

    // to show the toast notifications
    private fun showNotifications(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}