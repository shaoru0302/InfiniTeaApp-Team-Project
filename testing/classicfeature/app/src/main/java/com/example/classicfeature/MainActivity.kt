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
import android.view.View
import android.widget.TextView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menulayout)
        enableEdgeToEdge()

        val thaiDrinkButton: Button = findViewById(R.id.thaiButton)
        val roseDrinkButton: Button = findViewById(R.id.roseButton)
        val matchaDrinkButton: Button = findViewById(R.id.matchaButton)

        val sharedClickListener = View.OnClickListener { v->
            if (v is Button){
                val text = v.text.toString()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("drinkText", text)
                startActivity(intent)
            }
        }
        thaiDrinkButton.setOnClickListener(sharedClickListener)
        roseDrinkButton.setOnClickListener(sharedClickListener)
        matchaDrinkButton.setOnClickListener(sharedClickListener)
    }
}
        /*drinkButton.setOnClickListener {
            val buttonText = it as Button
            val text = buttonText.text.toString()

            drinkButton.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("buttonText", text)
                startActivity(intent)
            }
        }*/

        /*val drinkButton: Button = findViewById(R.id.thaiButton)
        drinkButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("buttonText", text)
        }*/


