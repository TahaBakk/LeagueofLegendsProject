package com.bakk.taha.leagueoflegends;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MatchListActivityFragment extends Fragment {


    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public MatchListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_match_list, container, false);

        ListView lvHistorial = (ListView) view.findViewById(R.id.lvHistorial);


        items = new ArrayList<>();
        adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.datos_item,
                R.id.tv2,
                items
        );
        lvHistorial.setAdapter(adapter);

        return view;
    }

    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_match_list, menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_refresh){
            refresh();
            return true;
        }/*else if (id == R.id.action_settings) {
            Intent i = new Intent(getContext(), SettingsActivity.class);
            startActivity(i);
        }*/
        return super.onOptionsItemSelected(item);
    }


    private void refresh() {

        RefreshDataTask task = new RefreshDataTask();
        task.execute();

    }

    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<MatchList>> {
        @Override
        protected ArrayList<MatchList> doInBackground(Void... voids) {
            MatchListApi mlApi = new MatchListApi();
            ArrayList<MatchList> result;
            result = mlApi.getMatch();
            Log.d("DEBUG=****>", result != null ? result.toString() : null);

            return result;
        }
        @Override
        protected void onPostExecute(ArrayList<MatchList> cartap) {
            super.onPostExecute(cartap);
            adapter.clear();
            for(int i = 0; i < 20; i++)
            {
                adapter.add(cartap.get(i).getLane());
            }

        }

    }



}
