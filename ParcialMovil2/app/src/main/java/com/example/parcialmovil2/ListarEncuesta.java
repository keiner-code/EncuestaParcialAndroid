package com.example.parcialmovil2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ListarEncuesta extends AppCompatActivity {
      private EditText codigo,nombre,apellido,valoracion,cobertura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_encuesta);
        codigo = findViewById(R.id.editTextTextcodigo);
        nombre = findViewById(R.id.editTextTextnombre);
        apellido = findViewById(R.id.editTextTextapellido2);
        valoracion = findViewById(R.id.editTextTextvaloracion);
        cobertura = findViewById(R.id.editTextTextcobertura);
    }
    public void MostrarDatos(View v){
        int valor;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"EncuestaUsuarios",null,1);
        SQLiteDatabase database = admin.getWritableDatabase();
        String id = codigo.getText().toString();
        Cursor fila = database.rawQuery("select nombre, apellido from datosusuario where id="+id,null);

        if (fila.moveToFirst()){
            Cursor fila1 = database.rawQuery("select respuesta1, respuesta2, respuesta3, respuesta4, respuesta5 from encuesta where id="+id,null);
            nombre.setText(fila.getString(0));
            apellido.setText(fila.getString(1));
            if (fila1.moveToFirst()) {
                cobertura.setText(fila1.getString(4));
                valor = ValoracionPromedio(fila1.getString(0),fila1.getString(1),fila1.getString(2),fila1.getString(3));
                if (valor==1) valoracion.setText("Nada Satisfecho");
                if (valor==2) valoracion.setText("Poco Satisfecho");
                if (valor==3) valoracion.setText("Neutral");
                if (valor==4) valoracion.setText("Muy Satisfecho");
                if (valor==5) valoracion.setText("Totalmente Satisfecho");
            }else{
                Toast.makeText(this,"El Usuario "+id+" No Ha Realizado La Encuesta",Toast.LENGTH_SHORT);
            }
        }else{
            Toast.makeText(this,"El Usuario "+id+" No Esta Registrado",Toast.LENGTH_SHORT);
        }
        database.close();
    }
    public int ValoracionPromedio(String r0,String r1, String r2, String r3){
        int pregunta1=0,pregunta2=0,pregunta3=0,pregunta4=0,suma=0,promedio=0;
        //Log.d("datos obtenidos",r0+" "+r1+" "+r2+" "+r3);

        if (r0.equals("Nada Satisfecho")) pregunta1=1;
        if (r0.equals("Poco Satisfecho")) pregunta1=2;
        if (r0.equals("Neutral")) pregunta1=3;
        if (r0.equals("Muy Satisfecho"))  pregunta1=4;
        if (r0.equals("Totalmente Satisfecho"))  pregunta1=5;

        if (r1.equals("Nada Satisfecho")) pregunta2=1;
        if (r1.equals("Poco Satisfecho")) pregunta2=2;
        if (r1.equals("Neutral")) pregunta2=3;
        if (r1.equals("Muy Satisfecho"))  pregunta2=4;
        if (r1.equals("Totalmente Satisfecho"))  pregunta2=5;

        if (r2.equals("Nada Satisfecho")) pregunta3=1;
        if (r2.equals("Poco Satisfecho")) pregunta3=2;
        if (r2.equals("Neutral")) pregunta3=3;
        if (r2.equals("Muy Satisfecho"))  pregunta3=4;
        if (r2.equals("Totalmente Satisfecho"))  pregunta3=5;

        if (r3.equals("Nada Satisfecho")) pregunta4=1;
        if (r3.equals("Poco Satisfecho")) pregunta4=2;
        if (r3.equals("Neutral")) pregunta4=3;
        if (r3.equals("Muy Satisfecho"))  pregunta4=4;
        if (r3.equals("Totalmente Satisfecho"))  pregunta4=5;

        suma = pregunta1+pregunta2+pregunta3+pregunta4;
        //Log.d("Suma Promedio", String.valueOf(suma));
        promedio= suma/4;
        return promedio;
    }
    public void regresarmain(View v){
        Intent intent = new Intent(ListarEncuesta.this,Main.class);
        startActivity(intent);
        finish();
    }
}