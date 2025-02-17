package com.Project.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.Image;
import com.Project.Services.ImageServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/image")
public class ImageController {
    
        @Autowired
        private ImageServiceImpl imageService;
    
        @PostMapping("/add")
        public ResponseEntity<ApiResponse> uploadImage(@RequestBody Image image) {
           imageService.saveImage(image); 
            return new ResponseEntity<>( new ApiResponse("Image Uploaded Successfully", LocalDateTime.now()),HttpStatus.CREATED);
           
        }
    
        @GetMapping("/all")
        public ResponseEntity<List<Image>> getAllImages() {
            List<Image> images = imageService.getAllImages();
            return new ResponseEntity<>(images,HttpStatus.CREATED);
        }
        
        @GetMapping("/get/{id}")
        public ResponseEntity<Image> getImageById(@PathVariable Integer id) 
        {
            Optional<Image> image = imageService.getImageById(id);
            return image.map( value -> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<ApiResponse> deleteImage(@PathVariable int id)
        {
            imageService.deleteImage(id);
            return new ResponseEntity<>(new ApiResponse("image deleted successfully", LocalDateTime.now()),HttpStatus.OK);
        }

        // @GetMapping("/album/{id}")
        // public ResponseEntity<List<Image>> getImagesByAlbum(@PathVariable int id)
        // {
        //     List<Image> images = imageService.getbyAlbum(id);
        //     return new ResponseEntity<>(images,HttpStatus.OK);
        // }

}
