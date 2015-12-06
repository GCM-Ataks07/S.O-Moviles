package com.example.gcm_ataks.so_moviles;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class Principal extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    Handler miHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(getApplicationContext(), "Cambio de clase", Toast.LENGTH_SHORT).show();
        }
    };


    TextView txtVwLectorQR;
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("Mensaje", "Dentro del ");
        txtVwLectorQR = (TextView)findViewById(R.id.txtVwLectorQR);
        final IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        getFragmentManager().beginTransaction().replace(R.id.layFragment, fragLectorQR).commit();
        txtVwLectorQR.post(new Runnable() {
            @Override
            public void run() {
                txtVwLectorQR.setText(intentResult.getContents()+"");
            }
        });
    }


/**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    Fragment fragClases,fragLectorQR,fragProf,fragEdificio,fragConfiguracion,fragHorario;
    Runnable miRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Message miMensaje;
                while (true) {
                    Calendar c = Calendar.getInstance();
                    int Hr = c.get(Calendar.HOUR);
                    int Mn = c.get(Calendar.MINUTE);
                    int Seg = c.get(Calendar.SECOND);
                    Log.e("Tiempo: ", Hr + " " + Mn + " " + Seg);
                    if (Mn==50){
                        Log.e("Cambio de Clase: ", Hr + " " + Mn + " " + Seg);
                        //solicitar un msj
                        miMensaje = miHandler.obtainMessage(1000);
                        //enviamos de vuelta el msj
                        miHandler.sendMessage(miMensaje);
                        Thread.sleep(60000);
                    } else if (Seg==0)
                        Thread.sleep(60000);
                    else
                        Thread.sleep(1000);
                }
            }catch (Exception e){

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        fragClases = new fragClases();
        fragLectorQR = new fragLectorQR();
        fragHorario = new fragHorario();
        fragProf = new fragBuscarProfesores();
        fragEdificio = new fragBuscarEdificio();

        Thread hilo = new Thread(miRunnable);
        hilo.start();

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                getFragmentManager().beginTransaction().replace(R.id.layFragment,fragClases).commit();
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                getFragmentManager().beginTransaction().replace(R.id.layFragment,fragLectorQR).commit();
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                getFragmentManager().beginTransaction().replace(R.id.layFragment,fragHorario).commit();
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                getFragmentManager().beginTransaction().replace(R.id.layFragment,fragProf).commit();
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                getFragmentManager().beginTransaction().replace(R.id.layFragment,fragEdificio).commit();
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Aplicacion cerrada",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_principal, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((Principal) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
