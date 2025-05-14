package com.example.infinitea;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This adapter handles displaying a list of drink menu items inside a RecyclerView.
 * When the user taps on a drink, it sends back a MilkTea object using a callback.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuItem> menuList;
    private OnDrinkClickListener listener;

    public interface OnDrinkClickListener {
        void onDrinkClick(MilkTea selectedDrink);
    }

    public MenuAdapter(List<MenuItem> menuList, OnDrinkClickListener listener) {
        this.menuList = menuList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_drink, parent, false);
        return new MenuViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem drink = menuList.get(position);
        holder.drinkName.setText(drink.getName());
        holder.drinkDetails.setText(drink.getDescription() + drink.getDefaultToppings());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                // Convert MenuItem to MilkTea
                MilkTea selectedMilkTea = new MilkTea(
                        drink.getName(),
                        drink.getDescription(),
                        null,
                        true,
                        Size.S,
                        Sugar.REGULAR,
                        Ice.REGULAR,
                        drink.getDefaultToppings(),
                        Size.S.getBasePrice()
                );

                listener.onDrinkClick(selectedMilkTea);
            }
        });


    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView drinkName, drinkDetails;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            drinkName = itemView.findViewById(R.id.txt_drink_name);
            drinkDetails = itemView.findViewById(R.id.txt_drink_details);
        }
    }
}
