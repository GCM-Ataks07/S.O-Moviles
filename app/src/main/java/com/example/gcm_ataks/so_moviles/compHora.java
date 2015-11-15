package com.example.gcm_ataks.so_moviles;

import android.preference.PreferenceActivity;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by GCM-Ataks on 14/11/2015.
 */
public class compHora extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            Calendar c = Calendar.getInstance();
            int Hr = c.get(Calendar.HOUR);
            int Mn = c.get(Calendar.MINUTE);
            Log.e("Tiempo: ", Hr+ " " + Mn);
            Thread.sleep(1000);
        }catch (Exception e){

        }

    }
}
