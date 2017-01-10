package com.bakk.taha.leagueoflegends;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Taha on 08/01/2017.
 */

public class InvocadorApi {

    //https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536


    String servidor = "";
    String summoner = "";
    String apiKeyLol = "RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";

    private final static String BASE_URL = "//https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";


    String getSummoner() throws JSONException, IOException {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return docall(url);

    }

    private String docall(String url) throws IOException {

            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;

    }

    private static Invocador processJson (String jsonResponse) throws JSONException {

        JSONObject data = null;
        data = new JSONObject(jsonResponse);

        Invocador invocador = new Invocador();

        invocador.setId(data.getLong("id"));
        invocador.setName(data.getString("name"));
        invocador.setProfileIconId(data.getInt("profileIconId"));
        invocador.setSummonerLevel(data.getLong("summonerLevel"));
        invocador.setRevisionDate(data.getLong("revisionDate"));

    return invocador;
    }







}
