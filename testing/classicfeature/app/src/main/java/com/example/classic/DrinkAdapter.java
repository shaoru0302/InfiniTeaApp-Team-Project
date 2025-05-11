package com.example.classicdrinkfeature;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {

    private List<Drink> drinks;
    private OnDrinkClickListener listener;

    public interface OnDrinkClickListener {
        void onDrinkClick(Drink drink);
    }

    public DrinkAdapter(List<Drink> drinks, OnDrinkClickListener listener) {
        this.drinks = drinks;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drink_list_item_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drink drink = drinks.get(position);
        holder.name.setText(drink.getName());
        holder.description.setText(drink.getDescription());
        holder.price.setText(String.format("Price: $%.2f", drink.getPrice()));

        holder.itemView.setOnClickListener(v -> listener.onDrinkClick(drink));
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.drink_name);
            description = itemView.findViewById(R.id.drink_description);
            price = itemView.findViewById(R.id.drink_price);
        }
    }
}
