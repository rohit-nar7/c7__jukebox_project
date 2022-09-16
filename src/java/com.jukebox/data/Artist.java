package com.jukebox.data;

public class Artist {
    private int artistId;
    private String artist_name;
    private int artist_age;
    private String genreId;


    public Artist(int artistId, String artist_name, int artist_age, String genreId) {
        this.artistId = artistId;
        this.artist_name = artist_name;
        this.artist_age = artist_age;
        this.genreId = genreId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getArtist_age() {
        return artist_age;
    }

    public void setArtist_age(int artist_age) {
        this.artist_age = artist_age;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }
}