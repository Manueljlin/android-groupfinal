package com.grupo1.trabajoapirest

import android.app.Application
import com.google.android.material.color.DynamicColors

class MyApp : Application()
{
	override fun onCreate()
	{     // Use Material3 Monet, if available
		DynamicColors.applyToActivitiesIfAvailable(this)
		super.onCreate()
	}
}