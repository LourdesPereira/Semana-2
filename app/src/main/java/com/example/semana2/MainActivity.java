package com.example.semana2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private View btn;
    private EditText datapicker;
    private EditText pfecha;
    public EditText pname;
    public EditText pTelefono;
    public EditText pMAil;
    public EditText pComent;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnEnviar);
        datapicker  = (EditText) findViewById(R.id.editFecha);
        pname=(EditText) findViewById(R.id.editName);
        pfecha=(EditText) findViewById(R.id.editFecha);
        pTelefono=(EditText) findViewById(R.id.editTelefono);
        pMAil=(EditText) findViewById(R.id.editMail);
        pComent=(EditText) findViewById(R.id.editComentario);


        btn.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {


                Intent intent =  new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("nombre",pname.getText().toString());
                intent.putExtra("fecha",pfecha.getText().toString());
                intent.putExtra("telefono",pTelefono.getText().toString());
                intent.putExtra("mail",pMAil.getText().toString());
                intent.putExtra("comentario",pComent.getText().toString());

                startActivity(intent); //abro la url en una nueva activity

            }
        });

        datapicker.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onFocusChange(View arg0, boolean hasfocus) {
                if (hasfocus) {
                    showDatePickerDialog();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        pname.setText(getIntent().getStringExtra("nombre"));
        datapicker.setText(getIntent().getStringExtra("fecha"));
        pTelefono.setText(getIntent().getStringExtra("telefono"));
        pMAil.setText(getIntent().getStringExtra("mail"));
        pComent.setText(getIntent().getStringExtra("comentario"));
    }

        @RequiresApi(api = Build.VERSION_CODES.N)
        private void showDatePickerDialog(){
            DatePickerDialog datePickerDialog=new DatePickerDialog(
                    this,
                    this,
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        };

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int daymonth) {
        String data=daymonth + "/" + month + "/" + year;
         datapicker.setText(data.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("strName",pname.getText().toString());
        outState.putString("strFecha",pfecha.getText().toString());
        outState.putString("strMail",pMAil.getText().toString());
        outState.putString("strtelefono",pTelefono.getText().toString());
        outState.putString("strComentario",pComent.getText().toString());
    }
    protected void onRestoreInstanceState (Bundle savedInstanceState){
    //super.onRestoreInstanceState(savedInstanceState);
        pname.setText(String.valueOf(savedInstanceState.getString("strName")));
        pfecha.setText(String.valueOf(savedInstanceState.getString("strFecha")));
        pMAil.setText(String.valueOf(savedInstanceState.getString("strMail")));
        pTelefono.setText(String.valueOf(savedInstanceState.getString("strtelefono")));
        pComent.setText(String.valueOf(savedInstanceState.getString("strComentario")));

}

}