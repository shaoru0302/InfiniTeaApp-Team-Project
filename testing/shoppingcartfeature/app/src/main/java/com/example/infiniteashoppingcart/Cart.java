package com.example.infiniteashoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {


    public static ArrayList<BubbleTea> staticBubbleTeaList = new ArrayList<>();

    private RecyclerAdapter adapter;

    private ArrayList<BubbleTea> bubbleTeaList;

    private RecyclerView recyclerView;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        bubbleTeaList = new ArrayList<>();
        recyclerView =findViewById(R.id.recyclerView);
        RecyclerAdapter.SetRemoveButtonVisible(true);



        setInfo();
        setAdaptor();
        TextView totalPriceText = findViewById(R.id.totalPrice);
        totalPriceText.setText("Total: $ "+CalculateTotalPrice(bubbleTeaList));



    }

    public void OrderButton(View view){

        if(!bubbleTeaList.isEmpty()) {
            Intent intent = new Intent(this,Receipt.class);
            startActivity(intent);
            PassDataFromListToStaticList();
            bubbleTeaList.clear();

        }else{

        }


    }

    private void setAdaptor() {
         adapter = new RecyclerAdapter(bubbleTeaList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setInfo() {

        bubbleTeaList.add(new BubbleTea("Thai milk tea",6, 2,DrinkSize.LARGE,Topping.Bubble,IceLevel.Half,SugarLevel.Defualt));
        bubbleTeaList.add(new BubbleTea("Green tea",6, 1,DrinkSize.MEDIUM,Topping.Pudding,IceLevel.None,SugarLevel.Half));
        bubbleTeaList.add(new BubbleTea("Black tea",6, 3,DrinkSize.SMALL,Topping.RedBean,IceLevel.Defualt,SugarLevel.None));
    }



    public  float CalculateTotalPrice(ArrayList<BubbleTea> list){

        float total =0f;
        for(BubbleTea item : bubbleTeaList){
            total+= item.getTotalPrice();
        }
        return total;


    }



   public void RemoveAll(View view){


        bubbleTeaList.clear();
        adapter.notifyDataSetChanged(); // This tells RecyclerView to refresh
        TextView totalPriceText = findViewById(R.id.totalPrice);
        totalPriceText.setText("Total: $ 0.0");
    }


    public void Show(View view){
        view =findViewById(R.id.overLayBlocker);
        view.setVisibility(View.VISIBLE);


    }

    public void Hide(View view){
        view =findViewById(R.id.overLayBlocker);
        view.setVisibility(View.GONE);

    }

    public void ConfirmClickOnRemoveAll(View view){
        Hide(view);
        RemoveAll(view);



    }

    public void PassDataFromListToStaticList(){
        staticBubbleTeaList.clear();
        for(BubbleTea bubbleTea:this.bubbleTeaList){
            staticBubbleTeaList.add(bubbleTea);
        }
    }










}