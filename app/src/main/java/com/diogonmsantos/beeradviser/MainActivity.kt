package com.diogonmsantos.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private val expert = BeerExpert()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickFindBeer(view: android.view.View) {
        val brands = findViewById<TextView>(R.id.brands)
        val color = findViewById<Spinner>(R.id.color)
        val beerType = color.selectedItem.toString()

        val brandList = expert.getBrands(beerType)
        val brandsFormatted = StringBuilder()
        for (brand in brandList){
            brandsFormatted.append(brand).append("\n")
        }

        brands.text = brandsFormatted
    }
}