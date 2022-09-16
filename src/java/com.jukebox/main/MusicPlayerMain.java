package com.jukebox.main;

import com.jukebox.data.Album;
import com.jukebox.data.Genre;
import com.jukebox.data.Song;

import java.util.*;

public class MusicPlayerMain {
    ArrayList<Album> albumArrayList = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Album> albumArrayList = new ArrayList<>();
        LinkedList<Song> playlist = new LinkedList<Song>();

        Album album1 = new Album("Album_1", "Lil", 2014, new Genre("Motivation"));

        album1.addSongToAlbum(new Song("TNT", 4.5));
        album1.addSongToAlbum(new Song("Highway to hell",3.5));
        album1.addSongToAlbum(new Song("ThunderStruck",5.0));
        albumArrayList.add(album1);

        Album album2 = new Album("Album_2", "Eminem", 2018, new Genre("Rap"));


        album2.addSongToAlbum(new Song("Rap god",4.5));
        album2.addSongToAlbum(new Song("Not Afraid",3.5));
        album2.addSongToAlbum(new Song("Lose yourself",4.5));
        albumArrayList.add(album2);

        Album album3 = new Album("Album_3", "Arjit_Singh", 2016,new Genre("Sad Songs"));


        album1.addSongToAlbum(new Song("Kesariya", 4.5));
        album1.addSongToAlbum(new Song("Agar tum sath ho", 5.4));
        album1.addSongToAlbum(new Song("Tera yaar hoon main", 4.3));
        albumArrayList.add(album1);

        LinkedList<Song> playList_songs = new LinkedList<>();

        album1.addSongToPlayList("TNT", playList_songs);
        album1.addSongToPlayList("Highway to hell",playList_songs);
        album1.addSongToPlayList("Rap god",playList_songs);
        album1.addSongToPlayList("Lose yourself",playList_songs);
        album1.addSongToPlayList("Kesariya",playList_songs);
        album1.addSongToPlayList("Agar tum sath ho",playList_songs);


        play(playList_songs);

    }

    private static void play(LinkedList<Song> PlayList)
    {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = PlayList.listIterator();

        if(PlayList.size() == 0)
        {
            System.out.println("This PlayList has no song");
        }
        else
        {
            System.out.println("Now Playing : " + listIterator.next().toString());
            printMenu();
        }

        while(!quit)
        {
            int action = sc.nextInt();
            sc.nextLine();

            switch(action) {

                case 0:
                    System.out.println("PlayList Complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward)
                    {
                        if(listIterator.hasNext())
                            listIterator.next();

                        forward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now Playing : " + listIterator.next().toString());
                    }
                    else
                    {
                        System.out.println("We have reached the end of the Playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now Playing : " + listIterator.previous().toString());
                    }
                    else
                    {
                        System.out.println("We are at the first song!");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }
                        else
                        {
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }
                        else
                        {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(PlayList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(PlayList.size() > 0)
                    {
                        listIterator.remove();

                        if(listIterator.hasNext())
                        {
                            System.out.println("Now Playing : " + listIterator.next().toString());
                        }
                        else
                        {
                            if(listIterator.hasPrevious())
                                System.out.println("Now Plaing : " + listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu()
    {
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all songs\n" +
                "5 - list of all available options\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> PlayList)
    {
        Iterator<Song> iterator = PlayList.iterator();
        System.out.println("---------------------");

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("---------------------");

    }
}

