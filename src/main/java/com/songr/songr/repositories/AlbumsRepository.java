package com.songr.songr.repositories;


import com.songr.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

//Step 4: Create a repository that extends JPARespository
public interface AlbumsRepository extends JpaRepository<Album, Long> {

    //default -> dave(), delete(),update(), findAll()

    //Step 5: add Magic method declaration
    public Album findByTitle(String title);

    public Album deleteById(long id);
}
