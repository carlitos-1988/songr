package com.songr.songr.models;

import jakarta.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    int songInSeconds;
    int trackNumber;

    @ManyToOne
    Album album;

    protected Song() {
    }

    public Song( String title, int songInSeconds, int trackNumber) {
        this.title = title;
        this.songInSeconds = songInSeconds;
        this.trackNumber = trackNumber;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getSongInSeconds() {
        return songInSeconds;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
