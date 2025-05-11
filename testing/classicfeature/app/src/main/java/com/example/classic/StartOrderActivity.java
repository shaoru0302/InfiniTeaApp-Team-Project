// Scenario 2: Green & Refactor needed file
package com.example.classicdrinkfeature;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StartOrderActivity extends AppCompatActivity implements DrinkAdapter.OnDrinkClickListener {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink_list);

        RecyclerView recyclerView = findViewById(R.id.menu_drink_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        DrinkRepository repo = new DrinkRepository();
        List<Drink> drinkList = repo.getClassicDrinks();

        DrinkAdapter adapter = new DrinkAdapter(drinkList, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onDrinkClick(Drink drink) {
        Intent intent = new Intent(this, DrinkOrderOptionActivity.class);
        intent.putExtra("selected_drink", drink.getPrice());
        startActivity(intent);
    }
}
