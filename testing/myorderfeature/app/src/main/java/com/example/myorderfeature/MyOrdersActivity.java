package com.example.myorderfeature;

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


public class MyOrdersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView emptyText;
    private TextView statusText;
    private OrderAdapter adapter;
    private List<Order> allOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        recyclerView = findViewById(R.id.orders_recycler_view);
        emptyText = findViewById(R.id.empty_text);
        EditText searchInput = findViewById(R.id.search_order_input);
        statusText = findViewById(R.id.status_text);

        allOrders = new OrderRepository().getPastOrders();

        // view all orders in the recyclerView
        setupRecyclerView(allOrders);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterOrders(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void setupRecyclerView(List<Order> initialList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderAdapter(initialList);
        recyclerView.setAdapter(adapter);
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
            adapter.updateData(new ArrayList<>());
            showEmpty("Please enter an order number");
            return;
        }

        List<Order> filtered = OrderFilter.filterByKeyword(allOrders, query);

        if (filtered.isEmpty()) {
            showEmpty("Order not found");
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyText.setVisibility(View.GONE);
            adapter.updateData(filtered);
        }
    }

    public void goBackToHome(View view) {
        finish(); // go back to home page
    }


    @SuppressLint("SetTextI18n")
    public void PrintReceipt(View view) {
        if (adapter == null || adapter.getCurrentOrders().isEmpty() || recyclerView.getVisibility() != View.VISIBLE){
            showTemporaryStatus("No order selected");
            return;
        }

        showTemporaryStatus("Receipt is printing..."); // print receipt
    }


    @SuppressLint("SetTextI18n")
    public void ReorderOrder(View view) {
        if (adapter == null || adapter.getCurrentOrders().isEmpty() || recyclerView.getVisibility() != View.VISIBLE) {
            showTemporaryStatus("No order selected");
            return;
        }

        List<Order> displayedOrders = adapter.getCurrentOrders();
        int addedCount = 0;

        for (Order order : displayedOrders) {
            for (Item item : order.getItems()) {
                if (item.isAvailable()) {
                    ReorderCartManage.addToCart(
                            new Order(order.getOrderNumber(), List.of(item), order.getDate()));
                    addedCount++;
                }
            }
        }

        if (addedCount > 0) {
            showTemporaryStatus("In-stock items added to cart");    // only add the available items to cart
        } else {
            showTemporaryStatus("No available items to reorder.");  // when there's no order exists
        }
    }
}


