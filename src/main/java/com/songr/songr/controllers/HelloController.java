package com.songr.songr.controllers;


import com.songr.songr.models.Album;
import com.songr.songr.repositories.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    AlbumsRepository albumsRepository;


    @GetMapping("/hello")
    public String sayHello(Model m) {
        m.addAttribute("hello", "hello world");
        return "hello.html";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalize(Model m,
                             @PathVariable String word,
                             @RequestParam(required = false, defaultValue = "Nothing else was added") String added) {

        m.addAttribute("word", word.toUpperCase());
        m.addAttribute("added", added);
        return "upperCase.html";

    }

    @GetMapping("/")
    public String splashPage() {
        return "splash.html";
    }

    @GetMapping("/album")
    public String albums(Model m) {

        List<Album> myAlbums = albumsRepository.findAll();
        m.addAttribute("albums", myAlbums);

        return "albums.html";

    }

    @PostMapping("/addAlbum")
    public RedirectView addStoreFromForm(String title, String artist, String length, String songCount, String imageUrl){
        Album newAlbum = new Album(title,artist, Integer.parseInt(songCount) , Integer.parseInt(length),imageUrl);
        albumsRepository.save(newAlbum);

        return new RedirectView("/");
    }

    @PostMapping("/deleteAlbum")
    public RedirectView deleteAlbum(String albumDelete){
        Long myId = Long.parseLong(albumDelete);
        albumsRepository.deleteById(myId);

        return new RedirectView("/");
    }


}

