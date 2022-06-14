package com.grupo1.trabajoapirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.grupo1.trabajoapirest.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private lateinit var appBarConfiguration: AppBarConfiguration

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		WindowCompat.setDecorFitsSystemWindows(window,false)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val navController = findNavController(R.id.fragmentContainerView)
		appBarConfiguration = AppBarConfiguration(navController.graph)
//		setupActionBarWithNavController(navController, appBarConfiguration)
	}

	override fun onSupportNavigateUp(): Boolean {
		val navController = findNavController(R.id.fragmentContainerView)
		return navController.navigateUp(appBarConfiguration)
			|| super.onSupportNavigateUp()
	}

	fun changeToolbar(toolbar: Toolbar, showBack: Boolean) {
		setSupportActionBar(toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
	}

	fun changeToolbarTitle(title: String) {
		supportActionBar?.title = title
	}
}