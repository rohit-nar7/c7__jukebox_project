package com.jukebox.data;

public class Song implements  Comparable<Song> {
    private int songId;
    private String songName;
    private double duration;
    private String albumId;
    private String artistId;

    public Song(int songId, String songName, double duration, String albumId, String artistId) {
        this.songId = songId;
        this.songName = songName;
        this.duration = duration;
        this.albumId = albumId;
        this.artistId = artistId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
    @Override
    public int compareTo(Song song) {
        return this.getSongName().compareTo(song.getSongName());
    }
}