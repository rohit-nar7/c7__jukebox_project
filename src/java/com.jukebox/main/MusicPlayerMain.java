package com.jukebox.main;

import com.jukebox.dao.*;
import com.jukebox.data.*;
import com.jukebox.util.DbConnection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.jukebox.main.MusicPlayerDAOImpl.allSongs;


class MusicPlayerMain {
    static Scanner sc = new Scanner(System.in);

    public static  void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {

        SongDAO songDao = new SongDAO();
//        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("************************** Welcome to Jukebox Music **************************");
//        Scanner take = new Scanner(System.in);
//        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("------------------------------MENU OPTIONS!-----------------------------");
        System.out.println("1. Songs");
        System.out.println("2. Create Playlist");
        System.out.println("3. Show Playlist");
        System.out.println("4. Exit");
//        Thread.sleep(4000);
        System.out.println("Enter your choice:");
//        allSongs();
        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input MisMatched");
        }
        switch (choice) {
            case 1:
                int choice2;
                do {
                    System.out.println("----------Available Options:-----------");
                    System.out.println("\n1. View All Songs  \n2. Play Songs \n3. Search Songs\n4. Go Back");

                    System.out.println("Enter you choice :");
                    choice2 = sc.nextInt();

                    switch (choice2) {
                        case 1:
                            try {
                                List<Song> songList = songDao.getAllSongs();
                                Collections.sort(songList);
                                songDao.display(songList);
                            } catch (Exception e) {
                                System.err.println("Songs not found");
                            }
                            break;
                        case 2:
                            System.out.println("********** Play music ***********");
                            List<Song> allSongsList = songDao.getAllSongs();
                            allSongs();
                            System.out.println("Enter your Choice to play song by songId");
                            choice = sc.nextInt();
                            for (Song list : allSongsList) {
                                if (list.getSongId() == choice) {
                                    MusicPlayerDAOImpl musicPlayerDAO = new MusicPlayerDAOImpl();
                                    musicPlayerDAO.MusicPlay(list.getSongName());
                                }
                            }

                            break;


                        case 3:
                            int choice3;
                            do {
                                System.out.println("\n......Choose search option..........");
                                System.out.println("1. By Song name \n2. By Artist\n3. By Genre\n4. By Album\n5. Go back");
                                System.out.println("Enter your Choice :");
                                choice3 = sc.nextInt();
                                switch (choice3) {
                                    //Search Song by Song Name
                                    case 1:
                                        allSongs();
                                        System.out.println("Enter Song name to search : ");
                                        String songName = sc.next();
                                        try {
                                            List<Song> songsBySongName = songDao.searchSongBySongName(songName);
                                            if (songsBySongName.size() == 0) {
                                                System.out.println(("No Songs present in the Songs List"));
                                            } else {
                                                songDao.display(songsBySongName);
                                                MusicPlayerDAOImpl musicPlayerDAO = new MusicPlayerDAOImpl();
                                                musicPlayerDAO.MusicPlay(songName);

                                            }
                                        } catch (Exception ex) {
                                            System.err.println("song not found !!!");
                                        }
                                        break;
                                    case 2: {
                                        MusicPlayerDAOImpl musicPlayerDAO = new MusicPlayerDAOImpl();
                                        allSongs();
                                        //Search Song by Artist Name
                                        System.out.println("Enter name of artist that you want to search");
                                        String artist = sc.next();
                                        List<Song> songsByArtistName = songDao.searchSongByArtist(artist);
                                        sc.nextLine();
                                        songDao.display(songsByArtistName);
                                        System.out.println("do you want to play this artist songs");
                                        System.out.println("yes/no");
                                        String tell = sc.next();
                                        if (tell.equalsIgnoreCase("yes")) {
                                            System.out.println("enter the songName to play");
                                            String songName1 = sc.next();
                                            musicPlayerDAO = new MusicPlayerDAOImpl();
                                            musicPlayerDAO.MusicPlay(songName1);
                                        }
                                        break;

                                    }
                                    case 3: {
                                        allSongs();
                                        MusicPlayerDAOImpl musicPlayerDAO = new MusicPlayerDAOImpl();

                                        //Search Song by Genre Name
                                        System.out.println("Enter Genre Name that you want to search");
                                        String genre = sc.next();
                                        List<Song> songsByGenreName = songDao.searchSongByGenre(genre);
                                        songDao.display(songsByGenreName);
                                        System.out.println("do you want to play this Genre songs");
                                        System.out.println("yes/no");
                                        String tell = sc.next();
                                        if (tell.equalsIgnoreCase("yes")) {
                                            System.out.println("enter the songName to play");
                                            String songName1 = sc.next();
                                            musicPlayerDAO = new MusicPlayerDAOImpl();
                                            musicPlayerDAO.MusicPlay(songName1);
                                        }
                                        break;
                                    }
                                    case 4:
                                        allSongs();
                                        MusicPlayerDAOImpl musicPlayerDAO = new MusicPlayerDAOImpl();

                                        System.out.println("Enter Album Name that you want to search for Songs : ");
                                        String nameOfAlbum = sc.next();
                                        List<Song> songsByAlbumName = songDao.searchSongByAlbum(nameOfAlbum);
                                        songDao.display(songsByAlbumName);
                                        System.out.println("do you want to play this Album songs");
                                        System.out.println("yes/no");
                                        String tell = sc.next();
                                        if (tell.equalsIgnoreCase("yes")) {
                                            System.out.println("enter the songName to play");
                                            String songName1 = sc.next();
                                            musicPlayerDAO = new MusicPlayerDAOImpl();
                                            musicPlayerDAO.MusicPlay(songName1);
                                        }
                                        break;
                                    default:
                                        System.out.println("------go back---------");
                                        break;
                                }
                            } while (choice3 != 5);
                            break;
                        case 4:
                            System.out.println("------------------exiting-------------------");
                            System.exit(0);
                            break;

                    }
                } while (choice2 != 4);
                break;
            case 2:
                System.out.println("enter playlist id to add");
                int pId = sc.nextInt();
                allSongs();
                System.out.println("enter songsName to add");
                String pName = sc.next();
                PlaylistDetailsDAO playlistDetailsDAO = new PlaylistDetailsDAO();
                playlistDetailsDAO.addSongToPlaylist(new PlaylistDetails(pId, pName));
//                System.out.println(data);
                int enter;
                do {
                    System.out.println("interested in adding more songs");
                    System.out.println("1:Yes  2:No");
                    int put = sc.nextInt();
                    switch (put) {
                        case 1:
                            allSongs();
                            System.out.println("enter song name to add");
                            String songName = sc.next();
                            playlistDetailsDAO = new PlaylistDetailsDAO();
                            playlistDetailsDAO.addSongToPlaylist(new PlaylistDetails(pId, pName));
                            break;
                        case 2:
                            System.out.println("songs are added to the playlist");
//                            System.out.println("*************************Exiting******************************+\n*********************** End of Jukebox Thank you for visiting ********************");
//                        rs = false;

                            break;
                    }
                    System.out.println("enter 0 for exit");
                    enter = sc.nextInt();
                } while (enter != 0);

            case 3:
                System.out.println("---------------Displaying playlist----------------");
                List<PlaylistDetails> playlistDetails = new ArrayList<>();
                Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from playlistcontents");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    playlistDetails.add(new PlaylistDetails(resultSet.getInt(1),
                            resultSet.getString(2)));
                }

                System.out.println("PlaylistId" + "\t\t\t\t\t" + "SongName");
                for (PlaylistDetails element : playlistDetails) {
                    System.out.println(element.getPlaylistId() + "\t\t\t\t\t\t\t" + element.getSongsName());
                }
                do {
                    System.out.println("do you want to play songs of playlist?");
                    System.out.println("1: yes   /   2:no");
                    int tell = sc.nextInt();
                    switch (tell) {
                        case 1:
                            allSongs();
                            System.out.println("enter the songName to play");
                            String songName = sc.next();
                            MusicPlayerDAOImpl musicPlayerDAO = new MusicPlayerDAOImpl();
                            musicPlayerDAO.MusicPlay(songName);
                        case 2:
//                            System.out.println("*********************** End of Jukebox Thank you for visiting ********************");
                            break;
                    }
                System.out.println("enter 0 for exit");
                enter = sc.nextInt();
        } while (enter != 0);

            default:
                System.out.println("Exiting!!!");
                System.exit(0);
        }
        while (choice != 4);

        }
    public static void allSongs() throws ClassNotFoundException, SQLException {
        SongDAO songDAO = new SongDAO();
        List<Song> allSongsList = songDAO.getAllSongs();
        songDAO.display(allSongsList);
    }




    }
