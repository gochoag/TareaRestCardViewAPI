package com.example.restcardviewapi.Adaptador;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.restcardviewapi.R;

import java.util.List;

public class AdaptadorFotos extends RecyclerView.Adapter<AdaptadorFotos.CelularViewHolder>{
    private Context Ctx;
    private List<String> lstFotos;
    public AdaptadorFotos(Context mCtx, List<String> cellu) {
        this.lstFotos = cellu;
        Ctx=mCtx;
    }
    @Override
    public AdaptadorFotos.CelularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyitemfotos, null);
        return new AdaptadorFotos.CelularViewHolder(view);
    }
    @Override
    public void onBindViewHolder(AdaptadorFotos.CelularViewHolder holder, int position) {
        String cell = lstFotos.get(position);


        Glide.with(Ctx)
                .load(cell)
                .into(holder.imageView);

    }
    @Override
    public int getItemCount() { return lstFotos.size(); }
    class CelularViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public CelularViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgFotos);

        }
    }

}