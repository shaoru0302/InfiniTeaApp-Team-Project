package com.example.infinitea;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This adapter shows a list of past orders on the screen.
 * For each order, it displays the drinks, date, and price info.
 * It can also show checkboxes if we want to let users select drinks (like for reordering).
 * It keeps track of which drinks were selected using a simple map.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> orders;
    private final Map<Order, List<MilkTea>> selectedDrinksMap = new HashMap<>();
    private boolean showCheckboxes = false;

    public OrderAdapter(List<Order> orders) {
        orders.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        this.orders = orders;
    }
    public void setShowCheckboxes(boolean show) {
        this.showCheckboxes = show;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orders.get(position);

        holder.orderNumber.setText("Order #: " + order.getOrderNumber());
        holder.drinkContainer.removeAllViews();

        for (MilkTea drink : order.getListOfDrinks()) {
            LinearLayout drinkRow = new LinearLayout(holder.itemView.getContext());
            drinkRow.setOrientation(LinearLayout.HORIZONTAL);
            drinkRow.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            drinkRow.setPadding(0, 8, 0, 8);

            // TextView for drink info
            TextView drinkText = new TextView(holder.itemView.getContext());
            drinkText.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            drinkText.setTextSize(15);
            drinkText.setTextColor(Color.parseColor("#333333"));
            drinkText.setSingleLine(false);
            drinkText.setMaxLines(Integer.MAX_VALUE);
            drinkText.setEllipsize(null);
            drinkText.setPadding(0, 0, 16, 0); // Right padding
            drinkText.setLineSpacing(4f, 1.1f); // Optional spacing
            drinkText.requestLayout();

            // Build drink text
            StringBuilder drinkBuilder = new StringBuilder();
            drinkBuilder.append("• ").append(drink.getName())
                    .append(" - $").append(String.format("%.2f", drink.getTotalPrice()))
                    .append(" (").append(drink.getSize()).append(")");

            if (!drink.isAvailable()) {
                drinkBuilder.append(" [Out of Stock]");
            }

            if (drink.getTeaBase() != null) {
                drinkBuilder.append("\n   • Tea Base: ").append(drink.getTeaBase());
            }

            drinkBuilder.append("\n   • Sugar: ").append(drink.getSugar());
            drinkBuilder.append("\n   • Ice: ").append(drink.getIce());

            if (drink.getToppings() != null && !drink.getToppings().isEmpty()) {
                List<String> toppingNames = new ArrayList<>();
                for (Topping topping : drink.getToppings()) {
                    toppingNames.add(topping.toString());
                }
                drinkBuilder.append("\n   • Toppings: ").append(String.join(", ", toppingNames));
            }

            drinkText.setText(drinkBuilder.toString());

            // Wrap text in a vertical layout to avoid layout compression
            LinearLayout textWrapper = new LinearLayout(holder.itemView.getContext());
            textWrapper.setOrientation(LinearLayout.VERTICAL);
            textWrapper.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1.0f
            ));
            textWrapper.addView(drinkText);

            // Create checkbox
            CheckBox checkBox = new CheckBox(holder.itemView.getContext());
            checkBox.setText("Add");
            checkBox.setTextColor(Color.parseColor("#2E7D32"));
            checkBox.setTextSize(14);
            LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            checkParams.setMargins(16, 0, 0, 0);
            checkBox.setLayoutParams(checkParams);

            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                List<MilkTea> selectedDrinks = selectedDrinksMap.getOrDefault(order, new ArrayList<>());
                if (isChecked) {
                    if (!selectedDrinks.contains(drink)) {
                        selectedDrinks.add(drink);
                    }
                } else {
                    selectedDrinks.remove(drink);
                }
                selectedDrinksMap.put(order, selectedDrinks);
            });

            drinkRow.addView(textWrapper);
            if (showCheckboxes) {
                drinkRow.addView(checkBox);
            }

            holder.drinkContainer.addView(drinkRow);
        }

        holder.totalPrice.setText(
                "Subtotal: $" + order.calculateSubtotal() + "\n" +
                        "Tax: $" + order.calculateSalesTax() + "\n" +
                        "Total: $" + order.calculateOrderTotal()
        );

        holder.date.setText("Date: " + (order.getDate() != null ? order.getDate() : "N/A"));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<Order> newOrders) {
        newOrders.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        this.orders = newOrders;
        notifyDataSetChanged();
    }

    public List<MilkTea> getSelectedDrinks() {
        List<MilkTea> selected = new ArrayList<>();
        for (List<MilkTea> drinks : selectedDrinksMap.values()) {
            selected.addAll(drinks);
        }
        return selected;
    }

    public List<Order> getCurrentOrders() {
        return orders;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void removeOrder(Order order) {
        orders.remove(order);
        notifyDataSetChanged();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderNumber, totalPrice, date;
        LinearLayout drinkContainer;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderNumber = itemView.findViewById(R.id.txt_order_number);
            totalPrice = itemView.findViewById(R.id.txt_order_price);
            date = itemView.findViewById(R.id.txt_order_date);
            drinkContainer = itemView.findViewById(R.id.drink_container);
        }
    }
}
