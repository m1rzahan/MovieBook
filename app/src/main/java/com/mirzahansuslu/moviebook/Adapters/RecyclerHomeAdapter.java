package com.mirzahansuslu.moviebook.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mirzahansuslu.moviebook.Listeners.OnMovieListener;
import com.mirzahansuslu.moviebook.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Models.SearchArrayObject;

public class RecyclerHomeAdapter extends  RecyclerView.Adapter<HomeViewHolder>{
    Context context;
    List<SearchArrayObject> list;
    OnMovieListener listener;

    public RecyclerHomeAdapter(Context context, List<SearchArrayObject> list, OnMovieListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.home_page,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
    holder.textView_movie.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getPoster()).into(holder.image_view);
        holder.home_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMovieClick(list.get(position).getImdbID());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class HomeViewHolder extends RecyclerView.ViewHolder {
    ImageView image_view;
    TextView textView_movie;
    CardView home_container;
    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        image_view = itemView.findViewById(R.id.image_view);
        textView_movie = itemView.findViewById(R.id.textView_movie);
        home_container = itemView.findViewById(R.id.home_container);

    }
}
