package android.coursera.com.tareaactivityintent;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;

import static android.app.AlertDialog.THEME_HOLO_LIGHT;

public class DatePickerFragment extends DialogFragment

{
    private DatePickerDialog.OnDateSetListener listener;
    Calendar fecha;

    public static DatePickerFragment newInstance(Calendar fecha,DatePickerDialog.OnDateSetListener listener) {

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setListener(listener);
        fragment.setFecha(fecha);
        return fragment;
    }

    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    public void setFecha(Calendar fecha){
        this.fecha=fecha;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {



        return new DatePickerDialog(getActivity(), THEME_HOLO_LIGHT, listener, fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DAY_OF_MONTH));
    }


}
