package com.example.restcardviewapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.restcardviewapi.Adaptador.AdaptadorFotos;

public class MainFotos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fotos);
        Bundle bnd = this.getIntent().getExtras();

        RecyclerView rc = (RecyclerView) findViewById(R.id.recviewfotos);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new GridLayoutManager(this,2));
        AdaptadorFotos adapcell = new AdaptadorFotos(this, bnd.getStringArrayList("imgs"));
        rc.setAdapter(adapcell);
    }
}