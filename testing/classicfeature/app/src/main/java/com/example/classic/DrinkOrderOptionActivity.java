package com.example.classicdrinkfeature;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class DrinkOrderOptionActivity extends AppCompatActivity {

    private RadioGroup sizeGroup, sugarGroup, iceGroup;
    private Drink selectedDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_order_option);

        // initial UI
        TextView drinkName = findViewById(R.id.drink_name);
        TextView drinkDescription = findViewById(R.id.drink_description);
        sizeGroup = findViewById(R.id.size_group);
        sugarGroup = findViewById(R.id.sugar_group);
        iceGroup = findViewById(R.id.ice_group);
        Button addToCartButton = findViewById(R.id.btn_add_to_cart);

        // select drink
        selectedDrink = (Drink) getIntent().getSerializableExtra("selected_drink");
        if (selectedDrink == null) finish();

        drinkName.setText(selectedDrink.getName());
        drinkDescription.setText(selectedDrink.getDescription());

        // Add to Cart
        addToCartButton.setOnClickListener(v -> {
            String size = getSelectedRadioText(sizeGroup);
            String sugar = getSelectedRadioText(sugarGroup);
            String ice = getSelectedRadioText(iceGroup);

            Intent intent = new Intent(DrinkOrderOptionActivity.this, CartConfirmationActivity.class);
            intent.putExtra("name", selectedDrink.getName());
            intent.putExtra("size", size);
            intent.putExtra("sugar", sugar);
            intent.putExtra("ice", ice);
            intent.putExtra("price", selectedDrink.getPrice());
            startActivity(intent);
        });
    }

    private String getSelectedRadioText(RadioGroup group) {
        int selectedId = group.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            return radioButton.getText().toString();
        } else {
            return "";
        }
    }
}
