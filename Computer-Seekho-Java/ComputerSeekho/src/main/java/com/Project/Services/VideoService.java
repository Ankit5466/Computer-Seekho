package com.Project.Services;

import java.util.List;
import com.Project.Entities.Video;

public interface VideoService {
    Video addVideo(Video v);
    List<Video> getAllVideos();
    void delete(int videoId);
    Boolean activateVideo(int videoId,Boolean videoIsActive);
}
