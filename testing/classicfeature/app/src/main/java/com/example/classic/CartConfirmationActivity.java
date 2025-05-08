//Scenario 3: Refactor - confirming add to cart Logic
package com.example.classicdrinkfeature;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CartConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_confirmation);

        String drinkName = getIntent().getStringExtra("name");
        String size = getIntent().getStringExtra("size");
        String sugar = getIntent().getStringExtra("sugar");
        String ice = getIntent().getStringExtra("ice");
        double price = getIntent().getDoubleExtra("price", 0.0);

        TextView nameView = findViewById(R.id.cart_drink_name);
        TextView sizeView = findViewById(R.id.cart_drink_size);
        TextView sugarView = findViewById(R.id.cart_drink_sugar);
        TextView iceView = findViewById(R.id.cart_drink_ice);
        TextView priceView = findViewById(R.id.cart_drink_price);


        nameView.setText("Drink: " + drinkName);
        sizeView.setText("Size: " + size);
        sugarView.setText("Sugar: " + sugar);
        iceView.setText("Ice: " + ice);
        priceView.setText("Price: $" + String.format("%.2f", price));
    }
}
