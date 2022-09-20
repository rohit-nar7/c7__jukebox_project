package com.jukebox.main;

import com.jukebox.dao.SongDAO;
import com.jukebox.data.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MusicPlayerDAOImpl {
    static Long currentFrame;
    static Clip clip;
    static String status;
    static Scanner sc = new Scanner(System.in);
    int currentIndex;
    SongDAO songDAO = new SongDAO();

    public static void allSongs() throws ClassNotFoundException, SQLException {
        SongDAO songDAO = new SongDAO();
        List<Song> allSongsList = songDAO.getAllSongs();
        songDAO.display(allSongsList);

    }

    public MusicPlayerDAOImpl() {
    }


    public void MusicPlay(String songName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("src/resources/" + songName + ".wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        try {
            int choice;
            int put;
            do {
                System.out.println("1. Play\n2. Pause\n3. Resume\n4. Restart\n5. Next SongName to play\n6. Exit");
                System.out.println();
                System.out.println("Enter your choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        clip.start();
                        status = "play";
                        System.out.println("-----------------currently playing---------------:"+songName);
//                        long length = clip.getMicrosecondLength();
//                        System.out.println("duration of song: "+length/1000000L);
                        break;

                    case 2:
                        if (status.equals("paused")) {
                            System.out.println("audio is already paused");
                            //return;
                        } else {
                            this.currentFrame = this.clip.getMicrosecondPosition();
                            clip.stop();
                            status = "paused";
                            System.out.println("Music is paused at " + this.clip.getMicrosecondPosition() + " Position ");
                        }

                        break;
                    case 3:
                        if (status.equals("play")) {
                            System.out.println("Audio is already being played");
                            // return;
                        } else {
                            System.out.println("Music is Resumed in " + this.clip.getMicrosecondPosition() + " Position");
                            clip.close();
                            file = new File("src/resources/" + songName + ".wav");
                            audioInputStream = AudioSystem.getAudioInputStream(file);
                            clip.open(audioInputStream);
                            clip.setMicrosecondPosition(currentFrame);
                            clip.start();
                            status = "play";
                        }

                        break;
                    case 4:
                        clip.stop();
                        clip.close();
                        audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/" + songName + ".wav").getAbsoluteFile());
                        clip.open(audioInputStream);
                        currentFrame = 0L;
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        status = "play";
                        break;

                    case 5:
                        allSongs();
                        System.out.println("enter song name to play next");
                        clip.stop();
                        String songName1 = sc.next();
                        MusicPlay(songName1);
                        break;

//                    case 6:
//                        List<Song> allSongs = songDAO.getAllSongs();
//
//                        String name = allSongs.get(0).getSongName();
//                        MusicPlay(name);

//                        break;
                    case 6:
                        clip.stop();
                        System.out.println("Exiting the play songs menu!!!");
                        return;

                }
            } while (choice != 6);

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
        }
    }

    public static String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        System.out.print("\r"+hours+":"+minutes+":"+seconds);
        finalTimerString = finalTimerString + minutes + seconds;
        return finalTimerString;
    }
}
//    public void playNext() throws UnsupportedAudioFileException, IOException, LineUnavailableException, SQLException, ClassNotFoundException {
//        clip.stop();
//
//        SongDAO songDAO = new SongDAO();
//        List<Song> songList = songDAO.getIdOfSong();
//
//        String songName = songList.get(currentIndex).getSongName();
//        if (songList.get(currentIndex).getSongId() < songList.size()) {
//            MusicPlayerDAOImpl audioPlayer =
//                    new MusicPlayerDAOImpl();
//            audioPlayer.MusicPlay(songName);
//        }
//
//    }
//
//    public void playPrevious() throws UnsupportedAudioFileException, IOException, LineUnavailableException, SQLException, ClassNotFoundException {
//        clip.stop();
//        SongDAO songDAO = new SongDAO();
//        List<Song> songList = songDAO.getAllSongs();
//        int songId = songList.get(0).getSongId();
//        if (songList.get(currentIndex).getSongId() < songList.size()) {
//            MusicPlayerDAOImpl audioPlayer =
//                    new MusicPlayerDAOImpl();
//            String songName = songDAO.getSong(songId);
//            audioPlayer.MusicPlay(songName);
////        }
////
////    }
//}
