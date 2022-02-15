package com.example.edt69;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private Context mContext;
    private List<Anime> mAnimes;

    public MyAdapter(Context mContext, List<Anime> mAnimes) {
        this.mContext = mContext;
        this.mAnimes = mAnimes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.animerow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(mAnimes.get(position).getName());
        holder.description.setText(mAnimes.get(position).getName());
        holder.type.setText(mAnimes.get(position).getType());
        holder.year.setText(mAnimes.get(position).getYear());
        //holder.imageurl.(mAnimes.get(position).getImageurl());
        Picasso.get().load(mAnimes.get(position).getImageurl()).fit().centerCrop().into(holder.imageurl);

    }

    @Override
    public int getItemCount() {

        return mAnimes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView description;
        TextView type;
        TextView year;
        ImageView imageurl;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameAnime);
            description = itemView.findViewById(R.id.descriptionAnime);
            type = itemView.findViewById(R.id.typeAnime);
            year = itemView.findViewById(R.id.yearAnime);
            imageurl = itemView.findViewById(R.id.imageAnime);

        }

    }
}