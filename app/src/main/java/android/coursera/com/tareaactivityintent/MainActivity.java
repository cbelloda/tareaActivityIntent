package android.coursera.com.tareaactivityintent;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextInputEditText fechaNacimiento;
    TextInputEditText nombreCompleto;
    TextInputEditText telefono;
    TextInputEditText email;
    TextInputEditText descripcion;
    MaterialButton confirmar;

    Calendar calendarioFechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fechaNacimiento = (TextInputEditText) findViewById(R.id.editTextFechaNacimiento);
        nombreCompleto = (TextInputEditText) findViewById(R.id.editTextNombreCompleto);
        telefono = (TextInputEditText) findViewById(R.id.editTextTelefono);
        email = (TextInputEditText) findViewById(R.id.editTextEmail);
        descripcion = (TextInputEditText) findViewById(R.id.editTextDescripcion);
        confirmar = (MaterialButton) findViewById(R.id.btn_siguiente);


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            String bnombreCompleto = bundle.getString(getResources().getString(R.string.vnombrecompleto));
            String bfechaNacimiento = bundle.getString(getResources().getString(R.string.vfechaNacimiento));
            String btelefono = bundle.getString(getResources().getString(R.string.vtelefono));
            String bemail = bundle.getString(getResources().getString(R.string.vemail));
            String bdescripcion = bundle.getString(getResources().getString(R.string.vdescripcion));

            fechaNacimiento.setText(bfechaNacimiento);
            nombreCompleto.setText(bnombreCompleto);
            telefono.setText(btelefono);
            email.setText(bemail);
            descripcion.setText(bdescripcion);
        }
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("botonSiguiente", "Hizo click en siguiente iniciamos intent");
                Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);

                Log.i("nombreCompleto",nombreCompleto.getText().toString());

                intent.putExtra(getResources().getString(R.string.vnombrecompleto), nombreCompleto.getText().toString());
                intent.putExtra(getResources().getString(R.string.vfechaNacimiento), fechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.vtelefono), telefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.vemail), email.getText().toString());
                intent.putExtra(getResources().getString(R.string.vdescripcion), descripcion.getText().toString());
                startActivity(intent);

                finish();
            }
        });

        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("fecha", "Ingresando a la fecha");
                String fecha = fechaNacimiento.getText().toString();
                calendarioFechaNacimiento = Calendar.getInstance();
                if (!fecha.equals("")) {
                    DateFormat fomratoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date = fomratoFecha.parse(fecha);
                        calendarioFechaNacimiento.setTime(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        Log.e("formatoFecha", "Ocurrió un error con el formato de la fecha " + e);
                    }

                }
                showDatePickerDialog();
            }
        });


    }

    public void showDatePickerDialog() {
        DatePickerFragment DatePickerFragment = android.coursera.com.tareaactivityintent.DatePickerFragment.newInstance(calendarioFechaNacimiento, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dia = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
                String mes = (month + 1) < 10 ? "0" + (month + 1) : "" + (month + 1);
                String anno = year < 10 ? "0" + year : "" + year;
                String fecha = dia + "/" + mes + "/" + anno;
                fechaNacimiento.setText(fecha);
                telefono.requestFocus();
            }
        });

        DatePickerFragment.show(getSupportFragmentManager(), "datepicker");
    }
}
