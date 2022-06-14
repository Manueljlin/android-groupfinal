package com.grupo1.trabajoapirest.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.LinearLayout

class RoundedLinearLayout : LinearLayout
{
	// Madre mía, he gastado demasiado tiempo de mi vida en esto

	constructor(context: Context?): super(context)
	constructor(context: Context?, attrs: AttributeSet?): super(context)
	constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int): super(context)
	constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int): super(context)

	var path: Path = Path()

	override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
		super.onSizeChanged(width, height, oldWidth, oldHeight)
		val cornerRadius = 24.0F
		this.path = Path()
		this.path.addRoundRect(
			RectF(0.0F, 0.0F, width.toFloat(), height.toFloat()),
			cornerRadius,
			cornerRadius,
			Path.Direction.CW
		)
	}

	override fun dispatchDraw(canvas: Canvas) {
		canvas.clipPath(this.path)
		super.dispatchDraw(canvas)
	}
}