package com.example.burgerrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailBurger extends AppCompatActivity {
    public static final String ITEM_EXTRA ="item_extra";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_burger);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openorder ();
            }
        });

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
    public void openorder(){
        Intent intent = new Intent(this, order.class);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}