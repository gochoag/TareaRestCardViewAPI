package com.example.restcardviewapi.Adaptador;

import android.app.Dialog;
import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.restcardviewapi.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        Dialog dxl=new Dialog(holder.imageView.getContext());
        dxl.setContentView(R.layout.lyfotomodal);
        ImageView imgdial=dxl.findViewById(R.id.dlimg);
        ImageButton bntCERRAR=dxl.findViewById(R.id.botoncerrar);

        bntCERRAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dxl.hide();
            }
        });
        holder.imageView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(Ctx)
                        .load(cell)
                        .into(imgdial);
                dxl.show();
            }
        });
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