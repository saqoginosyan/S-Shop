package com.example.sargis.s_shop.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.sargis.s_shop.adapter.DetailAdapter;
import com.example.sargis.s_shop.model.ProductModel;
import com.example.sargis.s_shop.provider.ProductProvider;
import com.example.sargis.s_shop.adapter.ProductsAdapter;
import com.example.sargis.s_shop.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ProductModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final int position = getIntent().getIntExtra(ProductsAdapter.POSITION_KEY, 0);
        model = ProductProvider.getProductByPosition(position);
        final ImageView detailImg = findViewById(R.id.detail_img);
        final RecyclerView recyclerView = findViewById(R.id.detail_recycler);
        final TextView description = findViewById(R.id.description);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        final DetailAdapter detailAdapter = new DetailAdapter(this, model.getImagesUrl());
        recyclerView.setAdapter(detailAdapter);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(model.getTitle());
        description.setText(model.getDescription());
        Picasso.get().load(model.getImagesUrl()[0]).into(detailImg);

        setUpVideoView();
    }

    private void setUpVideoView() {
        final VideoView videoView = findViewById(R.id.video_view);
        videoView.setVideoURI(Uri.parse(model.getVideoUrl()));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
