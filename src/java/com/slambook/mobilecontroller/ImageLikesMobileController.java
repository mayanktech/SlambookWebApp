/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.ImageLikes;
import com.slambook.Entity.ImageLikesMobile;
import com.slambook.services.Interfces.ImageLikesDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/mobile/ImageLikes")
public class ImageLikesMobileController {
    
    private ImageLikesDAOServiceInterface imageLikesDAOServiceInterface;
    
    @RequestMapping(value = "/addLike" ,method = RequestMethod.PUT)
    public @ResponseBody int addLike(@RequestBody ImageLikes imageLikes){
    
    return imageLikesDAOServiceInterface.addLike(imageLikes);
    
    }
    
    @RequestMapping(value = "/removeLike" ,method = RequestMethod.DELETE)
    public @ResponseBody int removeLike(@RequestBody ImageLikes imageLikes, BindingResult bindingResult){
    
    return imageLikesDAOServiceInterface.removeLike(imageLikes);
    
    }
    
    @RequestMapping(value = "/getImageLikes/{imageId}" ,method = RequestMethod.GET)
    @ResponseBody 
    public ResponseEntity <java.util.ArrayList<com.slambook.Entity.ImageLikesMobile>> getImageLikes(@PathVariable("imageId") int imageId,Model model){
    
        ArrayList <com.slambook.Entity.ImageLikes>imageLikesList = imageLikesDAOServiceInterface.getImageLikes(imageId);
        ArrayList <com.slambook.Entity.ImageLikesMobile>imageLikesMobileList = new ArrayList<ImageLikesMobile>();
        
        
        for(ImageLikes imageLikes : imageLikesList){
        
            ImageLikesMobile imageLikesMobile = new ImageLikesMobile();
            imageLikesMobile.setAlbumId(imageLikes.getAlbumId());
            imageLikesMobile.setCurrentProfilePic(imageLikes.getCurrentProfilePic());
            imageLikesMobile.setFriendId(imageLikes.getFriendId());
            imageLikesMobile.setFriendName(imageLikes.getFriendName());
            imageLikesMobile.setImageLikeId(imageLikes.getImageLikeId());
            imageLikesMobile.setUserId(imageLikes.getUserId());
            
            imageLikesMobileList.add(imageLikesMobile);
        
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<java.util.ArrayList<ImageLikesMobile>> ent = new ResponseEntity<java.util.ArrayList<ImageLikesMobile>>(imageLikesMobileList,headers,HttpStatus.OK);
        return ent;
        
        
    
    }
    
}
