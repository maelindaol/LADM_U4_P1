package mx.tecnm.tepic.ladm_u4_p1

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {
    var lienzo  : Lienzo ?= null

    lateinit var sensorManager : SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)

        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            if(lienzo!!.gostd.x.toInt()-(event.values[0].toInt())<=100){
                lienzo!!.gostd.asignarX(lienzo!!.gostd.x.toInt()-(event.values[0].toInt()))
                lienzo!!.gostd.asignarY(lienzo!!.gostd.y.toInt()+(event.values[1].toInt()))
                lienzo!!.invalidate()
            }
        }

        if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]<5){
                lienzo!!.noched.novisible()
                lienzo!!.diad.visible()
                lienzo!!.invalidate()
            }
            if(event.values[0]>=5){
                lienzo!!.diad.novisible()
                lienzo!!.noched.visible()
                lienzo!!.invalidate()
            } }

    }
}