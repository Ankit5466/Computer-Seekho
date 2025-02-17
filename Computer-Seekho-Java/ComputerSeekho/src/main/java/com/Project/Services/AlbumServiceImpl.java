package com.Project.Services;

import com.Project.Entities.Album;
import com.Project.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album getAlbumById(int albumId) {
        return albumRepository.findById(albumId).orElse(null);
    }

    @Override
    public boolean updateAlbum(Album album) {
        Album existingAlbum = albumRepository.findById(album.getAlbumId()).get();
        if(existingAlbum != null) {
            albumRepository.save(album);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAlbum(int albumId) {
        albumRepository.deleteById(albumId);
    }
}



