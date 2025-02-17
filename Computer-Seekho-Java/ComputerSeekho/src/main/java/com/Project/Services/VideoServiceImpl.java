package com.Project.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.Video;
import com.Project.Repositories.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepository;
    @Override
    public Video addVideo(Video v) {
 
        videoRepository.save(v);
        return v;
    }

    @Override
    public List<Video> getAllVideos() {
        
        return videoRepository.findAll();
    }

    @Override
    public void delete(int videoId) {
 
       videoRepository.deleteById(videoId);
    }

    @Override
    public Boolean activateVideo(int videoId, Boolean videoIsActive) {
        videoRepository.activateVideo(videoIsActive,videoId);
        return videoIsActive;
    }
    
}
