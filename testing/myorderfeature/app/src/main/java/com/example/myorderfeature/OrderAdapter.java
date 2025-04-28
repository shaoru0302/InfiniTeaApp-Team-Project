// contains and display the items as list in the order history
package com.example.myorderfeature;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> orders;

    public OrderAdapter(List<Order> orders) {
        this.orders = orders;
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

        StringBuilder itemBuilder = new StringBuilder();
        for (Item item : order.getItems()) {
            itemBuilder.append("• ").append(item.getItemName());
            itemBuilder.append(" - $").append(String.format("%.2f", item.getPrice()));
            itemBuilder.append(" (").append(item.getSize()).append(")");

            if (!item.isAvailable()) {
                itemBuilder.append(" [Out of Stock]");
            }

            itemBuilder.append("\n   Sugar: ").append(item.getSugar())
                    .append(", Ice: ").append(item.getIce());

            if (item.getToppings() != null && !item.getToppings().isEmpty()) {
                itemBuilder.append(", Toppings: ")
                        .append(String.join(", ", item.getToppings()));
            }

            itemBuilder.append("\n\n");
        }

        holder.itemDetails.setText(itemBuilder.toString().trim());

        holder.totalPrice.setText(String.format("Total: $%.2f", order.getTotalPrice()));
        holder.date.setText("Date: " + order.getDate());
    }


    @Override
    public int getItemCount() {
        return orders.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<Order> newOrders) {
        this.orders = newOrders;
        notifyDataSetChanged();
    }

    public List<Order> getCurrentOrders() {
        return orders;
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView itemDetails, totalPrice, date;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            itemDetails = itemView.findViewById(R.id.txt_order_item);
            totalPrice = itemView.findViewById(R.id.txt_order_price);
            date = itemView.findViewById(R.id.txt_order_date);
        }
    }
}
