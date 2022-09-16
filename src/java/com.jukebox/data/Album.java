package com.jukebox.data;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private int albumId;
    private String albumName;
    private String albumArtist;
    private int albumYear;

    public Album(int albumId, String albumName, String albumArtist, int albumYear) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.albumYear = albumYear;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public int getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }
}