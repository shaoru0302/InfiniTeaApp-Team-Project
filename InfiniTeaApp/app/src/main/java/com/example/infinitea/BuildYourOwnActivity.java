package com.example.infinitea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

/**
 * BuildYourOwnActivity allows users to fully customize their own milk tea drinks.
 * Users can choose tea base, size, sugar, ice, toppings (up to 3), and quantity.
 * The activity displays a live price summary and adds the drink to the shopping cart.
 */

public class BuildYourOwnActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listAvailableToppings, listSelectedToppings;
    private TextView textPrice, selectedToppingsLabel;

    private ArrayAdapter<String> availableAdapter, selectedAdapter;
    private ArrayList<String> availableToppings, selectedToppings;

    private TeaBase selectedTeaBase;
    private Size selectedSize = Size.S;
    private Sugar selectedSugar = Sugar.REGULAR;
    private Ice selectedIce = Ice.REGULAR;
    private int selectedQuantity = 1;

    private static final double TAX_RATE = 0.08875;
    private static final int MAX_TOPPINGS = 3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_your_own);

        Button btnCustomizeDrink = findViewById(R.id.btnCustomizeDrink);
        btnCustomizeDrink.setOnClickListener(v -> showCustomizeDialog());

        listAvailableToppings = findViewById(R.id.listAvailableToppings);
        listSelectedToppings = findViewById(R.id.listSelectedToppings);
        textPrice = findViewById(R.id.textPrice);
        selectedToppingsLabel = findViewById(R.id.selectedToppings);

        availableToppings = new ArrayList<>();
        selectedToppings = new ArrayList<>();
        for (Topping t : Topping.values()) {
            availableToppings.add(t.toString());
        }

        availableAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, availableToppings);
        selectedAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedToppings);
        listAvailableToppings.setAdapter(availableAdapter);
        listSelectedToppings.setAdapter(selectedAdapter);

        Utility.setListViewHeightBasedOnChildren(listAvailableToppings);
        Utility.setListViewHeightBasedOnChildren(listSelectedToppings);

        listAvailableToppings.setOnItemClickListener(this);
        listSelectedToppings.setOnItemClickListener(this);

    }

    private void showCustomizeDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_customize, null);

        Spinner dialogSpinnerSize = dialogView.findViewById(R.id.dialogSpinnerSize);
        Spinner dialogSpinnerSugar = dialogView.findViewById(R.id.dialogSpinnerSugar);
        Spinner dialogSpinnerIce = dialogView.findViewById(R.id.dialogSpinnerIce);
        Spinner dialogSpinnerTeaBase = dialogView.findViewById(R.id.dialogSpinnerTeaBase);
        EditText dialogEditQuantity = dialogView.findViewById(R.id.dialogEditQuantity);
        Button btnIncreaseQuantity = dialogView.findViewById(R.id.dialogBtnIncreaseQuantity);
        Button btnDecreaseQuantity = dialogView.findViewById(R.id.dialogBtnDecreaseQuantity);

        dialogSpinnerTeaBase.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, TeaBase.values()));
        dialogSpinnerSize.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Size.values()));
        dialogSpinnerSugar.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Sugar.values()));
        dialogSpinnerIce.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Ice.values()));

        dialogEditQuantity.setText(String.valueOf(selectedQuantity));

        btnIncreaseQuantity.setOnClickListener(v -> {
            int qty = getQuantity(dialogEditQuantity);
            dialogEditQuantity.setText(String.valueOf(qty + 1));
        });

        btnDecreaseQuantity.setOnClickListener(v -> {
            int qty = getQuantity(dialogEditQuantity);
            if (qty > 1) {
                dialogEditQuantity.setText(String.valueOf(qty - 1));
            }
        });

        new AlertDialog.Builder(this)
                .setTitle("Customize Your Drink")
                .setView(dialogView)
                .setPositiveButton("Confirm", (dialog, which) -> {
                    selectedTeaBase = (TeaBase) dialogSpinnerTeaBase.getSelectedItem();
                    selectedSize = (Size) dialogSpinnerSize.getSelectedItem();
                    selectedSugar = (Sugar) dialogSpinnerSugar.getSelectedItem();
                    selectedIce = (Ice) dialogSpinnerIce.getSelectedItem();
                    selectedQuantity = getQuantity(dialogEditQuantity);
                    updatePrice();
                    Toast.makeText(this, "Customization saved!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private int getQuantity(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) return 1;
        try {
            int qty = Integer.parseInt(text);
            return Math.max(qty, 1);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String topping = (String) parent.getItemAtPosition(position);
        if (parent == listAvailableToppings) {
            if (selectedToppings.size() < MAX_TOPPINGS) {
                selectedToppings.add(topping);
                availableToppings.remove(topping);
            } else {
                Toast.makeText(this, "Max 3 toppings allowed!", Toast.LENGTH_SHORT).show();
            }
        } else if (parent == listSelectedToppings) {
            availableToppings.add(topping);
            selectedToppings.remove(topping);
        }

        availableAdapter.notifyDataSetChanged();
        selectedAdapter.notifyDataSetChanged();
        updatePrice();

        Utility.setListViewHeightBasedOnChildren(listAvailableToppings);
        Utility.setListViewHeightBasedOnChildren(listSelectedToppings);
    }

    @SuppressLint("SetTextI18n")
    private void updatePrice() {
        if (selectedSize == null) {
            textPrice.setText("");
            return;
        }

        double pricePerDrink = selectedSize.getBasePrice();
        int extraCount = Math.max(0, selectedToppings.size() - 1);
        pricePerDrink += extraCount * 0.50;

        double subtotal = pricePerDrink * selectedQuantity;
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;

        selectedToppingsLabel.setText("Selected Toppings (" + selectedToppings.size() + "/3)");

        @SuppressLint("DefaultLocale") String display = String.format(
                "Subtotal: $%.2f\nTax (8.88%%): $%.2f\nTotal: $%.2f",
                subtotal, tax, total
        );

        textPrice.setText(display);
    }

    public void addToCart(View view) {
        if (selectedTeaBase == null) {
            Toast.makeText(this, "Please customize your drink first!", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<Topping> finalToppings = new ArrayList<>();
        for (String name : selectedToppings) {
            finalToppings.add(Topping.valueOf(name.toUpperCase().replace(" ", "_")));
        }

        for (int i = 0; i < selectedQuantity; i++) {
            MilkTea customTea = new MilkTea(
                    "Customized drink:",
                    null,
                    selectedTeaBase,
                    true,
                    selectedSize,
                    selectedSugar,
                    selectedIce,
                    finalToppings,
                    selectedSize.getBasePrice()
            );
            MainActivity.SHOPPING_CART.add(customTea);
        }

        Toast.makeText(this, "Added " + selectedQuantity + " drink(s) to Cart!", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void goBackToHome(View view) {
        finish();
    }
}