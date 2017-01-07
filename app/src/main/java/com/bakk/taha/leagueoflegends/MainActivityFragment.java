package com.bakk.taha.leagueoflegends;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivityFragment extends Fragment {

    String apiKeyLol = "RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";
    /*private final static String[] datos = { "EUW", "BR", "EUNE", "JP", "KR", "LAN", "LAS",
            "OCE", "RU", "TR" };*/

    public MainActivityFragment() {
    }

    private EditText et1;
    private Spinner sp1;

    private ImageButton masVida1;
    private TextView textView1;

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
}


