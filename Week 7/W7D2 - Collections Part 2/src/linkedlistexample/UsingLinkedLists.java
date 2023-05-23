package linkedlistexample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class UsingLinkedLists {
    public static void main(String[] args) {
        // create and initialize a playlist
        LinkedList<Song> songsToAdd = new LinkedList<>();

        Collections.addAll(songsToAdd,  new Song("Respect", "Aretha Franklin"),
                                        new Song("Like a Rolling Stone", "Bob Dylan"),
                                        new Song("Smells Like Teen Spirit", "Nirvana"),
                                        new Song("Dreams", "Fleetwood Mac"),
                                        new Song("Gimme Shelter", "The Rolling Stones"));

        // create playlist and add songs
        Playlist favoriteSongs = new Playlist(songsToAdd);
        System.out.println("Favorite Songs initially:");
        System.out.println(favoriteSongs);

        // my third favorite song is now Queen's Bohemian Rhapsody (taking advantage of indexes)
        favoriteSongs.getSongs().add(2, new Song("Bohemian Rhapsody", "Queen"));
        System.out.println("Favorite Songs with addition:");
        System.out.println(favoriteSongs);

        // my new absolute favorite song is now ....
        favoriteSongs.getSongs().addFirst(new Song("Born to Run", "Bruce Springsteen"));
        System.out.println("Favorite Songs with new favorite song:");
        System.out.println(favoriteSongs);

        // I got tired of the very last song on my playlist, whichever position it is in
        favoriteSongs.getSongs().removeLast();
        System.out.println("Favorite Songs with last song removed:");
        System.out.println(favoriteSongs);
        

        // let's iterate over the songs from least favorite to my absolute favorite
        System.out.println("Looking at playlist from backwards to forwards:");
        int positionToStartAt = favoriteSongs.getSongs().size();
        ListIterator<Song> listIterator = favoriteSongs.getSongs().listIterator(positionToStartAt);

        // let's say our collection looked like this:
        //  song1  song2
        //   0       1    iterator starts here
        while (listIterator.hasPrevious()) {
            // get the current song
            Song currentSong = listIterator.previous();
            
            // print it out
            System.out.println(currentSong);
            listIterator.remove(); // remove with iterator's remove method NOT collection's remove method
        }

        System.out.println("Favorite Songs with all songs removed:");
        System.out.println(favoriteSongs);

    }
}