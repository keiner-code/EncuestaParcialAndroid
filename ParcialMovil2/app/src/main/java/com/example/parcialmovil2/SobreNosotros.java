package com.example.parcialmovil2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SobreNosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nosotros);
    }
    public void regresar(View v){
        Intent intent = new Intent(SobreNosotros.this,Main.class);
        startActivity(intent);
        finish();
    }
}