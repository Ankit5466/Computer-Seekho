package com.Project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image , Integer>{
    // @Query("select i from Image i where i.album_id = ?1")
    // List<Image> findByAlbumId(int album_id);

}