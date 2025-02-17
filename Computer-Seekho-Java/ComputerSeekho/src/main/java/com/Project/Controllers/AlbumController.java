package com.Project.Controllers;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.Album;
import com.Project.Services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/add")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        Album savedAlbum = albumService.saveAlbum(album);
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") int albumId) {
        Album album = albumService.getAlbumById(albumId);
        return album != null ? new ResponseEntity<>(album, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAlbum(@PathVariable("id") int albumId, @RequestBody Album albumDetails) {
        if(albumService.updateAlbum(albumDetails)){
            return new ResponseEntity<>(new ApiResponse("Album updated successfully",LocalDateTime.now()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse("Album not found",LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteAlbum(@PathVariable("id") int albumId) {
        albumService.deleteAlbum(albumId);
        return new ResponseEntity<>(new ApiResponse("Deleted Successfully",LocalDateTime.now()),HttpStatus.OK);
    }
}