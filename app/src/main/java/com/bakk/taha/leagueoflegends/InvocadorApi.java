package com.bakk.taha.leagueoflegends;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Taha on 08/01/2017.
 */

public class InvocadorApi {
    //Donarli permisos a internet sino la aplicacion fallara al conectarse a internet(en el manifest)
    //https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536


//Esto lo usare mas adelante para filtrar por el nombre de invocador
    public static String servidor = "";
    public static String summoner = "";
    //String apiKeyLol = "RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";

    private final static String BASE_URL = "https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";


    Invocador getSummoner() throws JSONException, IOException {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return docall(url);

    }

    private Invocador docall(String url) throws IOException, JSONException {

            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);

    }

    private static Invocador processJson (String jsonResponse) throws JSONException {

        JSONObject data = new JSONObject(jsonResponse);

        Invocador invocador = new Invocador();

        invocador.setId(data.getLong("id"));
        invocador.setName(data.getString("name"));
        invocador.setProfileIconId(data.getInt("profileIconId"));
        invocador.setSummonerLevel(data.getLong("summonerLevel"));
        invocador.setRevisionDate(data.getLong("revisionDate"));

    return invocador;
    }








}
