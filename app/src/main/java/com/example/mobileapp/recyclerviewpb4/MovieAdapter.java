package com.example.mobileapp.recyclerviewpb4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Mobile App on 2/10/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private Context context;
    private List<Movie>movies;

    private static final String TAG = MovieAdapter.class.getSimpleName();

    public MovieAdapter(Context context, List<Movie>movies){
        this.context = context;
        this.movies = movies;
        Log.e(TAG, "MovieAdapter(Context context, List<Movie>movies)");
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_row,parent,false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        Log.e(TAG, "onCreateViewHolder");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder");
        holder.movieNameTV.setText(movies.get(position).getMovieName());
        holder.movieCategoryTV.setText(movies.get(position).getMovieCategory());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        private final String TAG = MovieViewHolder.class.getSimpleName();


        ImageView movieImage;
        TextView movieNameTV;
        TextView movieCategoryTV;
        public MovieViewHolder(View itemView) {
            super(itemView);
            Log.e(TAG, "MovieViewHolder");
            movieImage = itemView.findViewById(R.id.movieImage);
            movieNameTV = itemView.findViewById(R.id.movieName);
            movieCategoryTV = itemView.findViewById(R.id.movieCategory);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Movie movie = movies.get(position);
                    Toast.makeText(context, movie.getMovieName(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
