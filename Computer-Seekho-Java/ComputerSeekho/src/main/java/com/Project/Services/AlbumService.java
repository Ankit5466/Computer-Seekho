
package com.Project.Services;

import com.Project.Entities.Album;
import java.util.List;

public interface AlbumService {
    Album saveAlbum(Album album);
    List<Album> getAllAlbums();
    Album getAlbumById(int albumId);
    boolean updateAlbum(Album album);
    void deleteAlbum(int albumId);
}