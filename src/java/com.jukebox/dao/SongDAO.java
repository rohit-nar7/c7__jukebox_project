package com.jukebox.dao;

import com.jukebox.data.Song;
import com.jukebox.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongDAO {

    public List<Song> getAllSongs() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        List<Song> allSongs =new ArrayList<>();
        String query= "select songs_id, songs_name, songs_duration, songs_path, artist_name, album_name, genre_name from songs";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Song song=new Song(resultSet.getInt("songs_id"),
                        resultSet.getString("songs_name"), resultSet.getString("songs_duration"),resultSet.getString("songs_path"),
                        resultSet.getString("artist_name"), resultSet.getString("album_name"), resultSet.getString("genre_name"));

                allSongs.add(song);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Collections.sort(allSongs);
        return allSongs;
    }

    public List<Song> searchSongBySongName(String songName)
    {
        List<Song> songsList= new ArrayList<>();
        try
        {
            Connection connection = DbConnection.getConnection();
            String query = "select * from songs where songs_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Song song=new Song(resultSet.getInt("songs_id"),
                        resultSet.getString("songs_name"), resultSet.getString("songs_duration"),resultSet.getString("songs_path"),
                        resultSet.getString("artist_name"), resultSet.getString("album_name"), resultSet.getString("genre_name"));
                songsList.add(song);
            }
            return songsList;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Song> searchSongByArtist(String artistName)
    {
        List<Song> songsList= new ArrayList<>();
        try
        {
            Connection connection = DbConnection.getConnection();
            String query = "select * from songs where artist_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, artistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Song song=new Song(resultSet.getInt("songs_id"),
                        resultSet.getString("songs_name"), resultSet.getString("songs_duration"),resultSet.getString("songs_path"),
                        resultSet.getString("artist_name"), resultSet.getString("album_name"), resultSet.getString("genre_name"));
                songsList.add(song);
            }
            return songsList;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public List<Song> searchSongByAlbum(String albumName) {
        List<Song> songsList= new ArrayList<>();
        try
        {
            Connection connection = DbConnection.getConnection();
            String query = "select * from songs where album_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,albumName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Song song=new Song(resultSet.getInt("songs_id"),
                        resultSet.getString("songs_name"), resultSet.getString("songs_duration"),resultSet.getString("songs_path"),
                        resultSet.getString("artist_name"), resultSet.getString("album_name"), resultSet.getString("genre_name"));
                songsList.add(song);
            }
            return songsList;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Song> searchSongByGenre(String genreName)
    {
        List<Song> songsList= new ArrayList<>();
        try
        {
            Connection connection = DbConnection.getConnection();
            String query = "select * from songs where genre_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,genreName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Song song=new Song(resultSet.getInt("songs_id"),
                        resultSet.getString("songs_name"), resultSet.getString("songs_duration"),resultSet.getString("songs_path"),
                        resultSet.getString("artist_name"), resultSet.getString("album_name"), resultSet.getString("genre_name"));
                songsList.add(song);
            }
            return songsList;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public int getIdOfSong(String songName) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        String query = "select songs_id from songs where songs_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,songName);
        int id = preparedStatement.executeUpdate();


        return id;
    }

    public Song getSong(int songId) {
        try
        {
            Connection connection = DbConnection.getConnection();
            String query = "select songs_name from songs where songs_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,songId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song=new Song(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
                return song;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public void display(List<Song> allSongs)
    {
            System.out.format("%-10s%-35s%-20s%-20s%-20s%-40s%-20s","Song id","SongName","Duration","Album Name","Artist Name","Location","Genre Name\n");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
            allSongs.forEach(song ->System.out.format("\n%-10s%-35s%-20s%-20s%-20s%-40s%-20s",song.getSongId(),song.getSongName(),song.getDuration(), song.getGenreName(),song.getArtistName(), song.getAlbumName(), song.getPath()));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}

