package com.example.gastoviagem

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(), Parcelable {

        constructor(parcel: Parcel) : this() {
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val i = intent
            val text = i.getStringExtra("TextBox")
            priceEdit.setText(text)

            calcButton.setOnClickListener {
                var s = 0

                if (distanceEdit.text.toString() == "" || distanceEdit.text.toString().toDouble() == 0.0){
                    if (distanceEdit.text.toString() == "") {
                        distanceEdit.animation = shakeError()
                        distanceEdit.error = "O campo não pode estar vazio"
                    }
                    else if(distanceEdit.text.toString().toDouble() == 0.0) {
                        distanceEdit.animation = shakeError()
                        distanceEdit.error = "Os valores devem ser maior que 0"
                    }
                } else {
                    s += 1
                }

                if (priceEdit.text.toString() == "" || priceEdit.text.toString().toDouble() == 0.0){
                    if (priceEdit.text.toString() == "") {
                        priceEdit.animation = shakeError()
                        priceEdit.error = "O campo não pode estar vazio"
                    }
                    else if(priceEdit.text.toString().toDouble() == 0.0) {
                        priceEdit.animation = shakeError()
                        priceEdit.error = "Os valores devem ser maior que 0"
                    }
                } else {
                    s += 1
                }

                if (autonomyEdit.text.toString() == "" || autonomyEdit.text.toString().toDouble() == 0.0){
                    if (autonomyEdit.text.toString() == "") {
                        autonomyEdit.animation = shakeError()
                        autonomyEdit.error = "O campo não pode estar vazio"
                    }
                    else if(autonomyEdit.text.toString().toDouble() == 0.0) {
                        autonomyEdit.animation = shakeError()
                        autonomyEdit.error = "Os valores devem ser maior que 0"
                    }
                } else {
                    s += 1
                }

                if (s == 3) {
                    var distance: Double = distanceEdit.text.toString().toDouble()
                    var price: Double = priceEdit.text.toString().toDouble()
                    var autonomy: Double = autonomyEdit.text.toString().toDouble()
                    var a = result(distance, autonomy)
                    var x = a * price

                    resultMessage.text = String.format("%.2f", x)
                }
            }
        }

        fun shakeError(): TranslateAnimation {
            val shake = TranslateAnimation(0F, 10F, 0F, 0F)
            shake.duration = 250
            shake.interpolator = CycleInterpolator(3F)
            return shake
        }

        private fun validateForm() : Boolean{
            var turnBack = false
            if(distanceEdit.text.toString() != "" || priceEdit.text.toString() != "" || autonomyEdit.text.toString() != ""){
                turnBack = true
            }else {
                distanceEdit.error = "*"
                distanceEdit.requestFocus()
            }
            return turnBack
        }


        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<MainActivity> {
            override fun createFromParcel(parcel: Parcel): MainActivity {
                return MainActivity(parcel)
            }

            override fun newArray(size: Int): Array<MainActivity?> {
                return arrayOfNulls(size)
            }
        }
    }

    fun result(distance: Double, price: Double): Double {
        return distance / price
    }

        fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        fun describeContents(): Int {
            return 0
        }

        object CREATOR : Parcelable.Creator<MainActivity> {
            override fun createFromParcel(parcel: Parcel): MainActivity {
                return MainActivity(parcel)
            }

            override fun newArray(size: Int): Array<MainActivity?> {
                return arrayOfNulls(size)
            }
        }


