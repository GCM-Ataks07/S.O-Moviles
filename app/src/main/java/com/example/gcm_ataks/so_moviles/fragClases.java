package com.example.gcm_ataks.so_moviles;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by GCM-Ataks on 14/11/2015.
 */
public class fragClases extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_clases, container, false);
        TextView a = (TextView)view.findViewById(R.id.txtReloj);
        Calendar c = Calendar.getInstance();
        int Hr = c.get(Calendar.HOUR);
        int Mn = c.get(Calendar.MINUTE);
        //Log.e("Mi Thread", "El Valor es: "+Hr+" "+Mn);
        a.setText(Hr+" "+Mn);


        return view;
    }
}
