// Scenario 3: REFACTOR – handle order item & list display
package com.example.myorderfeature;

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

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.itemName.setText(order.getItemName());
        holder.itemPrice.setText(order.getPrice());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void updateData(List<Order> newOrders) {
        this.orders = newOrders;
        notifyDataSetChanged();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, itemPrice, orderNumber;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.txt_order_item);
            itemPrice = itemView.findViewById(R.id.txt_order_price);
            orderNumber = itemView.findViewById(R.id.search_order_input);
        }
    }
}
