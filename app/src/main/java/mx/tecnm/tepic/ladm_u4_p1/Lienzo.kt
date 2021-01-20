package mx.tecnm.tepic.ladm_u4_p1

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity) : View(p){
    //var puntero = p
    var gost = BitmapFactory.decodeResource(resources,R.drawable.gost)
    var dia = BitmapFactory.decodeResource(resources,R.drawable.dia)
    var noche = BitmapFactory.decodeResource(resources,R.drawable.noche)

    // Coordenadas iniciales
    var gostd = Dibujo(0,100,gost)
    var diad = Dibujo(0,0,dia)
    var noched = Dibujo(0,0,noche)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        noched.pintar(canvas,paint)
        diad.pintar(canvas,paint)
        gostd.pintar(canvas,paint)
    }
}
