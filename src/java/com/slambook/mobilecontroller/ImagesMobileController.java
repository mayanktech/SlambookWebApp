/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.ImageMobile;
import com.slambook.Entity.Images;
import com.slambook.services.Interfces.ImagesDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/Images")

public class ImagesMobileController {
   
   @Autowired 
   private ImagesDAOServiceInterface imagesDAOServiceInterface;
   
   @RequestMapping(value = "/addImage" ,method = RequestMethod.PUT)
   public @ResponseBody int addImage(@RequestBody Images image){
   
   return imagesDAOServiceInterface.addImage(image);
   
   }
   
    @RequestMapping(value = "/updateImage" ,method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
   public void updateImage(@RequestBody Images image){
   
   imagesDAOServiceInterface.updateImage(image);
   
   }
    
    
   @RequestMapping(value = "/deleteImage/{imageId}" ,method = RequestMethod.DELETE)
   public @ResponseBody int deleteImage(@PathVariable("imageId") int imageId){
   
   return imagesDAOServiceInterface.deleteImage(imageId);
   
   }
   
   @RequestMapping(value = "/getImages/{albumId}/{userId}/{clickTimes}" ,method = RequestMethod.GET)
   @ResponseBody 
   public ResponseEntity <java.util.ArrayList<com.slambook.Entity.ImageMobile>> getImages(@PathVariable("albumId") int albumId,@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes){
       
    ArrayList <com.slambook.Entity.Images>imagesList =  imagesDAOServiceInterface.getImages(albumId, userId, clickTimes);
    ArrayList<com.slambook.Entity.ImageMobile> imageMobiles = new ArrayList<ImageMobile>();
    
    for(Images images : imagesList ){
    
      ImageMobile imageMobile = new ImageMobile();
      imageMobile.setAlbumId(albumId);
      imageMobile.setAlreadyLiked(images.getAlreadyLiked());
      imageMobile.setImageCommentCount(images.getImageCommentCount());
      imageMobile.setImageDescription(images.getImageDescription());
      imageMobile.setImageId(images.getImageId());
      imageMobile.setImageLikesCount(images.getImageLikesCount());
      
      imageMobiles.add(imageMobile);
      
    }
    
    HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<java.util.ArrayList<com.slambook.Entity.ImageMobile>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.ImageMobile>>(imageMobiles,headers,HttpStatus.OK);
        return ent;
   
   }
   
   
}
