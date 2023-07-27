package com.songr.songr.repositories;

import com.songr.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {

    public Song deleteById(long id);

    public Song findById(long id );
}
