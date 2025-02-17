package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.News;
import com.Project.Repositories.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {
    
    @Autowired
    private NewsRepository newsRepository;

   
    @Override
    public News saveImage(News news) {
        return newsRepository.save(news); 
    }

    @Override
    public List<News> getAllImages() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> getImageById(int id) {
        return newsRepository.findById(id);
    }

    @Override
    public void deleteImage(int id) {
        newsRepository.deleteById(id);
    }
}
