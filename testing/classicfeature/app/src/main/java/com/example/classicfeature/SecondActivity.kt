package com.example.classicdrink

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
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

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.optionlayout)
        enableEdgeToEdge()

        val textView = findViewById<TextView>(R.id.drinkText)
        val text = intent.getStringExtra("buttonText")
        text?.let{
            textView.text = it
        }

        val sizeRadioGroup = findViewById<RadioGroup>(R.id.sizeGroup)
        val iceRadioGroup = findViewById<RadioGroup>(R.id.iceGroup)
        val sugarRadioGroup = findViewById<RadioGroup>(R.id.sugarGroup)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener{
            val selectedSizeId = sizeRadioGroup.checkedRadioButtonId
            val selectedIceId = iceRadioGroup.checkedRadioButtonId
            val selectedSugarId = sugarRadioGroup.checkedRadioButtonId

            if (selectedSizeId == -1 || selectedIceId == -1 || selectedSugarId == -1){
                Toast.makeText(
                    this,
                    "Please select an option for each category",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val selectedSizeButton = findViewById<RadioButton>(selectedSizeId)
            val selectedSize = selectedSizeButton.text.toString()

            val selectedIceButton = findViewById<RadioButton>(selectedIceId)
            val selectedIce = selectedIceButton.text.toString()

            val selectedSugarButton = findViewById<RadioButton>(selectedSugarId)
            val selectedSugar = selectedSugarButton.text.toString()

            Toast.makeText(
                this,
                "Selected Size: $selectedSize, Ice: $selectedIce, Sugar: $selectedSugar",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, ThirdActivity::class.java)

            intent.putExtra("SELECTED_SIZE", selectedSize)
            intent.putExtra("SELECTED_ICE", selectedIce)
            intent.putExtra("SELECTED_SUGAR", selectedSugar)

            startActivity(intent)
        }
    }
}