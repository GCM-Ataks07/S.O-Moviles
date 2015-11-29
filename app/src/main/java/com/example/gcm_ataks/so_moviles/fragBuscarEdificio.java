package com.example.gcm_ataks.so_moviles;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Camacho Magallanes Gustavo
 */
public class fragBuscarEdificio extends Fragment {

    private Spinner spnrEdEnc, spnredVas;
    private Button btnRuta;
    private LinearLayout layMapa;
    private int pAEdiUno =0, pBEdiUno =0, pCEdiUno =0, pDEdiUno =0,
                pAEdiDos =0, pBEdiDos =0, pCEdiDos =0, pDEdiDos =0,
                vas=0,enc=0,ban=1;
    private Rect edUno, edDos;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_buscar_edificio, container, false);

        spnrEdEnc = (Spinner)view.findViewById(R.id.spnrEdEnc);
        spnredVas = (Spinner)view.findViewById(R.id.spnrEdVas);
        btnRuta = (Button)view.findViewById(R.id.btnRuta);
        layMapa = (LinearLayout)view.findViewById(R.id.layMapa);

        btnRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spnrEdEnc.getSelectedItem() != spnredVas.getSelectedItem()) {
                    enc = spnrEdEnc.getSelectedItemPosition();
                    vas = spnredVas.getSelectedItemPosition();
                    encontrarEdificio(enc);
                    encontrarEdificio(vas);
                    layMapa.addView(new dwMap(getActivity()),0);
                    Log.e("Edificio", spnrEdEnc.getSelectedItem() + "");
                    Log.e("Edificio", spnredVas.getSelectedItem()+"");
                } else
                    Toast.makeText(getActivity(), "El destino y la Ubicación son las mismas", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private class dwMap extends View{
    Paint paint = new Paint();
        public dwMap(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            edUno = new Rect (pAEdiUno, pBEdiUno, pCEdiUno, pDEdiUno);
            edDos = new Rect (pAEdiDos, pBEdiDos, pCEdiDos, pDEdiDos);
            paint.setColor(Color.RED);
            canvas.drawRect(edUno, paint);
            paint.setColor(Color.BLUE);
            canvas.drawRect(edDos, paint);
            Log.e("Valores Edificio1:", pAEdiUno + " " + pBEdiUno + " " + pCEdiUno + " " + pDEdiUno);
            Log.e("Valores Edificio2:", pAEdiUno + " " + pBEdiUno + " " + pCEdiUno + " " + pDEdiUno);
            ban=1;
        }
    }

    public void encontrarEdificio(int edi) {
        Log.e("Tamaño",layMapa.getHeight()+" "+layMapa.getWidth() + "BANDERA " +ban);
        //distancia lado derecho,distancia superior,ancho,alura
        switch (edi) {
            case 0://homero
                if (ban==1) {
                    pAEdiUno = 18;
                    pBEdiUno = 0;
                    pCEdiUno = 179;
                    pDEdiUno = 19;
                }else {
                    pAEdiDos = 18;
                    pBEdiDos = 0;
                    pCEdiDos = 179;
                    pDEdiDos = 19;
                }
                break;
            case 1://industrias
                if (ban==1) {
                    pAEdiUno = 519;
                    pBEdiUno = 335;
                    pCEdiUno = 555;
                    pDEdiUno = 538;
                }else {
                    pAEdiDos = 519;
                    pBEdiDos = 335;
                    pCEdiDos = 555;
                    pDEdiDos = 538;
                }
                break;
            case 2://a
                if (ban==1) {
                    pAEdiUno = 391;
                    pBEdiUno = 503;
                    pCEdiUno = 423;
                    pDEdiUno = 523;
                }else {
                    pAEdiDos = 391;
                    pBEdiDos = 503;
                    pCEdiDos = 423;
                    pDEdiDos = 523;
                }
                break;
            case 3://b
                if (ban==1) {
                    pAEdiUno = 413;
                    pBEdiUno = 360;
                    pCEdiUno = 449;
                    pDEdiUno = 382;
                }else {
                    pAEdiDos = 413;
                    pBEdiDos = 360;
                    pCEdiDos = 449;
                    pDEdiDos = 382;
                }
                break;
            case 4://c
                if (ban==1) {
                    pAEdiUno = 356;
                    pBEdiUno = 446;
                    pCEdiUno = 384;
                    pDEdiUno = 469;
                }else {
                    pAEdiDos = 356;
                    pBEdiDos = 446;
                    pCEdiDos = 384;
                    pDEdiDos = 469;
                }
                break;
            case 5://d
                if (ban==1) {
                    pAEdiUno = 331;
                    pBEdiUno = 412;
                    pCEdiUno = 359;
                    pDEdiUno = 434;
                }else {
                    pAEdiDos = 331;
                    pBEdiDos = 412;
                    pCEdiDos = 359;
                    pDEdiDos = 434;
                }
                break;
            case 6://e
                if (ban==1) {
                    pAEdiUno = 357;
                    pBEdiUno = 342;
                    pCEdiUno = 390;
                    pDEdiUno = 372;
                }else {
                    pAEdiDos = 357;
                    pBEdiDos = 342;
                    pCEdiDos = 390;
                    pDEdiDos = 372;
                }
                break;
            case 7://f
                if (ban==1) {
                    pAEdiUno = 319;
                    pBEdiUno = 375;
                    pCEdiUno = 350;
                    pDEdiUno = 399;
                }else {
                    pAEdiDos = 319;
                    pBEdiDos = 375;
                    pCEdiDos = 350;
                    pDEdiDos = 399;
                }
                break;
            case 8://g
                if (ban==1) {
                    pAEdiUno = 421;
                    pBEdiUno = 438;
                    pCEdiUno = 452;
                    pDEdiUno = 463;
                }else {
                    pAEdiDos = 421;
                    pBEdiDos = 438;
                    pCEdiDos = 452;
                    pDEdiDos = 463;
                }
                break;
            case 9://m
                if (ban==1) {
                    pAEdiUno = 32;
                    pBEdiUno = 83;
                    pCEdiUno = 74;
                    pDEdiUno = 104;
                }else {
                    pAEdiDos = 32;
                    pBEdiDos = 83;
                    pCEdiDos = 74;
                    pDEdiDos = 104;
                }
                break;
            case 10://o
                if (ban==1) {
                    pAEdiUno = 37;
                    pBEdiUno = 137;
                    pCEdiUno = 79;
                    pDEdiUno = 149;
                }else {
                    pAEdiDos = 37;
                    pBEdiDos = 137;
                    pCEdiDos = 79;
                    pDEdiDos = 149;
                }
                break;
            case 11://P
                if (ban==1) {
                    pAEdiUno = 290;
                    pBEdiUno = 431;
                    pCEdiUno = 316;
                    pDEdiUno = 457;
                }else {
                    pAEdiDos = 290;
                    pBEdiDos = 431;
                    pCEdiDos = 316;
                    pDEdiDos = 457;
                }
                break;
            case 12://R
                if (ban==1) {
                    pAEdiUno = 139;
                    pBEdiUno = 251;
                    pCEdiUno = 157;
                    pDEdiUno = 278;
                }else {
                    pAEdiDos = 139;
                    pBEdiDos = 251;
                    pCEdiDos = 157;
                    pDEdiDos = 278;
                }
                break;
            case 13://S
                if (ban==1) {
                    pAEdiUno = 265;
                    pBEdiUno = 328;
                    pCEdiUno = 295;
                    pDEdiUno = 355;
                }else {
                    pAEdiDos = 265;
                    pBEdiDos = 328;
                    pCEdiDos = 295;
                    pDEdiDos = 355;
                }
                break;
            case 14://cafe
                if (ban==1) {
                    pAEdiUno = 417;
                    pBEdiUno = 308;
                    pCEdiUno = 434;
                    pDEdiUno = 327;
                }else {
                    pAEdiDos = 417;
                    pBEdiDos = 308;
                    pCEdiDos = 434;
                    pDEdiDos = 327;
                }
                break;
            case 15://biblioteca
                if (ban==1) {
                    pAEdiUno = 271;
                    pBEdiUno = 378;
                    pCEdiUno = 298;
                    pDEdiUno = 415;
                }else {
                    pAEdiDos = 271;
                    pBEdiDos = 368;
                    pCEdiDos = 298;
                    pDEdiDos = 415;
                }
                break;
            case 16://la metodos
                if (ban==1) {
                    pAEdiUno = 320;
                    pBEdiUno = 340;
                    pCEdiUno = 344;
                    pDEdiUno = 352;
                }else {
                    pAEdiDos = 320;
                    pBEdiDos = 340;
                    pCEdiDos = 344;
                    pDEdiDos = 352;
                }
                break;
        }
            ban++;
            Log.e("Punto", pAEdiUno +" "+ pBEdiUno +" "+ pCEdiUno + " "+ pDEdiUno);
    }
}
