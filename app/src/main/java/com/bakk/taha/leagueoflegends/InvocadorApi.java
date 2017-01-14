package com.bakk.taha.leagueoflegends;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Taha on 08/01/2017.
 */

class InvocadorApi {
    //Donarli permisos a internet sino la aplicacion fallara al conectarse a internet(en el manifest)
    //https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536


    static String servidor = MainActivityFragment.nombreServidor;
    static String summoner = MainActivityFragment.nombreSummoner ;
    static String apiKeyLol = "RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";
    private final static String BASE_URL = "https://"+servidor+".api.pvp.net/api/lol/"+servidor+"/v1.4/summoner/by-name/"+summoner+"?api_key="+apiKeyLol;
    //private final static String BASE_URL = "https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/Stanjawi?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";


    Invocador getSummoner(){

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();
        System.out.println("BASE_____URL========================"+BASE_URL);
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
    //para pasar el json a strings y guardarlas en variable
    private static Invocador processJson (String jsonResponse) throws JSONException {

        JSONObject data = new JSONObject(jsonResponse);
        //data = data.getJSONObject("STanjawi");//le decimos que de la ruta coja lo que contiene lo que alla dentro de STanjawi(el summoner)

        JSONObject dato = data.getJSONObject(summoner.toLowerCase());
        //JSONObject dato = data.getJSONObject("stanjawi");

        Invocador invocador = new Invocador();

        invocador.setSummonerId(dato.getLong("id"));
        invocador.setSummonerName(dato.getString("name"));
        invocador.setProfileIconId(dato.getInt("profileIconId"));
        invocador.setSummonerLevel(dato.getLong("summonerLevel"));
        invocador.setRevisionDate(dato.getLong("revisionDate"));

    return invocador;
    }








}
