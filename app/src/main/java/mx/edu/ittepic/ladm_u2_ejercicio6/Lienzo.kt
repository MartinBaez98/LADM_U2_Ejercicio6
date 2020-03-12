package mx.edu.ittepic.ladm_u2_ejercicio6

import android.graphics.*
import android.view.MotionEvent
import android.view.View

class Lienzo (p:MainActivity) : View(p){

    var puntero = p
    var punteroFiguraGeometrica: FiguraGeometrica? = null


    var chikorita = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.iconochikorita),40,40)
    var pikachu = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.iconopikachu),40,120)
    var squirtle = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.iconosquirtle),40,200)
    var bullbazor = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.iconobullbazor),40,280)

    var chikoritatext = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.chikoritatext),200,40)
    var pikachutext = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.pikachutext),200,120)
    var squirtletext = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.squirtletext),200,200)
    var bullbazortext = FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.bullbazortext),200,280)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var paint = Paint()
        canvas!!.drawColor(Color.rgb(40,170,160))

        chikorita.pintar(canvas, paint)
        pikachu.pintar(canvas,paint)
        squirtle.pintar(canvas,paint)
        bullbazor.pintar(canvas,paint)

        chikoritatext.pintar(canvas, paint)
        pikachutext.pintar(canvas,paint)
        squirtletext.pintar(canvas,paint)
        bullbazortext.pintar(canvas,paint)

    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (chikorita.estaEnArea(event)) {
                    punteroFiguraGeometrica = chikorita
                    puntero.setTitle("TOCASTE Chikorita")
                }

                if (pikachu.estaEnArea(event)) {
                    punteroFiguraGeometrica = pikachu
                    puntero.setTitle("TOCASTE Pikachu")
                }

                if (squirtle.estaEnArea(event)) {
                    punteroFiguraGeometrica = squirtle
                    puntero.setTitle("TOCASTE Squirtle")
                }

                if (bullbazor.estaEnArea(event)) {
                    punteroFiguraGeometrica = bullbazor
                    puntero.setTitle("TOCASTE Bullbazor")
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (punteroFiguraGeometrica != null) {
                    punteroFiguraGeometrica!!.arrastrar(event)

                    if(punteroFiguraGeometrica == chikorita){
                        if(chikorita.colision(chikoritatext)){
                            puntero.setTitle("Correcto")
                        }
                    }

                    if(punteroFiguraGeometrica == pikachu){
                        if(chikorita.colision(pikachutext)){
                            puntero.setTitle("Correcto")
                        }
                    }

                    if(punteroFiguraGeometrica == squirtle){
                        if(chikorita.colision(squirtletext)){
                            puntero.setTitle("Correcto")
                        }
                    }

                    if(punteroFiguraGeometrica == bullbazor){
                        if(chikorita.colision(bullbazortext)){
                            puntero.setTitle("Correcto")
                        }
                    }


                }


            }
            MotionEvent.ACTION_UP -> {
                punteroFiguraGeometrica = null
            }
        }
        invalidate()
        return true
    }




}