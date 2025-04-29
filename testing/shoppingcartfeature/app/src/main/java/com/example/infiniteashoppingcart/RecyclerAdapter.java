package com.example.infiniteashoppingcart;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<BubbleTea> bubbleTeaList;

    public RecyclerAdapter(ArrayList<BubbleTea> bubbleTeaList ){
        this.bubbleTeaList=bubbleTeaList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameText;
        private TextView priceText;
        private TextView quantityText;
        private TextView sizeText;

        private TextView toppingText;
        private TextView iceLevelText;

        private TextView sugarLevelText;

        public MyViewHolder(final View view){
            super(view);
            nameText=view.findViewById(R.id.teaName);
            priceText = view.findViewById(R.id.price);
            quantityText=view.findViewById(R.id.quantity);
            sizeText=view.findViewById(R.id.size);
            toppingText=view.findViewById(R.id.topping);
            iceLevelText=view.findViewById(R.id.iceLevel);
            sugarLevelText=view.findViewById(R.id.sugarLevel);


        }


    }



    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        String name =bubbleTeaList.get(position).getName();
        int price =bubbleTeaList.get(position).getPrice();
        int quantity=bubbleTeaList.get(position).getQuantity();
        DrinkSize size =bubbleTeaList.get(position).getSize();
        Topping topping =bubbleTeaList.get(position).getTopping();
        IceLevel iceLevel=bubbleTeaList.get(position).getIceLevel();
        SugarLevel sugarLevel =bubbleTeaList.get(position).getSugarLevel();
        holder.nameText.setText(name);
        holder.priceText.setText("Price: $" + price*quantity);
        holder.quantityText.setText("QTY: "+quantity);
        holder.sizeText.setText("Size: "+size);
        holder.toppingText.setText("Topping: "+topping);
        holder.sugarLevelText.setText("Sugar: "+sugarLevel);
        holder.iceLevelText.setText("IceLevel: "+iceLevel);





    }

    @Override
    public int getItemCount() {
        return bubbleTeaList.size();
    }
}
