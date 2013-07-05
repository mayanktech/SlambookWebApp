/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.ImageComments;
import com.slambook.Entity.ImageCommentsMobile;
import com.slambook.services.Interfces.ImageCommentsDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/ImageComments")
public class ImageCommentsMobileController {
    
    @Autowired
    ImageCommentsDAOServiceInterface imageCommentsDAOServiceInterface;
    
    @RequestMapping(value="/getImageComments/{imageId}",method = RequestMethod.GET)
    @ResponseBody
    public  ResponseEntity <java.util.ArrayList<com.slambook.Entity.ImageCommentsMobile>> getImageComments(@PathVariable("imageId") int imageId){
    
    ArrayList <com.slambook.Entity.ImageComments>imageCommentList = imageCommentsDAOServiceInterface.getImageComments(imageId);
    ArrayList <com.slambook.Entity.ImageCommentsMobile> imageCommentsMobilesList = new ArrayList<ImageCommentsMobile>();
    
    for(ImageComments imageComments:imageCommentList){
    
    ImageCommentsMobile imageCommentsMobile = new ImageCommentsMobile();
    imageCommentsMobile.setAlbumId(imageComments.getAlbumId());
    imageCommentsMobile.setCommentId(imageComments.getCommentId());
    imageCommentsMobile.setCommentText(imageComments.getCommentText());
    imageCommentsMobile.setCommenterId(imageComments.getCommenterId());
    imageCommentsMobile.setCurrentProfilePicId(imageComments.getCurrentProfilePicId());
    imageCommentsMobile.setDate(imageComments.getDate());
    imageCommentsMobile.setImageId(imageId);
    imageCommentsMobile.setName(imageComments.getName());
    imageCommentsMobile.setUserId(imageComments.getUserId());
    imageCommentsMobilesList.add(imageCommentsMobile);
    
    
    }
    HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<java.util.ArrayList<com.slambook.Entity.ImageCommentsMobile>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.ImageCommentsMobile>>(imageCommentsMobilesList,headers,HttpStatus.OK);
        return ent;
    }
    
     @RequestMapping(value = "/addImageComment" ,method = RequestMethod.PUT)
     public @ResponseBody int addImageComment(@RequestBody ImageComments imageComments){
     
     imageCommentsDAOServiceInterface.addImageComments(imageComments);
     return imageComments.getCommentId();
         
     }
     
     
    
}
