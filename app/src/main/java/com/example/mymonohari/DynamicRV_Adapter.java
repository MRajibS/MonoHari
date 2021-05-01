package com.example.mymonohari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DynamicRV_Adapter extends RecyclerView.Adapter<DynamicRV_Adapter.DynamicRVViewHolder> {
    private ArrayList<DynamicRV_Model> itemList;
    private int row_index = -1;

    public DynamicRV_Adapter(ArrayList<DynamicRV_Model> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DynamicRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item,parent,false);
        DynamicRVViewHolder dynamicRVViewHolder=new DynamicRVViewHolder(view);
        return dynamicRVViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRVViewHolder holder, int position) {
        DynamicRV_Model currentItem=itemList.get(position);
        holder.imageView.setImageResource(currentItem.getImg());
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
        return itemList.size();
    }

    public class DynamicRVViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public DynamicRVViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
            imageView=itemView.findViewById(R.id.image);
            linearLayout=itemView.findViewById(R.id.linearlayout);
        }


    }
}
