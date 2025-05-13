package com.example.classicdrink

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.classicdrink.ui.theme.ClassicdrinkTheme
import android.content.Intent
import android.widget.TextView

class ThirdActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cartlayout)
        enableEdgeToEdge()


        val selectedSize = intent.getStringExtra("SELECTED_SIZE")
        val selectedIce = intent.getStringExtra("SELECTED_ICE")
        val selectedSugar = intent.getStringExtra("SELECTED_SUGAR")

        val sizeTextView = findViewById<TextView>(R.id.sizeText)
        val iceTextView = findViewById<TextView>(R.id.iceText)
        val sugarTextView = findViewById<TextView>(R.id.sugarText)

        sizeTextView.text = "Size: $selectedSize"
        iceTextView.text = "Ice: $selectedIce"
        sugarTextView.text = "Sugar: $selectedSugar"
    }
}
