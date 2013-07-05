/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.ImageComments;
import com.slambook.Entity.Images;
import com.slambook.services.Interfces.ImageCommentsDAOServiceInterface;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/ImageComments")
public class ImageCommentsController {
    
    @Autowired
    ImageCommentsDAOServiceInterface imageCommentsDAOServiceInterface;
    
    @RequestMapping("/getImageComments/{albumId}/{imageId}")
    public String getImageComments(@PathVariable("imageId") int imageId,@PathVariable("albumId") int albumId,Model model){
    
    ArrayList imageCommentList = imageCommentsDAOServiceInterface.getImageComments(imageId);
    model.addAttribute("imageComments", imageCommentList);
    model.addAttribute("älbumId",albumId);
    model.addAttribute("imageId",imageId);
    return "ImageComments";
    
    }
    
    @RequestMapping("/getFriendsImageComments/{albumId}/{imageId}/{friendId}")
    public String getFriendsImageComments(@PathVariable("imageId") int imageId,@PathVariable("albumId") int albumId,@PathVariable("friendId") int friendId,Model model){
    
    ArrayList imageCommentList = imageCommentsDAOServiceInterface.getImageComments(imageId);
    model.addAttribute("imageComments", imageCommentList);
    model.addAttribute("älbumId",albumId);
    model.addAttribute("imageId",imageId);
    model.addAttribute("friendId",friendId);
    return "FriendImageComments";
    
    }
    
     @RequestMapping(value = "/addImageComment" ,method = RequestMethod.POST)
     public @ResponseBody int addImageComment(@ModelAttribute("imageComments") ImageComments imageComments,BindingResult bindingResult){
     
     Images images = new Images();
     images.setImageId(imageComments.getImageId());
     
     imageComments.setImages(images);
     imageComments.setDate(new Date());
         
     imageCommentsDAOServiceInterface.addImageComments(imageComments);
     return imageComments.getCommentId();
         
     }
     
     
    
}
