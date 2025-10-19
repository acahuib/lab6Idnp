package com.example.canvascircleanimation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private var radius = 50f
    private var animator: ValueAnimator? = null
    private var isAnimating = false

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        canvas.drawCircle(centerX, centerY, radius, paint)
    }

    fun toggleAnimation() {
        if (isAnimating) {
            animator?.cancel()
            isAnimating = false
        } else {
            animator = ValueAnimator.ofFloat(50f, 150f).apply {
                duration = 1000
                repeatMode = ValueAnimator.REVERSE
                repeatCount = ValueAnimator.INFINITE
                addUpdateListener {
                    radius = it.animatedValue as Float
                    invalidate()
                }
                start()
            }
            isAnimating = true
        }
    }
}
