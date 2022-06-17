package com.mirzahansuslu.moviebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {
    TextView movie_name;
    TextView movie_date;
    TextView movie_runtime;
    TextView rating;
    ImageView imageOfMovie;
    TextView textView_movie_Print;
    RecyclerView recycler_movie_celeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        textView_movie_Print = findViewById(R.id.textView_movie_Print);
        movie_name = findViewById(R.id.movie_name);
        movie_date = findViewById(R.id.movie_date);
        movie_runtime = findViewById(R.id.movie_runtime);
        rating = findViewById(R.id.rating);
        imageOfMovie  = findViewById(R.id.imageOfMovie);
        recycler_movie_celeb = findViewById(R.id.recycler_movie_celeb);

    }
}