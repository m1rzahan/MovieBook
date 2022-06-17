package com.mirzahansuslu.moviebook.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirzahansuslu.moviebook.R;

public class RecycleCastAdapter  extends RecyclerView.Adapter<CastViewHolder> {
    Context context;

    public RecycleCastAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CastViewHolder(LayoutInflater.from(context).inflate(R.layout.cast_data,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
    /*holder.textview_actor.setText(list.get(position).getActor());
        holder.textview_char.setText(list.get(position).getCharacter());*/
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class CastViewHolder extends RecyclerView.ViewHolder {
    TextView textview_actor;
    TextView textview_char;

    public CastViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_actor = itemView.findViewById(R.id.textview_actor);
        textview_char = itemView.findViewById(R.id.textview_char);

    }
}
