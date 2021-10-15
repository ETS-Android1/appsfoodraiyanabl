package com.example.burgerrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ListBurgerAdapter extends RecyclerView.Adapter<ListBurgerAdapter.ListViewHolder>{
    private ArrayList<burger> listBurger;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    public ListBurgerAdapter(ArrayList<burger> list) {
            this.listBurger =list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_burger, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
     burger burger = listBurger.get(position);
        Glide.with(holder.itemView.getContext())
                .load(burger.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(burger.getName());
        holder.tvDeskripsi.setText(burger.getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listBurger.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBurger.size();
    }

     class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
         TextView tvName;
         TextView tvDeskripsi;

         ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_burger);
             tvName= itemview.findViewById(R.id.tv_item_name);
             tvDeskripsi= itemview.findViewById(R.id.tv_deskripsi);
        }
    }
    public interface OnItemClickCallback{
        void onItemClicked( burger data);
    }
}
