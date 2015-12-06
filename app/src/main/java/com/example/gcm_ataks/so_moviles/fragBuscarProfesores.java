package com.example.gcm_ataks.so_moviles;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by GCM-Ataks on 29/11/2015.
 */
public class fragBuscarProfesores extends Fragment {
    WebView htmlProfesores;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_buscar_profesor, container, false);
        htmlProfesores=(WebView)view.findViewById(R.id.htmlProfesores);

        return view;
    }
}
