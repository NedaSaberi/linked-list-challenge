package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        // Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listiterator.remove()


        Album album = new Album("Love", "Fateme");
        album.addSong("ti11", 2.75);
        album.addSong("ti22", 34.5);
        album.addSong("ti33", 3.98);
        album.addSong("ti44", 43.09);
        album.addSong("ti555", 12.21);
        album.addSong("ti66", 12.098);
        album.addSong("ti77", 3.9);
        album.addSong("ti88", 3.0);

        albums.add(album);

        album = new Album("Lie", "Ali");
        album.addSong("li11", 2.0);
        album.addSong("li22", 2.9);
        album.addSong("li33", 4.54);
        album.addSong("li44", 23445.54);
        album.addSong("li55", 223.909);
        album.addSong("li66", 1.0);
        album.addSong("li77", 3.45);
        album.addSong("li88", 54.98);
        album.addSong("li99", 2.90);
        album.addSong("li10", 2.2);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addToPlayList("ti77", playList);
        albums.get(0).addToPlayList("ti22", playList);
        albums.get(0).addToPlayList("ti88", playList);
        albums.get(0).addToPlayList("ti12", playList);// invalid
        albums.get(0).addToPlayList("ti11", playList);
        albums.get(0).addToPlayList(100, playList);// invalid
        albums.get(0).addToPlayList(5, playList);

        albums.get(1).addToPlayList("li89", playList);
        albums.get(1).addToPlayList("li22", playList);
        albums.get(1).addToPlayList("li44", playList);
        albums.get(1).addToPlayList("li00", playList);
        albums.get(1).addToPlayList("li10", playList);
        albums.get(1).addToPlayList(7, playList);
        albums.get(1).addToPlayList(23, playList);


        play(playList);

    }


    public static void play(LinkedList<Song> playList) {
        boolean quit = false;
        boolean goForward = true;
        ListIterator<Song> songListIterator = playList.listIterator();
        while (!quit) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0: //Quit
                    System.out.println("Bye");
                    quit = true;
                    break;
                case 1: // Forward
                    if (!goForward) {
                        if (songListIterator.hasNext())
                            songListIterator.next();
                        // goForward = true;
                    }

                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing " + songListIterator.next().toString());
                        goForward = true;
                    } else {
                        System.out.println("You have reached to the end of the list.");
                        goForward = false;
                    }

                    break;
                case 2: //Backwards
                    if (goForward) {
                        if (songListIterator.hasPrevious())
                            songListIterator.previous();
//                        else
//                            System.out.println("You are at the start of the list.");
                        //goForward = false;
                    }

                    if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing " + songListIterator.previous().toString());
                        goForward = false;
                    } else {
                        System.out.println("You are at the start of the list.");
                        //goForward = true;
                    }
                    break;
                case 3: //Replay
                    if (goForward) {
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing " + songListIterator.previous().toString());
                            goForward = false;
                        } else {
                            System.out.println("You are at the start of the list.");
                            //goForward = true;
                        }

                    } else {
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing " + songListIterator.next().toString());
                            goForward = true;
                        } else {
                            System.out.println("You have reached to the end of the list.");
                        }
                    }

                    break;
                case 4: //List
                    while (songListIterator.hasPrevious()) {
                        songListIterator.previous();
                    }
                    while (songListIterator.hasNext()) {
                        System.out.println(songListIterator.next().toString());
                    }
                    while (songListIterator.hasPrevious()) {
                        songListIterator.previous();
                    }
                    break;
                case 5: //remove
                    if (playList.size() > 0) {
                        songListIterator.remove();
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing "+ songListIterator.next().toString());
                        }else if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing "+ songListIterator.previous().toString());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Press\n" +
                "0- To quit\n" +
                "1- To skip forward to the next song\n" +
                "2- To skip backwards to a previous song\n" +
                "3- To replay the current song\n" +
                "4- List the songs in the playlist\n" +
                "5- To remove the current song from the playlist");

    }
}

