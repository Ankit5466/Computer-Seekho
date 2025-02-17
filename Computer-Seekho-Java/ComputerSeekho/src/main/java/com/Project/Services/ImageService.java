package com.Project.Services;

import java.util.List;
import java.util.Optional;
import com.Project.Entities.Image;

import org.springframework.stereotype.Service;

@Service
public interface ImageService {
    public List<Image> getAllImages();
    public Image saveImage(Image image);
    public Optional<Image> getImageById(int id);
    public void deleteImage(int id);
    // public List<Image> getbyAlbum(int id);
}
