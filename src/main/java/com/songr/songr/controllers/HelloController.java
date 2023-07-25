package com.songr.songr.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String sayHello(Model m){
        m.addAttribute("hello", "hello world");
        return "hello.html";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalize(Model m,
                             @PathVariable String word,
                             @RequestParam(required = false, defaultValue = "Nothing else was added")String added){

        m.addAttribute("word", word.toUpperCase());
        m.addAttribute("added", added);
        return "upperCase.html";

    }

    @GetMapping("/")
    public String splashPage(){
        return "splash.html";
    }

    @GetMapping("/album")
    public String albums(Model m ){
        Album album1 = new Album("The Queen is Dead", "The Smiths", 12, 70, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fclassicalbumsundays.com%2Falbum-of-the-month-the-smiths-the-queen-is-dead%2F&psig=AOvVaw3MkPmON8zhVsJg6ib1HFSP&ust=1690343454090000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCNif6pr6qIADFQAAAAAdAAAAABAE");
        Album album2 = new Album(" Purple Rain", "The Revolution", 10, 60, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.imdb.com%2Ftitle%2Ftt0087957%2F&psig=AOvVaw2kl0BstKDcijhOUPsLXFLB&ust=1690343598891000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCNC9_t_6qIADFQAAAAAdAAAAABAE");
        Album album3 = new Album("Straight outta Compton", "NWA", 10, 70, "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.discogs.com%2FVolTKKlpALZQmGwMnmZc6xKcwe6khDT9cn-JAi3vrzk%2Frs%3Afit%2Fg%3Asm%2Fq%3A40%2Fh%3A300%2Fw%3A300%2FczM6Ly9kaXNjb2dz%2FLWRhdGFiYXNlLWlt%2FYWdlcy9SLTEwMzY0%2FOC0xNjQyNDEyODMy%2FLTU0ODAuanBlZw.jpeg&tbnid=lWJxAnlfzQFRPM&vet=12ahUKEwii_oOY-6iAAxUBh-4BHS_fD08QMygBegUIARD0AQ..i&imgrefurl=https%3A%2F%2Fwww.discogs.com%2Fmaster%2F26117-NWA-Straight-Outta-Compton&docid=UbknU3I6gWWEtM&w=300&h=300&q=N.W.A.%20Straight%20Outta%20Compton&ved=2ahUKEwii_oOY-6iAAxUBh-4BHS_fD08QMygBegUIARD0AQ");

        m.addAttribute("Smiths", album1);
        m.addAttribute("Revolution", album2);
        m.addAttribute("NWA", album3);

        return "albums.html";

    }




}

class Album{
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;

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
}
