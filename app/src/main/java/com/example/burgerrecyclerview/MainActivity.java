package com.example.burgerrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBurger;
    private ArrayList<burger> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBurger = findViewById(R.id.rv_burger);
        rvBurger.setHasFixedSize(true);

        list.addAll(Burgerdata.getListData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvBurger.setLayoutManager(new LinearLayoutManager(this));
        ListBurgerAdapter listBurgerAdapter = new ListBurgerAdapter(list);
        rvBurger.setAdapter(listBurgerAdapter);

        listBurgerAdapter.setOnItemClickCallback(new ListBurgerAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(burger burger) {
                Intent moveIntent = new Intent(MainActivity.this, DetailBurger.class);
                moveIntent.putExtra(DetailBurger.ITEM_EXTRA,burger);
                startActivity(moveIntent);
            }

        });


    }


}