package com.example.sargis.s_shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sargis.s_shop.R;
import com.example.sargis.s_shop.activity.DetailActivity;
import com.example.sargis.s_shop.model.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> implements Filterable {
    public static final String POSITION_KEY = "position key";
    private Context context;
    private List<ProductModel> list;
    private List<ProductModel> listFiltered;


    public ProductsAdapter(Context context, List<ProductModel> list) {
        this.context = context;
        this.list = list;
        listFiltered = list;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductsViewHolder holder, final int position) {
        final ProductModel model = listFiltered.get(position);

        holder.productTitle.setText(model.getTitle());
        holder.productPrice.setText(model.getPrice());
        holder.ratingCount.setText(String.valueOf(model.getRating()));
        holder.productRating.setRating(model.getRating());
        Picasso.get().load(model.getImagesUrl()[0]).into(holder.productImg);

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.favBtn.setImageResource(R.drawable.ic_favorite_red);
                model.setLiked(true);
            }
        });

        holder.cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cartBtn.setImageResource(R.drawable.ic_shopping_cart_black_24dp);
                model.setToBasket(true);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(POSITION_KEY, position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    listFiltered = list;
                } else {
                    List<ProductModel> filteredList = new ArrayList<>();
                    for (ProductModel row : list) {
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    listFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listFiltered;
                filterResults.count = listFiltered.size();

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listFiltered = (ArrayList<ProductModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder {
        ImageView productImg;
        TextView productTitle;
        TextView productPrice;
        TextView ratingCount;
        RatingBar productRating;
        ImageButton favBtn;
        ImageButton cartBtn;

        ProductsViewHolder(View itemView) {
            super(itemView);
            productImg = itemView.findViewById(R.id.product_img);
            productTitle = itemView.findViewById(R.id.product_title);
            productPrice = itemView.findViewById(R.id.product_price);
            ratingCount = itemView.findViewById(R.id.rating_count);
            productRating = itemView.findViewById(R.id.product_rating);
            favBtn = itemView.findViewById(R.id.fav_btn);
            cartBtn = itemView.findViewById(R.id.card_btn);
        }
    }
}
