package android.coursera.com.tareaactivityintent;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    String nombreCompleto;
    String fechaNacimiento;
    String telefono;
    String email;
    String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle bundle=getIntent().getExtras();
        nombreCompleto=bundle.getString(getResources().getString(R.string.vnombrecompleto));
        fechaNacimiento=bundle.getString(getResources().getString(R.string.vfechaNacimiento));
        telefono=bundle.getString(getResources().getString(R.string.vtelefono));
        email=bundle.getString(getResources().getString(R.string.vemail));
        descripcion=bundle.getString(getResources().getString(R.string.vdescripcion));

        MaterialButton editarconteido=(MaterialButton) findViewById(R.id.btn_editardatos);


        Log.i("nombreCompleto","el nombre completo  "+nombreCompleto);


        TextView tv_nombrecompleto=(TextView)findViewById(R.id.text_nombrecompleto);
        TextView tv_fechaNacimiento=(TextView)findViewById(R.id.text_fechanacimiento);
        TextView tv_telefono=(TextView)findViewById(R.id.text_telefono);
        TextView tv_email=(TextView)findViewById(R.id.text_email);
        TextView tv_descripcion=(TextView)findViewById(R.id.text_descripcion);

        tv_nombrecompleto.setText(nombreCompleto);
        tv_fechaNacimiento.setText(fechaNacimiento);
        tv_telefono.setText(telefono);
        tv_email.setText(email);
        tv_descripcion.setText(descripcion);

        editarconteido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConfirmacionActivity.this,MainActivity.class);

                intent.putExtra(getResources().getString(R.string.vnombrecompleto),nombreCompleto);
                intent.putExtra(getResources().getString(R.string.vfechaNacimiento),fechaNacimiento);
                intent.putExtra(getResources().getString(R.string.vtelefono),telefono);
                intent.putExtra(getResources().getString(R.string.vemail),email);
                intent.putExtra(getResources().getString(R.string.vdescripcion),descripcion);

                startActivity(intent);
                finish();
            }
        });



    }
}
