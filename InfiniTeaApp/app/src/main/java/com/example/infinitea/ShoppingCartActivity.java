package com.example.infinitea;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This activity is for Current Order.
 * It is the screen where users can view and manage the drinks in their cart.
 * They can:
 * - See all added drinks and total price (with tax).
 * - Remove individual drinks or clear the entire cart.
 * - Place the order, which moves it to the order history.
 * The cart updates every time the user comes back to this screen.
 */

public class ShoppingCartActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView cartDrinkList;
    private ArrayAdapter<String> cartDrinkListAdapter;
    private TextView cartOrderNumberText, cartSubtotalText, cartTaxText, cartTotalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        // Create a display list of drinks (String)
        ArrayList<String> displayList = new ArrayList<>();
        for (MilkTea drink : MainActivity.SHOPPING_CART.getListOfDrinks()) {
            displayList.add(drink.toDisplayString());
        }

        cartDrinkListAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                displayList
        );

        cartDrinkList = findViewById(R.id.cartDrinkList);
        cartDrinkList.setOnItemClickListener(this);
        cartDrinkList.setAdapter(cartDrinkListAdapter);

        // Initialize text views
        cartOrderNumberText = findViewById(R.id.cartOrderNumberText);
        cartSubtotalText = findViewById(R.id.cartSubtotalText);
        cartTaxText = findViewById(R.id.cartTaxText);
        cartTotalText = findViewById(R.id.cartTotalText);

        // Set order details
        if (!MainActivity.SHOPPING_CART.getListOfDrinks().isEmpty()) {
            cartOrderNumberText.setText(String.valueOf(MainActivity.SHOPPING_CART.getOrderNumber()));
        } else {
            cartOrderNumberText.setText("N/A");
        }
        updateCartSummary();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the cart every time the user returns to this screen
        cartDrinkListAdapter.clear();
        cartDrinkListAdapter.addAll(MainActivity.SHOPPING_CART.getDisplayList());
        cartDrinkListAdapter.notifyDataSetChanged();

        // Set order details
        if (!MainActivity.SHOPPING_CART.getListOfDrinks().isEmpty()) {
            cartOrderNumberText.setText(String.valueOf(MainActivity.SHOPPING_CART.getOrderNumber()));
        } else {
            cartOrderNumberText.setText("N/A");
        }
        updateCartSummary();
    }

    public void clearCart(View view) {
        if (cartDrinkListAdapter.getCount() > 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
            alert.setMessage("Do you want to remove all drinks from the cart?");
            alert.setPositiveButton("Yes", (dialog, which) -> {
                MainActivity.SHOPPING_CART.getListOfDrinks().clear();
                cartDrinkListAdapter.clear();
                updateCartSummary();
            }).setNegativeButton("No", (dialog, which) ->
                    Toast.makeText(view.getContext(), "Drinks remain in the cart!", Toast.LENGTH_SHORT).show()
            );
            alert.show();
        } else {
            Toast.makeText(view.getContext(), "Cart is empty!", Toast.LENGTH_SHORT).show();
        }
    }

    public void placeOrder(View view) {
        if (cartDrinkListAdapter.getCount() > 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
            alert.setMessage("Do you want to place the order?");
            alert.setPositiveButton("Yes", (dialog, which) -> {

                MainActivity.SHOPPING_CART.setDate(java.time.LocalDate.now().toString());
                // add order from shopping cart to my orders
                MainActivity.ORDER_HISTORY.addOrder(MainActivity.SHOPPING_CART);

                // initialize shopping cart
                MainActivity.SHOPPING_CART = new Order(MainActivity.SHOPPING_CART.getOrderNumber());

                cartOrderNumberText.setText(String.valueOf(MainActivity.SHOPPING_CART.getOrderNumber()));
                cartDrinkListAdapter.clear();
                updateCartSummary();
                Toast.makeText(view.getContext(), "Order placed successfully!", Toast.LENGTH_SHORT).show();
            }).setNegativeButton("No", (dialog, which) ->
                    Toast.makeText(view.getContext(), "Drinks remain in the cart!", Toast.LENGTH_SHORT).show()
            );
            alert.show();
        } else {
            Toast.makeText(view.getContext(), "Cart is empty!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
        alert.setMessage("Do you want to remove this drink from the cart?");
        alert.setPositiveButton("Yes", (dialog, which) -> {
            // Remove from the MilkTea list
            MainActivity.SHOPPING_CART.getListOfDrinks().remove(i);
            // Remove from the display adapter
            cartDrinkListAdapter.remove(cartDrinkListAdapter.getItem(i));
            updateCartSummary();
            Toast.makeText(view.getContext(), "Drink removed from cart!", Toast.LENGTH_SHORT).show();
        }).setNegativeButton("No", (dialog, which) ->
                Toast.makeText(view.getContext(), "Drink remains in the cart!", Toast.LENGTH_SHORT).show()
        );
        alert.show();
    }

    private void updateCartSummary() {
        cartSubtotalText.setText(String.format("$%s", MainActivity.SHOPPING_CART.calculateSubtotal()));
        cartTaxText.setText(String.format("$%s", MainActivity.SHOPPING_CART.calculateSalesTax()));
        cartTotalText.setText(String.format("$%s", MainActivity.SHOPPING_CART.calculateOrderTotal()));
    }

    public void goBackToHome(View view) {
        finish(); // back to home
    }
}
