package com.example.mymonohari;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaticRV_Adapter extends RecyclerView.Adapter<StaticRV_Adapter.StaticRVViewHolder> {
    private ArrayList<StaticRV_Model> itemList;
    private int row_index=-1;

    public StaticRV_Adapter(ArrayList<StaticRV_Model> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRVViewHolder staticRVViewHolder=new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
    StaticRV_Model currentItem=itemList.get(position);
    holder.imageView.setImageResource(currentItem.getImage());
    holder.textView.setText(currentItem.getText());
    holder.linearLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            row_index=position;
            notifyDataSetChanged();
        }
    });
    if(row_index==position){
        holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
    }else{
        holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
    }
    }

    @Override
    public int getItemCount() {
        return itemList.size();// Important Line to Remember If it will be zero nothing will display in RecyclerView
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            linearLayout=itemView.findViewById(R.id.linearlayout);
        }
    }


}
