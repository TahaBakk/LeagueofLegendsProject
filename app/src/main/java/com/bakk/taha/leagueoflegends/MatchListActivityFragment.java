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
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MatchListActivityFragment extends Fragment {

    //private ArrayList<MatchList> items;

    private ArrayList<MatchList> items;
    private MatchListAdapter adapter;



    public MatchListActivityFragment() {
    }


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_list, container, false);

        ListView lvHistorial = (ListView) view.findViewById(R.id.lvHistorial);

        items = new ArrayList<>();
        adapter = new MatchListAdapter(
                getContext(),
                R.layout.match_list_row,
                items
        );
        lvHistorial.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_matchlist, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.matchListRefresh) {
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void refresh() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }


    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<MatchList>> {
        @Override
        protected ArrayList<MatchList> doInBackground(Void... voids) {
            MatchListApi api = new MatchListApi();

            ArrayList<MatchList> result = api.getHistorial();

            Log.d("DEBUG", result.toString());

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<MatchList> listado) {
            adapter.clear();
            /*for (MatchList list : listado) {
                adapter.add(list.getLane());
            }*/

            for(int i = 0; i < listado.size(); i++)
            {
                adapter.add(listado.get(i));
            }

        }

    }




}
