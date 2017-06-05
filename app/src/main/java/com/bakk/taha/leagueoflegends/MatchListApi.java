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

    //String champCodiId = "50809995";
    static Invocador inv = new Invocador();
    private final static String champID = String.valueOf(inv.getSummonerId());
    private final static String BASE_URL = "https://euw.api.pvp.net/api/lol/euw/v2.2/matchlist/by-summoner/" + champID + "?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";//50809995


    static ArrayList<MatchList> getMatch() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();

        String url = builtUri.toString();
        return doCall(url);

    }

    private static ArrayList<MatchList> doCall(String url) {
        String JsonResponse = null;
        ArrayList<MatchList> matchList = new ArrayList<>();

        try {
            JsonResponse = HttpUtils.get(url);

            ArrayList<MatchList> list = processJson(JsonResponse);
            matchList.addAll(list);

            return matchList;

        } catch (IOException e) {
            e.printStackTrace();
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
                System.out.println("FUCKKKK" + matchList.getMatchId());
                matchLists.add(matchList);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return matchLists;
    }



    static void getmatchData()  {
        String idMatch =  String.valueOf("3204691748");
        //String API_MATCH_URL = "https://euw.api.pvp.net/api/lol/euw/v2.2/match/" +idMatch + "?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";
        String API_MATCH_URL = "https://euw.api.pvp.net/api/lol/euw/v2.2/match/3204691748?api_key=RGAPI-4f73293a-8462-446f-b61b-38f15c0ec536";

        Uri builtUri = Uri.parse(API_MATCH_URL)
                .buildUpon()
                .build();
        String urlMatch = builtUri.toString();

        try {

            String JsonResponse2 = HttpUtils.get(urlMatch);
            processJson(JsonResponse2);

            JSONObject data2 = new JSONObject(JsonResponse2);


            Match match = new Match();
            //matchMode,matchDuration, queueType, mapId,season,matchVersion,
            //"participants"--"stats"--,"winner","champLevel","kills","doubleKills","tripleKills", "quadraKills","pentaKills","deaths","assists", "goldEarned"
            match.setMatchMode(data2.getString("matchMode"));
            match.setMatchDuration(data2.getLong("matchDuration"));
            match.setQueueType(data2.getString("queueType"));
            match.setSeason(data2.getString("season"));
            match.setMatchVersion(data2.getString("matchVersion"));

            System.out.println("DATAAAAAAAA" +  match.getMatchMode());
            System.out.println("DATAAAAAAAA2" + match.getMatchDuration());
            System.out.println("DATAAAAAAAA3" + match.getQueueType());


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}