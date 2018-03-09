package com.example.mobileapp.recyclerviewpb4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mobile App on 2/10/2018.
 */

public class Movie {
    private String movieName;
    private String movieCategory;

    public Movie(String movieName, String movieCategory) {
        this.movieName = movieName;
        this.movieCategory = movieCategory;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public static List<Movie>generateMovies(){
        List<Movie>movies = new ArrayList<>();
        movies.add(new Movie("Avengers","Action"));
        movies.add(new Movie("Iron Man","Action"));
        movies.add(new Movie("Titanic","Action / Drama"));
        movies.add(new Movie("Moneyball","Sports"));
        return movies;
    }
}
