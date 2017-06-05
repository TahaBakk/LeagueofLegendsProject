package com.bakk.taha.leagueoflegends;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by taha on 05/06/2017.
 */

public class MatchAdapter/* extends ArrayAdapter<MatchList>*/ {

    /*public MatchAdapter(Context context, int resource, List<MatchList> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtenim l'objecte en la possició corresponent
        MatchList matchList = getItem(position);
        Log.w("XXXX", matchList.toString());

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.datos_item, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView lane = (TextView) convertView.findViewById(R.id.tv2);
        //TextView tvRarity = (TextView) convertView.findViewById(R.id.tvRarity);
        //ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        //tvName.setText(matchList.getName());
        //tvRarity.setText(" -----" + matchList.getRarity() + "-----");
        lane.setText(matchList.getLane());
        //Glide.with(getContext()).load(matchList.getImageUrl()).into(ivPosterImage);

        // Retornem la View replena per a mostrarla
        return convertView;
    }*/


}
