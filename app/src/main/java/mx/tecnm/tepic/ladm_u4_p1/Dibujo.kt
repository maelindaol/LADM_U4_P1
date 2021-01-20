package mx.tecnm.tepic.ladm_u4_p1

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

class Dibujo () {
    var x = 0f
    var y = 0f
    var tipo = 1
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var icono : Bitmap?=null
    var invisible = false

    constructor(x:Int, y:Int,b : Bitmap) : this(){
        this.icono = b
        this.x = x.toFloat()
        this.y = y.toFloat()
        ancho = icono!!.width.toFloat()
        alto = icono!!.height.toFloat()
        tipo = 3
    }

    fun pintar(c: Canvas, p: Paint){
        if(!this.invisible){
            when(tipo){
                1->{
                    c.drawCircle(x+radio,y+radio,radio,p)
                }
                2->{
                    c.drawRect(x,y,x+ancho,y+alto,p)
                }
                3->{
                    c.drawBitmap(icono!!,x,y,p)
                }
            }
        }
    }
    fun novisible() { this.invisible = true }
    fun visible() { this.invisible = false }
    fun asignarX(x: Int){ this.x = x.toFloat() }
    fun asignarY(y: Int){ this.y = y.toFloat() }
}