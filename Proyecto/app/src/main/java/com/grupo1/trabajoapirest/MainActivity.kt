package com.grupo1.trabajoapirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity: AppCompatActivity() {

	private lateinit var appBarConfiguration: AppBarConfiguration

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val navController = findNavController(R.id.fragmentContainerView)
		appBarConfiguration = AppBarConfiguration(navController.graph)
		setupActionBarWithNavController(navController, appBarConfiguration)

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