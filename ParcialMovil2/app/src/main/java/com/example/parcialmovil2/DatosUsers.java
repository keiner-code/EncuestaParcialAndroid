package com.example.parcialmovil2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DatosUsers extends AppCompatActivity {
     private EditText Nombre,Apellido,Teléfono,Dirección,estadocivil,profesión,estrato,Cargo, nivelfestudio,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_users);
         Nombre= findViewById(R.id.editTextTextNombre);
         Apellido = findViewById(R.id.editTextTextapellido);
         Teléfono = findViewById(R.id.editTextTelefono);
         Dirección = findViewById(R.id.editTextTextDirrecion);
         estadocivil = findViewById(R.id.editTextTextEstadocivil);
         profesión = findViewById(R.id.editTextTextprofesion);
         estrato = findViewById(R.id.editTextTextestrato);
         Cargo = findViewById(R.id.editTextTextcargo);
         nivelfestudio = findViewById(R.id.editTextTextnivelestudio);
         id = findViewById(R.id.editTextTextid);
    }
    public void InsertarDatos(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"EncuestaUsuarios",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();

        //id int primary key, respuesta1 text, respuesta2 text, respuesta3 text, respuesta4 text, respuesta5 text
        Bundle bundle = this.getIntent().getExtras();
        ContentValues datos = new ContentValues();
        datos.put("respuesta1",bundle.getString("Respuesta1"));
        datos.put("respuesta2",bundle.getString("Respuesta2"));
        datos.put("respuesta3",bundle.getString("Respuesta3"));
        datos.put("respuesta4",bundle.getString("Respuesta4"));
        datos.put("respuesta5",bundle.getString("Respuesta5"));
        datos.put("id",id.getText().toString());
        database.insert("encuesta",null,datos);


        ContentValues registro = new ContentValues();
        registro.put("nombre",Nombre.getText().toString());
        registro.put("apellido",Apellido.getText().toString());
        registro.put("telefono",Teléfono.getText().toString());
        registro.put("direccion",Dirección.getText().toString());
        registro.put("estadocivil",estadocivil.getText().toString());
        registro.put("profesion",profesión.getText().toString());
        registro.put("estrato",estrato.getText().toString());
        registro.put("cargo",Cargo.getText().toString());
        registro.put("nivelestudio",nivelfestudio.getText().toString());
        registro.put("id",id.getText().toString());
        database.insert("datosusuario",null,registro);
        database.close();

        Toast.makeText(this,"Encuesta Agregada Con Exitos",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DatosUsers.this,Main.class);
        startActivity(intent);
        finish();

    }
}