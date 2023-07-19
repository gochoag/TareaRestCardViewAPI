package com.example.restcardviewapi.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restcardviewapi.MainActivity;
import com.example.restcardviewapi.MainFotos;
import com.example.restcardviewapi.R;

import java.util.List;

import com.example.restcardviewapi.Modelos.Celular;

public class AdaptadorCelular extends RecyclerView.Adapter<AdaptadorCelular.CelularViewHolder>{
    private Context Ctx;
    private List<Celular> lstCelulares;
    public AdaptadorCelular(Context mCtx, List<Celular> celular) {
        this.lstCelulares = celular;
        Ctx=mCtx;
    }
    @Override
    public CelularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyitemlayout, null);
        return new CelularViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CelularViewHolder holder, int position) {
        Celular cell = lstCelulares.get(position);
        holder.textViewTitulo.setText(cell.getTitulo());
        holder.textViewDescripcion.setText(cell.getDescripcion());
        holder.textViewPrecio.setText("Precio: "+cell.getPrecio());

        Glide.with(Ctx)
                .load(cell.getUrlimagen())
                .into(holder.imageView);
        holder.cartita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bnd = new Bundle();
                bnd.putStringArrayList("imgs",cell.getFotos());
                Intent inte = new Intent(Ctx, MainFotos.class);
                inte.putExtras(bnd);
                Ctx.startActivity(inte);
            }
        });
    }
    @Override
    public int getItemCount() { return lstCelulares.size(); }
    class CelularViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitulo, textViewDescripcion, textViewPrecio;
        ImageView imageView;
        CardView cartita;
        public CelularViewHolder(View itemView) {
            super(itemView);
            textViewTitulo= itemView.findViewById(R.id.txttitulo);
            textViewDescripcion = itemView.findViewById(R.id.txtdescripcion);
            textViewPrecio = itemView.findViewById(R.id.txtprecio);
            imageView = itemView.findViewById(R.id.imgCell);
            cartita = itemView.findViewById(R.id.cartita);
        }
    }

}
