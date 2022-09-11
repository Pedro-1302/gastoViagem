package com.example.gastoviagem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.*
import android.view.View
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        calc.setOnClickListener {
            var s = 0

            if (priceGasoline.text.toString() == "" || priceGasoline.text.toString().toDouble() == 0.0){
                if (priceGasoline.text.toString() == "") {
                    priceGasoline.animation = shakeError()
                    priceGasoline.error = "O campo não pode estar vazio"
                }
                else if(priceGasoline.text.toString().toDouble() == 0.0) {
                    priceGasoline.animation = shakeError()
                    priceGasoline.error = "Os valores devem ser maior que 0"
                }
            } else {
                s += 1
            }

            if (priceEtanol.text.toString() == "" || priceEtanol.text.toString().toDouble() == 0.0){
                if (priceEtanol.text.toString() == "") {
                    priceEtanol.animation = shakeError()
                    priceEtanol.error = "O campo não pode estar vazio"
                }
                else if(priceEtanol.text.toString().toDouble() == 0.0) {
                    priceEtanol.animation = shakeError()
                    priceEtanol.error = "Os valores devem ser maior que 0"
                }
            } else {
                s += 1
            }

            if (s == 2){

                var gasoline: Double = priceGasoline.text.toString().toDouble()
                var etanol: Double = priceEtanol.text.toString().toDouble()
                var x = calc(etanol, gasoline)

                compensa.visibility = View.VISIBLE
                messageResult.visibility = View.VISIBLE

                if (x > 0.70){
                    messageResult.text = "Gasolina"

                    Handler(Looper.getMainLooper()).postDelayed(
                        {
                            finish()
                            val intent = Intent(this, MainActivity::class.java)
                            intent.putExtra("TextBox", priceGasoline.text.toString())
                            startActivity(intent)
                        },
                        1600
                    )
                }

                else if (x < 0.70){
                    messageResult.text = "Alcool"

                    Handler(Looper.getMainLooper()).postDelayed(
                        {
                            finish()
                            val intent = Intent(this, MainActivity::class.java)
                            intent.putExtra("TextBox", priceEtanol.text.toString())
                            startActivity(intent)
                        },
                        1600
                    )
                }
            }
        }
    }

    private fun calc(valor1: Double, valor2: Double ): Double{
        return valor1 / valor2
    }

    fun shakeError(): TranslateAnimation {
        val shake = TranslateAnimation(0F, 10F, 0F, 0F)
        shake.duration = 250
        shake.interpolator = CycleInterpolator(3F)
        return shake
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity3> {
        override fun createFromParcel(parcel: Parcel): MainActivity3 {
            return MainActivity3(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity3?> {
            return arrayOfNulls(size)
        }
    }
}

private fun Intent.putExtra(priceEdit: EditText?, a: String) {

}
