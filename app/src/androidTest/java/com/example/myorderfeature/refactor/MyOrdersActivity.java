// Scenario 2: REFACTOR – Cleaned MyOrdersActivity using OrderFilter
package com.example.myorderfeature;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView emptyText;
    private EditText searchInput;
    private OrderAdapter adapter;
    private List<Order> allOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        recyclerView = findViewById(R.id.orders_recycler_view);
        emptyText = findViewById(R.id.empty_text);
        searchInput = findViewById(R.id.search_order_input);

        allOrders = new OrderRepository().getPastOrders();

        if (allOrders.isEmpty()) {
            showEmpty("No orders yet");
        } else {
            setupRecyclerView(allOrders);
        }

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

    private void setupRecyclerView(List<Order> orders) {
        recyclerView.setVisibility(View.VISIBLE);
        emptyText.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderAdapter(orders);
        recyclerView.setAdapter(adapter);
    }

    private void showEmpty(String message) {
        recyclerView.setVisibility(View.GONE);
        emptyText.setVisibility(View.VISIBLE);
        emptyText.setText(message);
    }

    private void filterOrders(String query) {
        List<Order> filtered = OrderFilter.filterByKeyword(allOrders, query);

        if (filtered.isEmpty()) {
            showEmpty("Order not found");
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyText.setVisibility(View.GONE);
            adapter.updateData(filtered);
        }
    }

    public void RemoveOrder(View view) {
        Toast.makeText(this, "Delete Order clicked", Toast.LENGTH_SHORT).show();
    }

}