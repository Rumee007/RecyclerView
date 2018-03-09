package com.example.mobileapp.recyclerviewpb4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mobile App on 2/10/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Object>items;

    private static final int MOVIE = 1;
    private static final int IMAGE = 2;

    public ItemAdapter(Context context, List<Object> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case MOVIE:
                v = inflater.inflate(R.layout.movie_row,parent,false);
                viewHolder = new MovieViewHolder(v);
                return viewHolder;
            case IMAGE:
                v = inflater.inflate(R.layout.image_row,parent,false);
                viewHolder = new ImageViewholder(v);
                return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case MOVIE:
                MovieViewHolder mvh = (MovieViewHolder) holder;
                Movie movie = (Movie) items.get(position);
                mvh.movieNameTV.setText(movie.getMovieName());
                mvh.movieCategoryTV.setText(movie.getMovieCategory());
                break;
            case IMAGE:
                ImageViewholder ivh = (ImageViewholder) holder;
                RandomImage randomImage = (RandomImage) items.get(position);
                ivh.randomIV.setImageResource(randomImage.getImage());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(items.get(position) instanceof Movie){
            return MOVIE;
        }else if(items.get(position) instanceof RandomImage){
            return IMAGE;
        }
        return -1;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView movieNameTV;
        TextView movieCategoryTV;
        public MovieViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
            movieNameTV = itemView.findViewById(R.id.movieName);
            movieCategoryTV = itemView.findViewById(R.id.movieCategory);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Movie movie = (Movie) items.get(position);
                    Toast.makeText(context, movie.getMovieName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class ImageViewholder extends RecyclerView.ViewHolder{
        ImageView randomIV;
        public ImageViewholder(View itemView) {
            super(itemView);
            randomIV = itemView.findViewById(R.id.randomImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    RandomImage randomImage = (RandomImage) items.get(position);
                    Toast.makeText(context, randomImage.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
