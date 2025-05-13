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
        val intent = intent
        val modifyDrink = intent.getStringExtra("SELECTED_DRINK")
        val modifySize = intent.getStringExtra("SELECTED_SIZE")
        val modifyIce = intent.getStringExtra("SELECTED_ICE")
        val modifySugar = intent.getStringExtra("SELECTED_SUGAR")
        val drinkText = intent.getStringExtra("drinkText")

        val textView = findViewById<TextView>(R.id.drinkText)
        if (drinkText != null){
            textView.text = drinkText
        } else if (modifyDrink != null) {
            textView.text = modifyDrink
        }

        /*val text = intent.getStringExtra("drinkText")
        text?.let{
            textView.text = it
        }*/

        val sizeRadioGroup = findViewById<RadioGroup>(R.id.sizeGroup)
        val iceRadioGroup = findViewById<RadioGroup>(R.id.iceGroup)
        val sugarRadioGroup = findViewById<RadioGroup>(R.id.sugarGroup)

        fun selectRadioButtonByText(radioGroup: RadioGroup, value: String?) {
            if (value == null) return
            for (i in 0 until radioGroup.childCount) {
                val rb = radioGroup.getChildAt(i) as? RadioButton
                if (rb != null && rb.text.toString() == value) {
                    rb.isChecked = true
                    break
                }
            }
        }

        // Set the RadioButtons based on the transferred data
        selectRadioButtonByText(sizeRadioGroup, modifySize)
        selectRadioButtonByText(iceRadioGroup, modifyIce)
        selectRadioButtonByText(sugarRadioGroup, modifySugar)


        val cartButton = findViewById<Button>(R.id.submitButton)
        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        cartButton.setOnClickListener{
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
            intent.putExtra("drinkText", textView.text.toString())

            startActivity(intent)
        }
    }
}