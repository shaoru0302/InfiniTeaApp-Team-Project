package com.example.infinitea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * ChooseDrinkActivity displays a list of classic milk tea drinks for users to select from.
 * Users can customize size, sugar, ice, and quantity, then add the selected drink(s) to the shopping cart.
 * Also provides a button to navigate to the "Build Your Own" drink customization screen.
 */

public class ChooseDrinkActivity extends AppCompatActivity {

    private MilkTea currentSelectedDrink;

    private View customizeSection;
    private TextView selectedDrinkName;
    private Spinner spinnerSize, spinnerSugar, spinnerIce;
    private EditText editQuantity;
    private Button btnIncreaseQuantity, btnDecreaseQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_drink);

        // Initialize RecyclerView
        RecyclerView drinkRecyclerView = findViewById(R.id.drinkRecyclerView);
        drinkRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<MenuItem> drinkList = MenuRepository.getClassicMilkTeaMenu();

        MenuAdapter adapter = new MenuAdapter(drinkList, selectedItem -> {
            // Convert MenuItem to MilkTea
            MilkTea selectedDrink = new MilkTea(
                    selectedItem.getName(),
                    selectedItem.getDescription(),
                    null,
                    true,
                    Size.S,  // default value
                    Sugar.REGULAR,
                    Ice.REGULAR,
                    selectedItem.getToppings(),
                    Size.S.getBasePrice()
            );

            customizeSection.setVisibility(View.VISIBLE);
            selectedDrinkName.setText(selectedDrink.getName());
            currentSelectedDrink = selectedDrink;

            showCustomizeDialog();
        });


        drinkRecyclerView.setAdapter(adapter);

        Button btnBuildYourOwn = findViewById(R.id.btnBuildYourOwn);
        btnBuildYourOwn.setOnClickListener(v -> {
            Intent intent = new Intent(ChooseDrinkActivity.this, BuildYourOwnActivity.class);
            startActivity(intent);
        });


        // Initialize customize section (hidden by default)
        customizeSection = findViewById(R.id.customizeSection);
        selectedDrinkName = findViewById(R.id.selectedDrinkName);
        spinnerSize = findViewById(R.id.spinnerSize);
        spinnerSugar = findViewById(R.id.spinnerSugar);
        spinnerIce = findViewById(R.id.spinnerIce);
        editQuantity = findViewById(R.id.editQuantity);
        btnIncreaseQuantity = findViewById(R.id.btnIncreaseQuantity);
        btnDecreaseQuantity = findViewById(R.id.btnDecreaseQuantity);

        // Setup Spinners
        ArrayAdapter<Size> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Size.values());
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(sizeAdapter);

        ArrayAdapter<Sugar> sugarAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Sugar.values());
        sugarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSugar.setAdapter(sugarAdapter);

        ArrayAdapter<Ice> iceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Ice.values());
        iceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIce.setAdapter(iceAdapter);

        // Quantity control
        btnIncreaseQuantity.setOnClickListener(v -> {
            int qty = getQuantity();
            editQuantity.setText(String.valueOf(qty + 1));
        });

        btnDecreaseQuantity.setOnClickListener(v -> {
            int qty = getQuantity();
            if (qty > 1) {
                editQuantity.setText(String.valueOf(qty - 1));
            }
        });
    }

    private int getQuantity() {
        String text = editQuantity.getText().toString().trim();
        if (text.isEmpty()) return 1;
        try {
            int qty = Integer.parseInt(text);
            return Math.max(qty, 1);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public void addToCart(View view) {
        if (currentSelectedDrink == null) {
            Toast.makeText(this, "Please select a drink first.", Toast.LENGTH_SHORT).show();
            return;
        }

        Size selectedSize = (Size) spinnerSize.getSelectedItem();
        Sugar selectedSugar = (Sugar) spinnerSugar.getSelectedItem();
        Ice selectedIce = (Ice) spinnerIce.getSelectedItem();
        int quantity = getQuantity();

        // Get default toppings for the classic drink
        ArrayList<Topping> defaultToppings = new ArrayList<>(currentSelectedDrink.getToppings());

        for (int i = 0; i < quantity; i++) {
            MilkTea customizedDrink = new MilkTea(
                    currentSelectedDrink.getName(),
                    currentSelectedDrink.getDescription(),
                    null,
                    true,
                    selectedSize,
                    selectedSugar,
                    selectedIce,
                    defaultToppings,
                    selectedSize.getBasePrice()
            );

            MainActivity.SHOPPING_CART.add(customizedDrink);
        }

        Toast.makeText(this, "Added " + quantity + " drink(s) to cart!", Toast.LENGTH_SHORT).show();
        customizeSection.setVisibility(View.GONE);
    }

    private void showCustomizeDialog() {
        spinnerSize.setSelection(0);   // Reset to default SMALL
        spinnerSugar.setSelection(0);  // Reset to default REGULAR
        spinnerIce.setSelection(0);    // Reset to default REGULAR
        editQuantity.setText("1");     // Reset quantity
    }

    public void goBackToHome(View view) {
        finish(); // back to home
    }
}
