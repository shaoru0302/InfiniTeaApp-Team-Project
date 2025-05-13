package com.example.classicdrink

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import android.content.Intent
import android.widget.TextView
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text


class ThirdActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cartlayout)
        enableEdgeToEdge()

        val selectedSize = intent.getStringExtra("SELECTED_SIZE")
        val selectedIce = intent.getStringExtra("SELECTED_ICE")
        val selectedSugar = intent.getStringExtra("SELECTED_SUGAR")
        val selectedDrink = intent.getStringExtra("drinkText")
        val menuButton = findViewById<Button>(R.id.menuButton)
        val modifyButton = findViewById<Button>(R.id.modifyButton)

        val drinkTextView = findViewById<TextView>(R.id.drinkText)
        val sizeTextView = findViewById<TextView>(R.id.sizeText)
        val iceTextView = findViewById<TextView>(R.id.iceText)
        val sugarTextView = findViewById<TextView>(R.id.sugarText)

        drinkTextView.text = "Drink: $selectedDrink"
        sizeTextView.text = "Size: $selectedSize"
        iceTextView.text = "Ice: $selectedIce"
        sugarTextView.text = "Sugar: $selectedSugar"

        modifyButton.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("SELECTED_DRINK", selectedDrink)
            intent.putExtra("SELECTED_SIZE", selectedSize)
            intent.putExtra("SELECTED_ICE", selectedIce)
            intent.putExtra("SELECTED_SUGAR", selectedSugar)
            startActivity(intent)
        }

        menuButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}

