package com.tecsup.jeferson.calendarapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class EventoActivity extends AppCompatActivity implements View.OnClickListener {

    private int dia, mes, año, hora, minutos;
    private TextView txt_hora,txt_fecha;
    private Button btn_buscar_f,btn_buscar_h;
    private EditText edt_titulo,edt_descripcion;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener SelectorFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        btn_buscar_h = (Button)findViewById(R.id.btn_buscar_h);
        btn_buscar_f = (Button)findViewById(R.id.btn_buscar_f);
        //---------------------------------------------------------------
        txt_hora = (TextView)findViewById(R.id.txt_hora);
        txt_fecha =(TextView)findViewById(R.id.txt_fecha);
        edt_titulo=(EditText)findViewById(R.id.edt_titulo);
        edt_descripcion=(EditText)findViewById(R.id.edt_descripcion);

        /*String fecha= txt_fecha.getText().toString();
        String hora = txt_hora.getText().toString();
        String descripcion = edt_titulo.getText().toString();
        String titulo= edt_titulo.getText().toString();*/

        Calendar calendar = Calendar.getInstance();

        año = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        mostrarFecha();

        btn_buscar_h.setOnClickListener(this);

        SelectorFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                año = year;
                mes = month;
                dia = dayOfMonth;

                mostrarFecha();
            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id){
            case 0:
                return new DatePickerDialog(this, SelectorFecha, año, mes ,dia);
        }

        return null;
    }

    public void mostrarCalendar(View view){
        showDialog(TIPO_DIALOGO);
    }
    public void mostrarFecha(){

        txt_fecha.setText(dia+"/"+(mes+1)+"/"+año);
    }

    @Override
    public void onClick(View view) {
        final Calendar calendario = Calendar.getInstance();
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                txt_hora.setText(hourOfDay+":"+minute);
            }
        },hora,minutos,false);
        timePickerDialog.show();
    }

    public void Guardar_evento(View view){
        /*Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("dato1",txt_fecha.getText().toString());
        intent.putExtra("dato2",txt_hora.getText().toString());
        startActivity(intent);*/
        Toast.makeText(this, "Evento Guardado", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ViewEventActivity.class);
        intent.putExtra("titulo",edt_titulo.getText().toString());
        intent.putExtra("descripcion",edt_descripcion.getText().toString());
        intent.putExtra("hora",txt_hora.getText().toString());
        intent.putExtra("fecha",txt_fecha.getText().toString());
        startActivity(intent);
    }

}