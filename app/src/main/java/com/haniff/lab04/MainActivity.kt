package com.haniff.lab04

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.haniff.lab04.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(), Parcelable {
    private lateinit var binding: ActivityMainBinding

    constructor(parcel: Parcel) : this() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // the step is used to link the UI created in XML to our Kotlin file
        // 3 steps
        // Enable {viewBinding} in gradle.kts
        // Initialize binding object
        // Set content view to binding root
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Bila button yang ber ID buttonPlus ditekan
        binding.buttonPlus.setOnClickListener {
            // Dapatkan nilai dari editText1 dan editText2 = binding.editText1.text.toString()
            // Tukarkan ke integer = toInt()
            val num1 = binding.editText1.text.toString().toInt()
            val num2 = binding.editText2.text.toString().toInt()
            // Dapatkan hasil dari penjumlahan = num1 + num2
            val sum = num1 + num2
            // Keluarkan result ke textview dengan ID resultTextView = binding.resultTextView
            binding.resultTextView.text = "Result: $sum"
        }

        binding.buttonMinus.setOnClickListener {
            val num1 = binding.editText1.text.toString().toInt()
            val num2 = binding.editText2.text.toString().toInt()
            val minus = num1 - num2
            binding.resultTextView.text = "Result: $minus"
        }

        binding.buttonProduct.setOnClickListener {
            val num1 = binding.editText1.text.toString().toInt()
            val num2 = binding.editText2.text.toString().toInt()
            val product = num1 * num2
            binding.resultTextView.text = "Result: $product"

        }

        binding.buttonDivide.setOnClickListener {
            val num1 = binding.editText1.text.toString().toDouble()
            val num2 = binding.editText2.text.toString().toDouble()
            val divide = num1 / num2
            binding.resultTextView.text = "Result: $divide"

        }

    }

}