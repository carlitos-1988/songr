package com.songr.songr.models;

import jakarta.persistence.*;

import java.util.List;

//Step 1: @Entity to tell spring that this is a class for a database
@Entity
public class Album {

    //Step 2: add @ID to property class use this to keep records unique
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;


    //Step for adding relationships
    @OneToMany(mappedBy = "album",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Song> songs;

    //Step 3: Add protected default constructor
    protected Album() {
    }

    public Album(long id, String title, String artist, int songCount, int length) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
    }

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getId() {
        return id;
    }

    public List<Song> getSongs(){
        return songs;
    }

    public void setSong(Song song){
        songs.add(song);
    }
}
