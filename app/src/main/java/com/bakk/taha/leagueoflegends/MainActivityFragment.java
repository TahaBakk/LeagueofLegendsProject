package com.bakk.taha.leagueoflegends;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivityFragment extends Fragment {

    String apiKeyLol = "RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";
    /*private final static String[] datos = { "EUW", "BR", "EUNE", "JP", "KR", "LAN", "LAS",
            "OCE", "RU", "TR" };*/

    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);



        return view;
    }
}


