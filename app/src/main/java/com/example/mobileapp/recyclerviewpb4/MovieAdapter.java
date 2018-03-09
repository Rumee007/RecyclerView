package com.example.mobileapp.recyclerviewpb4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Mobile App on 2/10/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private Context context;
    private List<Movie>movies;

    public MovieAdapter(Context context, List<Movie>movies){
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_row,parent,false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.movieNameTV.setText(movies.get(position).getMovieName());
        holder.movieCategoryTV.setText(movies.get(position).getMovieCategory());
    }

    @Override
    public int getItemCount() {
        return movies.size();
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
        }
    }

}
