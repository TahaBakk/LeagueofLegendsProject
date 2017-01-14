package com.bakk.taha.leagueoflegends;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Taha on 14/01/2017.
 */

public class MatchListAdapter extends ArrayAdapter<MatchList> {


    public MatchListAdapter(Context context, int resource , List<MatchList> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Obtenim l'objecte en la possició corresponent
        MatchList matchList = getItem(position);
        Log.w("AdapterPOS======>", matchList.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.match_list_row, parent, false);

            TextView match = (TextView) convertView.findViewById(R.id.rowMatchList);
            TextView queue = (TextView) convertView.findViewById(R.id.queuMatch);
            TextView lane = (TextView) convertView.findViewById(R.id.posicion);

            // Fiquem les dades dels objectes (provinents del JSON) en el layout
            queue.setText(matchList.getQueue());
            lane.setText(matchList.getLane());

            // Retornem la View replena per a mostrarla
            return convertView;

            }
        return null;
    }
}
