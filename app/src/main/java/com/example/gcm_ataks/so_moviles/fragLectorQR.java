package com.example.gcm_ataks.so_moviles;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Camacho Magallanes Gustavo
 */
public class fragLectorQR extends Fragment {

    private Button btnScan;
    private TextView txtVwLectorQR;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_lector_qr, container, false);

        btnScan = (Button) view.findViewById(R.id.btnScan);
        txtVwLectorQR = (TextView) view.findViewById(R.id.txtVwLectorQR);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator.initiateScan(getActivity());
            }
        });
        return view;
    }
}
