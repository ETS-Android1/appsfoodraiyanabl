package com.example.burgerrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailBurger extends AppCompatActivity {
    public static final String ITEM_EXTRA ="item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_burger);

        ImageView imgBurger = findViewById(R.id.imgBurger);
        TextView tvBurgerName = findViewById(R.id.tvBurgerName);
        TextView tvBurgerDeskripsi = findViewById(R.id.tvBurgerDeskripsi);

        burger burger = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (burger != null){
            Glide.with(this)
                    .load(burger.getImage())
                    .into(imgBurger);
            tvBurgerName.setText(burger.getName());
            tvBurgerDeskripsi.setText(burger.getDeskripsi());


            }
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Burger Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}