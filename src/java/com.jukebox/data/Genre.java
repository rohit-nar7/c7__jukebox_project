package com.jukebox.data;

public class Genre {
    private int genreId;
    private String genre_name;

    public Genre(int genreId, String genre_name) {
        this.genreId = genreId;
        this.genre_name = genre_name;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }
}