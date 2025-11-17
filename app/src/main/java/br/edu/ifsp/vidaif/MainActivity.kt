package br.edu.ifsp.vidaif

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import br.edu.ifsp.vidaif.fragment.ContactFragment
import br.edu.ifsp.vidaif.fragment.CoursesFragment
import br.edu.ifsp.vidaif.fragment.EventsFragment
import br.edu.ifsp.vidaif.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var headerTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headerTitle = findViewById(R.id.headerTitle)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Set initial fragment
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
            headerTitle.text = getString(R.string.home_title)
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            val fragment: Fragment
            val title: String

            when (item.itemId) {
                R.id.navigation_home -> {
                    fragment = HomeFragment()
                    title = getString(R.string.home_title)
                }
                R.id.navigation_courses -> {
                    fragment = CoursesFragment()
                    title = getString(R.string.courses_title)
                }
                R.id.navigation_events -> {
                    fragment = EventsFragment()
                    title = getString(R.string.events_title)
                }
                R.id.navigation_contact -> {
                    fragment = ContactFragment()
                    title = getString(R.string.contact_title)
                }
                else -> return@setOnItemSelectedListener false
            }

            loadFragment(fragment)
            headerTitle.text = title

            // Update navigation colors
            updateNavigationColors(item.itemId)

            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun updateNavigationColors(selectedItemId: Int) {
        val menu = bottomNavigation.menu
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            if (menuItem.itemId == selectedItemId) {
                menuItem.icon?.setTint(getColor(R.color.nav_active))
            } else {
                menuItem.icon?.setTint(getColor(R.color.nav_inactive))
            }
        }
    }
}