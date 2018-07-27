package com.example.sargis.s_shop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sargis.s_shop.R;
import com.squareup.picasso.Picasso;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    private Context context;
    private String[] list;

    public DetailAdapter(Context context, String[] list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.detail_image_item, parent, false);
        return new DetailAdapter.DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        Picasso.get().load(list[position]).into(holder.detailImgMultyple);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {
        ImageView detailImgMultyple;

        DetailViewHolder(View itemView) {
            super(itemView);
            detailImgMultyple = itemView.findViewById(R.id.detail_multyple_img);
        }
    }
}
