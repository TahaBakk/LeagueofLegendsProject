package com.bakk.taha.leagueoflegends;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Taha on 08/01/2017.
 */

class InvocadorApi {
    //Donarli permisos a internet sino la aplicacion fallara al conectarse a internet(en el manifest)
    //https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536


    static String servidor = "";
    static String summoner = "";
    //static String apiKeyLol = "RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";
    //private final static String BASE_URL = "https://"+servidor+".api.pvp.net/api/lol/"+servidor+"/v1.4/summoner/by-name/"+summoner+"?api_key="+apiKeyLol;
    private final static String BASE_URL = "https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";


    Invocador getSummoner(){

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        try {
            return docall(url);
        } catch (IOException e) {e.printStackTrace();
        } catch (JSONException e) {e.printStackTrace();
        }return null;

    }
    @Nullable
    private Invocador docall(String url) throws IOException, JSONException {

            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);

    }
    //desactivado
    //para pasar el json a strings y guardarlas en variable
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
