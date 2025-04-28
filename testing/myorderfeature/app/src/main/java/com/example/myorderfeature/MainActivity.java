//Scenario 1: MainActivity for navigating to MyOrdersActivity
package com.example.myorderfeature;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startOrderButton = findViewById(R.id.btn_start_order);
        startOrderButton.setOnClickListener(v -> {
            // do nothing for now
        });


        Button cartButton = findViewById(R.id.btn_shopping_cart);
        cartButton.setOnClickListener(v -> {
            // do nothing for now
        });


        Button myOrdersButton = findViewById(R.id.btn_my_orders);
        myOrdersButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyOrdersActivity.class);
            startActivity(intent);
        });
    }
}
