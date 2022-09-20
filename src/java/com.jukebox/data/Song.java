package com.jukebox.data;

public class Song implements  Comparable<Song> {
    private int songId;
    private String songName;
    private String duration;
    private String albumName;
    private String artistName;
    private String genreName;
    private String path;


    public Song(int songId, String songName, String duration, String albumName, String artistName, String genreName, String path) {
        this.songId = songId;
        this.songName = songName;
        this.duration = duration;
        this.albumName = albumName;
        this.artistName = artistName;
        this.genreName = genreName;
        this.path = path;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Song() {

    }


    @Override
    public int compareTo(Song song) {
        return this.getSongId() - song.getSongId();
    }
}