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


@Suppress("DEPRECATION")

class Grafico(context: Context?) : View(context) {
    private val TAG = "GRAFICO"
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.BLACK)
        val paint = Paint()
        paint.setColor(WHITE)
        val ancho = width
        val alto = height
        //Log.d(Grafico.TAG, "ancho: $ancho alto: x$alto")
        canvas.drawLine(
            (ancho / 2).toFloat(),
            (alto / 2).toFloat(),
            ancho.toFloat(),
            (alto / 2).toFloat(),
            paint
        )
        canvas.drawLine(
            (ancho / 2).toFloat(),
            0f,
            (ancho / 2).toFloat(),
            (alto / 2).toFloat(),
            paint
        )
        canvas.drawLine(
            (ancho / 2).toFloat(),
            (alto / 2).toFloat(),
            -ancho.toFloat(),
            (ancho * sqrt(2.0)).toFloat(),
            paint
        )

        val limInfx = -20f
        val limSupx = 20f
        val limInfy = -20f
        val limSupy = 20f


            var x = limInfx
            while (x <= limSupx) {
                val y: Double = fx(x)
                //Log.d(TAG,"x=  "+x+" y= "+y);
                val xt = ((x - limInfx / 2) / (limSupx - limInfx) * ancho).toDouble()
                val yt = alto - (y - limInfy / 2) / (limSupy - limInfy) * alto
                paint.setColor(Color.YELLOW)
                canvas.drawCircle(xt.toFloat(), yt.toFloat(), 3f, paint)
                //Log.d(Grafico.TAG, "x: " + x + " xt=" + xt + "y: " + y + " yt" + yt)
                x += 0.01.toFloat()
            }


            var j = 0f
            while (j <= 10) {
                val limitInfX = -20 + j
                val limitSupX = 20 + j
                val LimitInfY = -20 + j
                val LimitSupY = 20 + j
                var x = limitInfX
                while (x <= limitSupX) {
                    val Y = fx(x)
                    val xt = ((x - limitInfX) / (limitSupX - limitInfX) * ancho).toDouble()
                    val yt = alto - (Y - LimitInfY) / (LimitSupY - LimitInfY) * alto
                    //ouble zt = ((x - limitInfZ) / (limitSupZ - limitInfZ)) * ancho;
                    paint.setColor(Color.YELLOW)
                    canvas.drawCircle(xt.toFloat(), yt.toFloat(), 3f, paint)
                    x += 0.1.toFloat()
                }
                j += 0.03.toFloat()
            }
    }






        /*canvas.drawColor(WHITE)


        var paint = Paint()
        paint.color = Color.BLUE
        canvas.drawCircle(100.0f, 100.0f, 50.0f, paint)

        val escala = 0.00001

        val tamanoPantalla = TPantalla()
        val ancho = tamanoPantalla.first
        val alto = tamanoPantalla.second

        //paint.color = Color.BLACK
        //paint.textSize = 50.0f
        //canvas.drawText("Ancho: $ancho px, Alto: $alto px", 10.0f, 200.0f, paint)
        //canvas.drawText("Factor de escala: $escala px", 10.0f, 250.0f, paint)

        val tamañoCuadradoAbsoluto = 200.0f
        val tamañoCuadrado = if (tamañoCuadradoAbsoluto > ancho) {
            ancho*tamañoCuadradoAbsoluto* escala.toFloat()
        } else {
            tamañoCuadradoAbsoluto

        }
        //
        paint.color = Color.RED
        val xCuadrado = (ancho - tamañoCuadrado) / 2.0f
        val yCuadrado = 200.0f
        canvas.drawRect(xCuadrado, yCuadrado, xCuadrado + tamañoCuadrado, yCuadrado + tamañoCuadrado, paint)


        val ladoCubo = Math.min(ancho, alto) / 2.0f

        // Dibujar las líneas del cubo
        paint.color = Color.BLACK
        paint.strokeWidth = 2.0f

        // Líneas horizontales
        val x0 = (ancho - ladoCubo) / 2.0f
        val y0 = (alto - ladoCubo) / 2.0f
        canvas.drawLine(x0, y0, x0 + ladoCubo, y0, paint)
        canvas.drawLine(x0, y0 + ladoCubo, x0 + ladoCubo, y0 + ladoCubo, paint)

        // Líneas verticales
        canvas.drawLine(x0, y0, x0, y0 + ladoCubo, paint)
        canvas.drawLine(x0 + ladoCubo, y0, x0 + ladoCubo, y0 + ladoCubo, paint)

        // Líneas diagonales
        canvas.drawLine(x0, y0, x0 + ladoCubo, y0 + ladoCubo, paint)
        canvas.drawLine(x0 + ladoCubo, y0, x0, y0 + ladoCubo, paint)

        // Líneas adicionales para completar el cubo
        canvas.drawLine(x0, y0, x0, y0 + ladoCubo / 2.0f, paint)
        canvas.drawLine(x0 + ladoCubo, y0, x0 + ladoCubo, y0 + ladoCubo / 2.0f, paint)
        canvas.drawLine(x0, y0 + ladoCubo, x0, y0 + ladoCubo, paint)
        canvas.drawLine(x0 + ladoCubo, y0 + ladoCubo, x0 + ladoCubo, y0 + ladoCubo, paint)

        // Líneas para la cara posterior
        canvas.drawLine(x0, y0 + ladoCubo, x0 + ladoCubo, y0 + ladoCubo + ladoCubo / 2.0f, paint)
        canvas.drawLine(x0 + ladoCubo, y0 + ladoCubo, x0 + ladoCubo, y0 + ladoCubo + ladoCubo / 2.0f, paint)
        */
    }
    fun fx(x: Float): Double {
        return (x * x).toDouble()
    }


/*{fun TPantalla(): Pair<Int, Int> {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()

        // Obtener las métricas de la pantalla actual
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        // Obtener el ancho y alto de la pantalla en píxeles
        val ancho = displayMetrics.widthPixels
        val alto = displayMetrics.heightPixels

        return Pair(ancho, alto)
    }*/


