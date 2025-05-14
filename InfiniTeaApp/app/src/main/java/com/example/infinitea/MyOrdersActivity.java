package com.example.infinitea;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * MyOrdersActivity
 * This activity allows users to view, search, and reorder past drink orders.
 * It includes a search bar, an order history list, and handles empty states
 * and reorder functionality.
 */

public class MyOrdersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView emptyText;
    private TextView statusText;
    private OrderAdapter adapter;
    private List<Order> allOrders;
    private EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        recyclerView = findViewById(R.id.orders_recycler_view);
        emptyText = findViewById(R.id.empty_text);
        statusText = findViewById(R.id.status_text);
        searchInput = findViewById(R.id.search_order_input);
        allOrders = MainActivity.ORDER_HISTORY.getOrderList();
        setupRecyclerView(allOrders);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterOrders(s.toString());
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        allOrders = MainActivity.ORDER_HISTORY.getOrderList();

        if (allOrders.isEmpty()) {
            showEmpty("No orders found.");
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyText.setVisibility(View.GONE);
            adapter.setShowCheckboxes(false);
            adapter.updateData(allOrders);
        }
    }

    private void setupRecyclerView(List<Order> initialList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderAdapter(initialList);
        recyclerView.setAdapter(adapter);

        if (initialList.isEmpty()) {
            showEmpty("No orders found.");
        }
    }

    private void showEmpty(String message) {
        recyclerView.setVisibility(View.GONE);
        emptyText.setVisibility(View.VISIBLE);
        emptyText.setText(message);
    }

    private void showTemporaryStatus(String message) {
        statusText.setVisibility(View.VISIBLE);
        statusText.setText(message);

        new android.os.Handler().postDelayed(() -> {
            statusText.setText("");
            statusText.setVisibility(View.GONE);
        }, 3000);
    }

    private void filterOrders(String query) {
        if (query.trim().isEmpty()) {
            adapter.setShowCheckboxes(false);
            adapter.updateData(new ArrayList<>());
            showEmpty("Please enter an order number");
            return;
        }

        List<Order> filtered = new ArrayList<>();
        for (Order order : allOrders) {
            if (String.valueOf(order.getOrderNumber()).contains(query)) {
                filtered.add(order);
            }
        }

        if (filtered.isEmpty()) {
            adapter.setShowCheckboxes(false);
            showEmpty("Order not found");
        } else {
            adapter.setShowCheckboxes(true);   // only when matched order shows up, then checkBox appears
            recyclerView.setVisibility(View.VISIBLE);
            emptyText.setVisibility(View.GONE);
            adapter.updateData(filtered);
        }
    }

    public void goBackToHome(View view) {
        finish();
    }

    @SuppressLint("SetTextI18n")
    public void PrintReceipt(View view) {
        if (adapter == null || adapter.getCurrentOrders().isEmpty() || recyclerView.getVisibility() != View.VISIBLE) {
            showTemporaryStatus("No order selected");
            return;
        }
        showTemporaryStatus("Receipt is printing...");
    }


    @SuppressLint("SetTextI18n")
    public void ReorderOrder(View view) {
        if (adapter == null || recyclerView.getVisibility() != View.VISIBLE) {
            showTemporaryStatus("No order selected");
            return;
        }

        List<MilkTea> selectedDrinks = adapter.getSelectedDrinks();
        if (selectedDrinks.isEmpty()) {
            showTemporaryStatus("No drink selected");
            return;
        }

        int addedCount = 0;
        int outOfStockCount = 0;

        for (MilkTea drink : selectedDrinks) {
            if (drink.isAvailable()) {
                MainActivity.SHOPPING_CART.getListOfDrinks().add(drink);
                addedCount++;
            } else {
                outOfStockCount++;
            }
        }

        if (addedCount > 0 && outOfStockCount == 0) {
            showTemporaryStatus("All selected drinks added to cart!");
        } else if (addedCount > 0) {
            showTemporaryStatus("Some drinks added. " + outOfStockCount + " out of stock.");
        } else {
            showTemporaryStatus("No available drinks to reorder.");
        }
    }


    @SuppressLint("SetTextI18n")
    public void DeleteOrder(View view) {
        if (adapter == null || adapter.getCurrentOrders().isEmpty() || recyclerView.getVisibility() != View.VISIBLE) {
            showTemporaryStatus("No order selected");
            return;
        }

        List<Order> displayedOrders = adapter.getCurrentOrders();
        Order toDelete = displayedOrders.get(0);

        MainActivity.ORDER_HISTORY.removeOrder(toDelete);
        allOrders.remove(toDelete);
        adapter.removeOrder(toDelete);

        showTemporaryStatus("Order deleted");

        if (allOrders.isEmpty()) {
            showEmpty("No orders remaining");
        }
    }
}
