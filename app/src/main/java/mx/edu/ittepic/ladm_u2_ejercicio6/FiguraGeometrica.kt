package mx.edu.ittepic.ladm_u2_ejercicio6

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class FiguraGeometrica () {
    var x = 0f
    var y = 0f
    var tipo = 1 //1 circulo 2 rectangulo
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX = 5
    var incY = 5
    var imagen : Bitmap ?= null

    constructor(x: Int, y: Int, radio: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
    }

    constructor(x: Int, y: Int, ancho: Int, alto: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }

    constructor(bitmap: Bitmap, x:Int, y:Int):this(){
        imagen = bitmap
        this.x = x.toFloat()
        this.y = y.toFloat()
        tipo = 3
        ancho = imagen!!.width.toFloat()
        alto = imagen!!.height.toFloat()
    }


    fun pintar(c: Canvas, p: Paint){
        when(tipo){
            1->{
                c.drawCircle(x+radio,y+radio,radio,p)
            }
            2->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            3->{
                c.drawBitmap(imagen!!,x,y,p)
            }
        }
    }



    fun estaEnArea(event: MotionEvent):Boolean{
        if(event.x >= x && event.x<=x+ancho){
            if(event.y >= y && event.y<=y+alto){
                return true
            }
        }

        /*when(tipo){
            1->{
                if(event.x>=x-radio && event.x<=x+radio){
                    if(event.y>=y-radio && event.y<=y+radio){
                        return true
                    }
                }
            }
            2->{

            }
        }*/
        return false
    }

    fun arrastrar(event: MotionEvent){

        x = event.x - (ancho/2)
        y = event.y - (alto/2)
        /*when(tipo){
            1->{
                x = event.x
                y = event.y
            }
            2->{

            }
        }*/

    }

    fun colision(objetoB: FiguraGeometrica):Boolean{
        //caso 1
        if(objetoB.estaEnArea(x+ancho, y+alto)){
            return true
        }
        //caso 2
        if(objetoB.estaEnArea(x, y+alto)){
            return true
        }

        //caso 3
        if(objetoB.estaEnArea(x+ancho, y)){
            return true
        }

        //caso4
        if(objetoB.estaEnArea(x, y)){
            return true
        }
        return false
    }

    fun estaEnArea(posX:Float, posY:Float):Boolean{
        if(posX >= x && posX<=x+ancho){
            if(posY >= y && posY<=y+alto){
                return true
            }
        }

        /*when(tipo){
            1->{
                if(event.x>=x-radio && event.x<=x+radio){
                    if(event.y>=y-radio && event.y<=y+radio){
                        return true
                    }
                }
            }
            2->{

            }
        }*/
        return false
    }


}