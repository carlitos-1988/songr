package com.songr.songr.controllers;

import com.songr.songr.models.Album;
import com.songr.songr.models.Song;
import com.songr.songr.repositories.AlbumsRepository;
import com.songr.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    AlbumsRepository albumsRepository;

    @Autowired
    SongRepository songRepository;

    @RequestMapping("/songs")
    public String Songs(Model m){

        List<Song> mySongCollection = songRepository.findAll();
        m.addAttribute("songs", mySongCollection);

        return "songs.html";
    }

    @PostMapping("/addSong")
    public RedirectView addView(String title, String songInSeconds, String trackNumber,String album){

        Song myNewSong = new Song (title, Integer.parseInt(songInSeconds), Integer.parseInt(trackNumber));

        Long albumID = Long.parseLong(album);
        myNewSong.setAlbum(albumsRepository.getById(albumID));
        Album myAlbum = albumsRepository.getById(albumID);
        myAlbum.setSong(myNewSong);
        songRepository.save(myNewSong);

        return new RedirectView("/songs");
    }

    @PostMapping("/deleteSong")
    public RedirectView deleteSong(String songDelete){
        Long mySongId = Long.parseLong(songDelete);
        songRepository.deleteById(mySongId);

        return new RedirectView("/songs");
    }
}
