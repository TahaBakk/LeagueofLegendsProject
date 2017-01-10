package com.bakk.taha.leagueoflegends;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;


public class MainActivityFragment extends Fragment {

    /*private final static String[] datos = { "EUW", "BR", "EUNE", "JP", "KR", "LAN", "LAS",
            "OCE", "RU", "TR" };*/

    public MainActivityFragment() {
    }

    public EditText et1;
    public Spinner sp1;

    @Override//Aqui le decimos que vamos a añadir items al "MENU"
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        et1 = (EditText) view.findViewById(R.id.editText1);
        sp1 = (Spinner) view.findViewById(R.id.lista1);

        String datoNombre = et1.getText().toString();//con esto capturamos el texto introducido
        String datoServidor = sp1.getItemAtPosition(sp1.getSelectedItemPosition()).toString();//capturamos el servidor seleccionado en el Spinner

        return view;
    }


    @Override//la opciones del menu que ara cuando se le de a un item del menu
    public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();

            if (id == R.id.action_refresh) {
                   refresh();
                   return true;
            }
            return super.onOptionsItemSelected(item);
    }

    @Override//Que menu cargara (le marcamos el xml del menu)
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_lol_fragment, menu);

    }
    //Que ara, al darle al boton de refresh del menu
    private void refresh() {

        RefreshDataTask task = new RefreshDataTask();
        task.execute();

    }
    //hacemos que la api se ejecute en segundo plano
    private class RefreshDataTask extends AsyncTask<Void, Void, Invocador> {
        @Override
        protected Invocador doInBackground(Void... voids) {
            InvocadorApi invocadorapi = new InvocadorApi();
            Invocador result = null;
            try {
                result = invocadorapi.getSummoner();
                Log.d("DEBUG", result.toString());


            } catch (JSONException e) {e.printStackTrace();
            } catch (IOException e) {e.printStackTrace();
            }


            return null;
        }
    }



}

