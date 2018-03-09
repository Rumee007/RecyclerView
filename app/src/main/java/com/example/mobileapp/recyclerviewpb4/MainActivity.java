package com.example.mobileapp.recyclerviewpb4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Movie> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        // Only Movie
        movieAdapter = new MovieAdapter(this, Movie.generateMovies());
        // Movie and Image
        itemAdapter = new ItemAdapter(this, populateItems());

        // Use Grid Layout manager
        GridLayoutManager glm = new GridLayoutManager(this,2);
        // Use Linear Layout manager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        // Which layout : Action here
        recyclerView.setLayoutManager(llm);
        // Set here itemAdapter or adapter
        recyclerView.setAdapter(movieAdapter);

        Log.e(TAG, "onCreate called");
    }

    private List<Object> populateItems() {
        List<Object>items = new ArrayList<>();
        items.add(new Movie("Avengers","Action"));
        items.add(new RandomImage(R.drawable.car1));
        items.add(new Movie("Iron Man","Action"));
        items.add(new RandomImage(R.drawable.car2));
        return items;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy called");
    }
}
