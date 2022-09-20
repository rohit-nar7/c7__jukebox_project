package com.jukebox.data;

public class PlaylistDetails {
    private int playlistId;
    private String songsName;

    public PlaylistDetails(int playlistId, String songsName) {
        this.playlistId = playlistId;
        this.songsName = songsName;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getSongsName() {
        return songsName;
    }

    public String setSongsName(String songsName) {
        this.songsName = songsName;
        return songsName;
    }
}