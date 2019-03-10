package com.dsc.android.bootcamp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context context;
    private LayoutInflater layoutInflater;
    private List <RecyclerViewData> recyclerViewDataList = new ArrayList<>();

    public void setRecyclerViewDataList(List<RecyclerViewData> recyclerViewDataList) {
        this.recyclerViewDataList = recyclerViewDataList;
    }

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        RecyclerViewData data = recyclerViewDataList.get(i);

        Log.i("Log====",data.getName());
        Log.i("Log====",data.getNumber());

        holder.txt_name.setText(data.getName());
        holder.txt_number.setText(data.getNumber());

        Glide.with(context).load(data.getImage()).apply(RequestOptions.circleCropTransform()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return recyclerViewDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_name,txt_number;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.txt_name);
            txt_number = itemView.findViewById(R.id.txt_number);
            img=itemView.findViewById(R.id.img);
        }
    }
}
