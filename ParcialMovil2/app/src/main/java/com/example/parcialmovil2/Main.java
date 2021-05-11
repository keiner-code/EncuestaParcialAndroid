package com.example.parcialmovil2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Main extends AppCompatActivity {

     private Spinner spinner1,spinner2,spinner3,spinner4,spinner5;
    String [] opciones = {" ","1","2","3","4","5"};
    String [] values = {" ","Si","No"};
    String Resultado1,Resultado2,Resultado3,Resultado4,Resultado5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner3);
        spinner3 = findViewById(R.id.spinner4);
        spinner4 = findViewById(R.id.spinner5);
        spinner5 = findViewById(R.id.spinner6);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,values);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter1);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        PoliticaDeDatos();
    }
    private void PoliticaDeDatos(){
        new AlertDialog.Builder(this).setTitle("Politica De Trata De Datos")
                .setMessage("Que el Artículo 15 de la Constitución Política dispone que todas las personas tienen derecho a su intimidad personal y familiar " +
                            "y a su buen nombre, y el Estado debe respetarlos y hacerlos respetar. De igual modo, tienen derecho a conocer, actualizar y rectificar" +
                            " las informaciones que se hayan recogido sobre ellas en bancos de datos y en archivos de entidades públicas y privadas.\n" +
                            "Por tal motivo los datos personales de la población víctima contenidos en las herramientas tecnológicas o en cualquier mecanismo físico o " +
                            "digital, es el principal compromiso de todos los usuarios que accedan a ellos, toda vez que son catalogados como datos sensibles con carácter " +
                            "reservado y confidencial, y su tratamiento está sujeta a la normatividad aplicable.\n" +
                            "\nSe encuentra de acuerdo con el tratamiento de sus datos.\n")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Solo Continua
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //codigo si dice no
                        finish();
                    }
                }).show();
    }
    public void ResultadoEncuesta(View v){
        String valorpregunta1,valorpregunta2,valorpregunta3,valorpregunta4,valorpregunta5;
        valorpregunta1 = spinner1.getSelectedItem().toString();
        valorpregunta2 = spinner2.getSelectedItem().toString();
        valorpregunta3 = spinner3.getSelectedItem().toString();
        valorpregunta4 = spinner4.getSelectedItem().toString();
        valorpregunta5 = spinner5.getSelectedItem().toString();

        //pregunta1 Tuvo algún problema para concertar una cita?
        if (valorpregunta1.equals("1")) Resultado1 = "Nada Satisfecho";
        if (valorpregunta1.equals("2")) Resultado1 = "Poco Satisfecho";
        if (valorpregunta1.equals("3")) Resultado1 = "Neutral";
        if (valorpregunta1.equals("4")) Resultado1 = "Muy Satisfecho";
        if (valorpregunta1.equals("4")) Resultado1 = "Totalmente Satisfecho";
        //Pregunta 2 Cómo calificaría el profesionalismo de nuestro personal?
        if (valorpregunta2.equals("1")) Resultado2 = "Nada Satisfecho";
        if (valorpregunta2.equals("2")) Resultado2 = "Poco Satisfecho";
        if (valorpregunta2.equals("3")) Resultado2 = "Neutral";
        if (valorpregunta2.equals("4")) Resultado2 = "Muy Satisfecho";
        if (valorpregunta2.equals("5")) Resultado2 = "Totalmente Satisfecho";
        //Pregunta 3 Cuenta actualmente con la cobertura de un plan de seguro médico?
        if (valorpregunta3.equals("Si")) Resultado5 = "si";
        if (valorpregunta3.equals("No")) Resultado5 = "no";
        //Pregunta 4 Cómo calificaría el proceso de diagnóstico de la intervención a la que se sometió?
        if (valorpregunta4.equals("1")) Resultado4 = "Nada Satisfecho";
        if (valorpregunta4.equals("2")) Resultado4 = "Poco Satisfecho";
        if (valorpregunta4.equals("3")) Resultado4 = "Neutral";
        if (valorpregunta4.equals("4")) Resultado4 = "Muy Satisfecho";
        if (valorpregunta4.equals("5")) Resultado4 = "Totalmente Satisfecho";
        //pregunta 5 qué probabilidad existe que nos recomiende con un amigo o colega?
        if (valorpregunta5.equals("1")) Resultado3 = "Nada Satisfecho";
        if (valorpregunta5.equals("2")) Resultado3 = "Poco Satisfecho";
        if (valorpregunta5.equals("3")) Resultado3 = "Neutral";
        if (valorpregunta5.equals("4")) Resultado3 = "Muy Satisfecho";
        if (valorpregunta5.equals("5")) Resultado3 = "Totalmente Satisfecho";


        Intent intent = new Intent(Main.this,DatosUsers.class);
        Bundle bundle = new Bundle();
        bundle.putString("Respuesta1",Resultado1);
        bundle.putString("Respuesta2",Resultado2);
        bundle.putString("Respuesta3",Resultado3);
        bundle.putString("Respuesta4",Resultado4);
        bundle.putString("Respuesta5",Resultado5);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();

    }
    public void PaginaParaListarEncuesta(View v){
        Intent intent = new Intent(Main.this,ListarEncuesta.class);
        startActivity(intent);
        finish();
    }
    public void SobreNosotros(View v){
        Intent intent = new Intent(Main.this,SobreNosotros.class);
        startActivity(intent);
        finish();
    }
}