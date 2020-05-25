package com.xavrax.myeverythinglist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.xavrax.myeverythinglist.data.LoginRepository
import com.xavrax.myeverythinglist.data.MoviesRepository
import com.xavrax.myeverythinglist.data.model.MovieEntity
import com.xavrax.myeverythinglist.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Thanks for enjoying my app! <3", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        updateUsernameAndEmail(navView)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        menu.getItem(0).setOnMenuItemClickListener {
            LoginRepository().logout()
            startActivity(Intent(this, LoginActivity::class.java))
            true
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun updateUsernameAndEmail(navigationView: NavigationView) {
        val usernameView : TextView = navigationView.getHeaderView(0).findViewById(R.id.logged_username)
        val emailView : TextView = navigationView.getHeaderView(0).findViewById(R.id.logged_email)

        val email = firebaseAuth.currentUser!!.email!!
        usernameView.text = email.split('@').first()
        emailView.text = email
    }

}
