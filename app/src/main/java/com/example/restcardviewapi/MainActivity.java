package com.example.restcardviewapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.restcardviewapi.Adaptador.AdaptadorCelular;
import com.example.restcardviewapi.Modelos.Celular;
import com.example.restcardviewapi.WebService.Asynchtask;
import com.example.restcardviewapi.WebService.WebService;


public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        review = (RecyclerView) findViewById(R.id.recview);
        review.setHasFixedSize(true);
        review.setLayoutManager(new LinearLayoutManager(this));
        review.setItemAnimator(new DefaultItemAnimator());
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://dummyjson.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Celular> lstCell = new ArrayList<Celular> ();
        try {
            JSONObject JSONlista = new JSONObject(result);
            JSONArray JSONlistaCelulares= JSONlista.getJSONArray("products");
            lstCell = Celular.JsonObjectsBuild(JSONlistaCelulares);
            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                    resId);
            review.setLayoutAnimation(animation);
            AdaptadorCelular adapcell = new AdaptadorCelular(this, lstCell);
            review.setAdapter(adapcell);
        }
        catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG);
        }
    }
}