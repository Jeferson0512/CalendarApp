package com.tecsup.jeferson.calendarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewEventActivity extends AppCompatActivity {

    private TextView titulo, descripcion, hora, fecha,prueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        titulo=(TextView)findViewById(R.id.titulo);
        descripcion=(TextView)findViewById(R.id.descripcion);
        fecha=(TextView)findViewById(R.id.fecha);
        hora=(TextView)findViewById(R.id.hora);

        Bundle dato = this.getIntent().getExtras();
        String dato_titulo = dato.getString("titulo");
        String dato_descripccion = dato.getString("descripcion");
        String dato_fecha = dato.getString("fecha");
        String dato_hora = dato.getString("hora");

        titulo.setText(dato_titulo);
        descripcion.setText(dato_descripccion);
        fecha.setText(dato_fecha);
        hora.setText(dato_hora);
    }
}
