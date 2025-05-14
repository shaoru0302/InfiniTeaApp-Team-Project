package com.example.infinitea;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * MainActivity is the home screen of the Infinitea app.
 * It provides navigation to:
 * ChooseDrinkActivity: for selecting and customizing new drinks.
 * ShoppingCartActivity: to view and manage the current order.
 * MyOrdersActivity: to view past orders from order history.
 * It also initializes global order storage for shopping cart and order history.
 */
public class MainActivity extends AppCompatActivity {


    // Stores all past orders (My Orders / Order History)
    public static MyOrder ORDER_HISTORY = new MyOrder();

    // Represents the current shopping cart (Current Order)
    public static Order SHOPPING_CART = new Order(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Button 1: Start a new drink order
        Button startOrderButton = findViewById(R.id.btn_start_order);
        startOrderButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChooseDrinkActivity.class);
            startActivity(intent);
        });

        // Button 2: Open the shopping cart (current order)
        Button cartButton = findViewById(R.id.btn_shopping_cart);
        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
            startActivity(intent);
        });

        // Button 3: View order history (past orders)
        Button myOrdersButton = findViewById(R.id.btn_my_orders);
        myOrdersButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyOrdersActivity.class);
            startActivity(intent);
        });
    }
}
