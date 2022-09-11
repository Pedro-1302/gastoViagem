package com.example.gastoviagem

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        botaoUm.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity (intent)
        }
        botaoDois.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity (intent)
        }
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity2> {
        override fun createFromParcel(parcel: Parcel): MainActivity2 {
            return MainActivity2(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity2?> {
            return arrayOfNulls(size)
        }
    }
}
