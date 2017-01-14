package com.bakk.taha.leagueoflegends;

import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by x3727349s on 13/01/17.
 */

public class MatchListApi {
    //static Invocador invocador = new Invocador();
    //public static Long champCodiId = invocador.getSummonerId();
    //static String servidor = MainActivityFragment.nombreServidor;

    //private final static String BASE_URL = "https://"+servidor+".api.pvp.net/api/lol/"+servidor+"/v2.2/matchlist/by-summoner/"+champCodiId+"?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";
    private final static String BASE_URL = "https://euw.api.pvp.net/api/lol/euw/v2.2/matchlist/by-summoner/50809995?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";

    private static final int PAGES = 10;

    ArrayList<MatchList> getHistorial() {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        System.out.println("Taha URLLLLLLLLLL"+BASE_URL);

        String url = builtUri.toString();
        return doCall(url);

    }

    private static ArrayList<MatchList> doCall(String url) {
        String JsonResponse = null;
        ArrayList<MatchList> matchList = new ArrayList<>();

        for (int i = 0; i < PAGES; i++) {
            try {
                JsonResponse = HttpUtils.get(url);

                ArrayList<MatchList> list = processJson(JsonResponse);
                matchList.addAll(list);

                return matchList;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;

    }

    private static ArrayList<MatchList> processJson(String jsonResponse) {
        ArrayList<MatchList> matchLists = new ArrayList<>();

        try {
            JSONObject data = null;
            data = new JSONObject(jsonResponse);

            JSONArray jsonMatchList = data.getJSONArray("matches");

            for (int i = 0; i < jsonMatchList.length(); i++) {

                JSONObject dato = jsonMatchList.getJSONObject(i);

                MatchList matchList = new MatchList();

                matchList.setChampion(dato.getLong("champion"));
                matchList.setLane(dato.getString("lane"));
                matchList.setMatchId(dato.getLong("matchId"));
                matchList.setPlatformId(dato.getString("platformId"));
                matchList.setQueue(dato.getString("queue"));
                matchList.setRegion(dato.getString("region"));
                matchList.setRole(dato.getString("role"));
                matchList.setSeason(dato.getString("season"));
                matchList.setTimestamp(dato.getLong("timestamp"));

                matchLists.add(matchList);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return matchLists;
    }

}