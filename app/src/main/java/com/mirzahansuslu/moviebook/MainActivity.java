package com.mirzahansuslu.moviebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mirzahansuslu.moviebook.Adapters.RecyclerHomeAdapter;
import com.mirzahansuslu.moviebook.Listeners.OnMovieListener;
import com.mirzahansuslu.moviebook.Listeners.OnSearchApiListener;

import Models.SearchApi;

public class MainActivity extends AppCompatActivity implements OnMovieListener {
    RequestManager requestManager;
    SearchView search_view;
    RecyclerView recycler_view;
    RecyclerHomeAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        search_view = findViewById(R.id.search_view);
        recycler_view = findViewById(R.id.recycler_view);
        progressDialog = new ProgressDialog(this);

        requestManager = new RequestManager(this);
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                runOnUiThread(() -> {
                    progressDialog.setTitle("Searching...");
                    progressDialog.show();
                    requestManager.searchMovies(listener, query);
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnSearchApiListener listener = new OnSearchApiListener() {
        @Override
        public void onResponse(SearchApi response) {
            progressDialog.dismiss();
            if (response == null) {
                Toast.makeText(MainActivity.this, "No data", Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(SearchApi response) {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new RecyclerHomeAdapter(this, response.getSearch(), this);
        recycler_view.setAdapter(adapter);
    }

    @Override
    public void onMovieClick(String id) {
        startActivity(new Intent(MainActivity.this,MovieDetailsActivity.class)
        .putExtra("data",id));

    }
}