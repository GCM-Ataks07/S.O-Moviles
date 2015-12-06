package com.example.gcm_ataks.so_moviles;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.SharedPreferencesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by GCM-Ataks on 29/11/2015.
 */
public class fragHorario extends Fragment{
    Button btnEditarHorario;
    Fragment fragHorarioEditar;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_horario, container, false);
        fragHorarioEditar = new fragHorarioEditar();
        btnEditarHorario = (Button)view.findViewById(R.id.btnEditarHorario);
        btnEditarHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Llama a fragHorarioEditar",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
