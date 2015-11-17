package com.example.gcm_ataks.so_moviles;

import android.util.Log;

import java.util.Calendar;

/**
 * Created by GCM-Ataks on 14/11/2015.
 */
public class compHora implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                Calendar c = Calendar.getInstance();
                int Hr = c.get(Calendar.HOUR);
                int Mn = c.get(Calendar.MINUTE);
                int Seg = c.get(Calendar.SECOND);
                Log.e("Tiempo: ", Hr + " " + Mn + " " +Seg);
                if (Mn==50){
                    Log.e("Cambio de Clase: ",Hr + " "+ Mn+" "+Seg);
                    Thread.sleep(60000);
                } else if (Seg==0)
                    Thread.sleep(60000);
                else
                    Thread.sleep(1000);
            }
        }catch (Exception e){

        }
    }}
