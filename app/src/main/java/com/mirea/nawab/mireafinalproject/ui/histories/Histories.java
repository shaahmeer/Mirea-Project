package com.mirea.nawab.mireafinalproject.ui.histories;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import com.mirea.nawab.mireafinalproject.R;
import com.mirea.nawab.mireafinalproject.ui.Calculator.Calculator;

public class Histories extends Fragment {
    private RecyclerView stories;
    private AdapterCell adapterCell;
    List<com.mirea.nawab.mireafinalproject.ui.histories.Cell> listStories;

    public Histories() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenthistories, container, false);
        com.mirea.nawab.mireafinalproject.ui.histories.AppDatabase db = App.getInstance().getDatabase();
        HistoriesDao historiesDao = db.storyDao();
        stories = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        stories.setLayoutManager(layoutManager);
        stories.setHasFixedSize(true);
        listStories = historiesDao.getAll();
        adapterCell = new AdapterCell(listStories);
        stories.setAdapter(adapterCell);
        return view;
    }
}
