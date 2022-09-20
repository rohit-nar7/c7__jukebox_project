package com.jukebox.dao;

import com.jukebox.data.PlaylistDetails;
import com.jukebox.data.Song;
import com.jukebox.main.MusicPlayerDAOImpl;
import com.jukebox.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PlaylistDetailsDAO {
	Scanner scanner = new Scanner(System.in);

	//	public  int PlaylistDetails(int playlistId, int songId, String playlistName) throws SQLException, ClassNotFoundException {
//		Connection con = DbConnection.getConnection();
//		Scanner take = new Scanner(System.in);
//
//		String songPlaylist = "Insert into playlist(playlistName, playlistId,songs_id) "+"values (?,?,?)";
//		PreparedStatement addingSong = con.prepareStatement(songPlaylist);
//		addingSong.setString(1, playlistName);
//		addingSong.setInt(2, playlistId);
//		addingSong.setInt(3, songId);
//
//		int resultSet = addingSong.executeUpdate();
//		if(resultSet > 0) {
//			System.out.println("successfully added");
//
//		}
////		PreparedStatement songUpdate = con.prepareStatement(songPlaylist);
//////		System.out.println("enter songId to add to playlist");
////		songUpdate.setInt(1, songId);
//
//
//		return resultSet;
//	}
	public static void allSongs() throws ClassNotFoundException, SQLException {
		SongDAO songDAO = new SongDAO();
		List<Song> allSongsList = songDAO.getAllSongs();
		songDAO.display(allSongsList);
	}

	public String addSongToPlaylist(PlaylistDetails playlistDetails) throws SQLException, ClassNotFoundException {

		Connection connection = DbConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into playlistcontents values(?,?)");
		preparedStatement.setInt(1, playlistDetails.getPlaylistId());
		preparedStatement.setString(2, playlistDetails.getSongsName());
		int rows = preparedStatement.executeUpdate();
		if (rows > 0) {
			System.out.println("songs added to playlist");
		}
		return "";
	}
}
