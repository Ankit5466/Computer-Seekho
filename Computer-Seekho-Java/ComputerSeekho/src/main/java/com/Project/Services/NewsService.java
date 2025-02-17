package com.Project.Services;

import java.util.List;
import java.util.Optional;
import com.Project.Entities.News;

import org.springframework.stereotype.Service;

@Service
public interface NewsService {
    public List<News> getAllImages();
    public News saveImage(News image);
    public Optional<News> getImageById(int id);
    public void deleteImage(int id);
    // public List<Image> getbyAlbum(int id);
}
