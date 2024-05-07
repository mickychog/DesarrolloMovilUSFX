package com.micky.primerkotlin.backend

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.WHITE
import android.graphics.Paint
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import kotlin.math.sqrt
import kotlin.Double as Double1


@Suppress("DEPRECATION")

class Caratula(context: Context?) : View(context) {
    private val paint = Paint()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val ancho = width.toFloat()
        val alto = height.toFloat()

        canvas.drawColor(Color.BLACK)


        val paint = Paint().apply {
            color = Color.WHITE
            textSize = 50f
            textAlign = Paint.Align.CENTER // Alineación central del texto
        }

        val texto = "SIS 104"

        val xTexto = ancho / 2
        val yTexto = alto/3
        canvas.drawText(texto, xTexto, yTexto, paint)

        paint.color = Color.GREEN
        paint.strokeWidth = 3f //

        val numLineas = 20

        val espacioEntreLineas = alto / numLineas

        // Dibujar líneas diagonales desde la esquina inferior izquierda hasta la esquina superior derecha
        for (i in 0 until numLineas) {
            canvas.drawLine(0f, alto/3 , ancho - (i * espacioEntreLineas), (alto/3)+200, paint)
        }
        for (i in 0 until numLineas) {
            canvas.drawLine(ancho, alto/3 , i * espacioEntreLineas, (alto/3)+200, paint)
        }
        val width = canvas.width.toFloat()
        val height = canvas.height.toFloat()

        // Centro del cubo
        val centerX = width / 2
        val centerY = height / 2

        // Tamaño del cubo
        val size = width / 3

        // Dibujar las líneas del cubo
        drawLine(canvas, centerX - size / 2, centerY - size / 2, centerX + size / 2, centerY - size / 2)
        drawLine(canvas, centerX + size / 2, centerY - size / 2, centerX + size / 2 + size / 4, centerY - size / 4)
        drawLine(canvas, centerX + size / 2 + size / 4, centerY - size / 4, centerX + size / 2 + size / 4, centerY + size / 4)
        drawLine(canvas, centerX + size / 2 + size / 4, centerY + size / 4, centerX + size / 2, centerY + size / 2)

        drawLine(canvas, centerX - size / 2, centerY + size / 2, centerX + size / 2, centerY + size / 2)
        drawLine(canvas, centerX + size / 2 + size / 4, centerY + size / 4, centerX + size / 2, centerY + size / 2)
        drawLine(canvas, centerX - size / 2, centerY - size / 2, centerX - size / 2, centerY + size / 2)
        drawLine(canvas, centerX - size / 2, centerY - size / 2, centerX + size / 2, centerY - size / 2)
    }


    private fun drawLine(canvas: Canvas, startX: Float, startY: Float, endX: Float, endY: Float) {
        paint.color = Color.WHITE
        paint.strokeWidth = 3f
        canvas.drawLine(startX, startY, endX, endY, paint)
    }
}


