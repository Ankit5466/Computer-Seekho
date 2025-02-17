package com.Project.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.News;
import com.Project.Services.NewsService;
import com.Project.Services.NewsServiceImpl;

@RestController
@RequestMapping("/News")
public class NewsController {

    @Autowired
    private NewsServiceImpl newsService; // Fixed naming

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addNews(@RequestBody News news) { // Renamed method for clarity
        newsService.saveImage(news);
        return new ResponseEntity<>(new ApiResponse("Image Uploaded Successfully", LocalDateTime.now()), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<News>> getAllImages() {
        List<News> images = newsService.getAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK); // Fixed status code
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<News> getImageById(@PathVariable Integer id) {
        Optional<News> image = newsService.getImageById(id);
        return image.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteImage(@PathVariable int id) {
        newsService.deleteImage(id);
        return new ResponseEntity<>(new ApiResponse("Image deleted successfully", LocalDateTime.now()), HttpStatus.OK);
    }
}
