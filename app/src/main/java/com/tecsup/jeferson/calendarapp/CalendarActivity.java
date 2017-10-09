package com.tecsup.jeferson.calendarapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    private int dia;
    private int mes;
    private int año;
    private TextView edt_fecha;
    private Button btn_buscar;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener SelectorFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        edt_fecha = (TextView)findViewById(R.id.edt_fecha);
        btn_buscar = (Button)findViewById(R.id.btn_buscar);
        Calendar calendario = Calendar.getInstance();

        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);

        mostrarFecha();

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
                return new DatePickerDialog(this, SelectorFecha, año, mes, dia);
        }
        return null;
    }

    public void mostrarCalender(View view){
        showDialog(TIPO_DIALOGO);
    }

    public void mostrarFecha(){
        edt_fecha.setText(dia+"/"+(mes+1)+"/"+año);
    }
}
