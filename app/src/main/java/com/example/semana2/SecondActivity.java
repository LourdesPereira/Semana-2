package com.example.semana2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {
    private View btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn = (Button) findViewById(R.id.btnEditarDatos);


        final ArrayList<String> dats = new ArrayList<String>();

        dats.add(getIntent().getStringExtra("nombre"));
        dats.add(getIntent().getStringExtra("fecha"));
        dats.add(getIntent().getStringExtra("telefono"));
        dats.add(getIntent().getStringExtra("mail"));
        dats.add(getIntent().getStringExtra("comentario"));

        ArrayAdapter resultadoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dats);


        ListView addResultado = (ListView) findViewById(R.id.listView);

        addResultado.setAdapter(resultadoAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @RequiresApi(api = Build.VERSION_CODES.N)
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                                       intent.putExtra("nombre", dats.get(0));
                                       intent.putExtra("fecha", dats.get(1));
                                       intent.putExtra("telefono", dats.get(2));
                                       intent.putExtra("mail", dats.get(3));
                                       intent.putExtra("comentario", dats.get(4));

                                       startActivity(intent); //abro la url en una nueva activity
                                   }
                               }
        );
    }
}

