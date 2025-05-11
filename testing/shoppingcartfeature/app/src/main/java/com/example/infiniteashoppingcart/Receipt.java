package com.example.infiniteashoppingcart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Handler;

import android.os.CountDownTimer;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import java.util.ArrayList;
import java.util.UUID;

public class Receipt extends AppCompatActivity {

    private ArrayList<BubbleTea> bubbleTeaList;
    private RecyclerView recyclerView2;

    private RecyclerAdapter adapter2;
    private TextView dateDetail;
    private TextView orderIdText;


    String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            .format(new Date());

    String orderId = UUID.randomUUID().toString();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        bubbleTeaList = new ArrayList<>();
        recyclerView2 =findViewById(R.id.recyclerView2);
        RecyclerAdapter.SetRemoveButtonVisible(false);


        for(BubbleTea b :Cart.staticBubbleTeaList){
            bubbleTeaList.add(b);
        }
        setAdaptor();
        TextView totalPriceText = findViewById(R.id.totalPrice2);
        totalPriceText.setText("Total: $ "+CalculateTotalPrice(bubbleTeaList) );
        dateDetail=findViewById(R.id.dateDetails);
        dateDetail.setText("Date: "+ currentDate);

        orderIdText=findViewById(R.id.orderIdText);
        orderIdText.setText("OrderID: "+orderId);

        TextView countdownText =findViewById(R.id.timeCountText);

        new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished){
                countdownText.setText("Returning in " + millisUntilFinished / 1000 + "...");
            }
            public void onFinish() {
                countdownText.setText("Returning now...");
                Intent intent = new Intent(Receipt.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                bubbleTeaList.clear();
            }
        }.start();










    }
    public  float CalculateTotalPrice(ArrayList<BubbleTea> list){

        float total =0f;
        for(BubbleTea item : bubbleTeaList){
            total+= item.getTotalPrice();
        }
        return total;


    }

    private void setAdaptor() {
        adapter2 = new RecyclerAdapter(bubbleTeaList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(adapter2);
    }
}

