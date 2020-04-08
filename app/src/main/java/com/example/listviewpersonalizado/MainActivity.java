package com.example.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        Frutas frutas = new Frutas();
        ArrayList<Fruta> listaFrutas = new ArrayList<>();
        for (Fruta f: frutas.FRUTAS){
            listaFrutas.add(f);
        }


        FrutaAdapter adapter = new FrutaAdapter(
                getApplicationContext(),
                R.layout.list_item_frut,
                listaFrutas
                );

        listView.setAdapter(adapter);
    }

}
