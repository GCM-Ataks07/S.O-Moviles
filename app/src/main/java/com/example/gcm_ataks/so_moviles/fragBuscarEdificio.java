package com.example.gcm_ataks.so_moviles;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Camacho Magallanes Gustavo
 */
public class fragBuscarEdificio extends Fragment {

    private Spinner spnrEdEnc, spnredVas;
    private Button btnRuta;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_buscar_edificio, container, false);

        spnrEdEnc = (Spinner)view.findViewById(R.id.spnrEdEnc);
        spnredVas = (Spinner)view.findViewById(R.id.spnrEdVas);
        btnRuta = (Button)view.findViewById(R.id.btnRuta);
        btnRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spnrEdEnc.getSelectedItem()!=spnredVas.getSelectedItem()){
                    int enc = spnrEdEnc.getSelectedItemPosition();
                    int vas = spnredVas.getSelectedItemPosition();
                    encontrarEdificio(enc);
                    encontrarEdificio(vas);


                }else
                    Log.e("Falla","Iguales");
            }
        });
        return view;
    }
    public void encontrarEdificio(int edi){
        switch (edi){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
        }
    }
}
