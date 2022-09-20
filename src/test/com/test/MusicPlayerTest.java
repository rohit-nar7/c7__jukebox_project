package com.test;

import com.jukebox.dao.PlaylistDetailsDAO;
import com.jukebox.dao.SongDAO;
import com.jukebox.data.Song;
import com.jukebox.main.MusicPlayerDAOImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MusicPlayerTest {
    SongDAO sd=new SongDAO();
    PlaylistDetailsDAO playlistDetailsDAO = new PlaylistDetailsDAO();

    @Test
    public void noOfSong() throws SQLException, ClassNotFoundException {
        List<Song> count = sd.getAllSongs();
        assertEquals(9,count.size());
    }
    @Test
    public void searchSong() throws SQLException, ClassNotFoundException {
        String songName = "Kesariya";
        List<Song> count = sd.searchSongBySongName(songName);
        assertEquals(1, count.size());
    }
    @Test
    public void searchGenre() throws SQLException, ClassNotFoundException {
        String genreName = "BollywoodHit";
        List<Song> count = sd.searchSongByGenre(genreName);
        assertEquals(2, count.size());
    }
    @Test
    public void searchAlbum() throws SQLException, ClassNotFoundException {
        String albumName = "Brahmastra";
        List<Song> count = sd.searchSongByAlbum(albumName);
        assertEquals(1, count.size());
    }
}
