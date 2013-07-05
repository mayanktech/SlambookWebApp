/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.Album;
import com.slambook.Entity.ImageLikes;
import com.slambook.Entity.Images;
import com.slambook.services.Interfces.ImageLikesDAOServiceInterface;
import java.util.ArrayList;
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
@RequestMapping("/ImageLikes")
public class ImageLikesController {
    
    @Autowired
    private ImageLikesDAOServiceInterface imageLikesDAOServiceInterface;
    
    @RequestMapping(value = "/addLike" ,method = RequestMethod.POST)
    public @ResponseBody int addLike(@ModelAttribute("imageLikes") ImageLikes imageLikes, BindingResult bindingResult){
    
       
       Images images = new Images();
       images.setImageId(imageLikes.getImageId());
       
       imageLikes.setImages(images);
      
       return imageLikesDAOServiceInterface.addLike(imageLikes);
        
    }
    
    @RequestMapping(value = "/removeLike" ,method = RequestMethod.POST)
    public @ResponseBody int removeLike(@ModelAttribute("imageLikes") ImageLikes imageLikes, BindingResult bindingResult){
    
       Images images = new Images();
       images.setImageId(imageLikes.getImageId());
       
       imageLikes.setImages(images);
      
        return imageLikesDAOServiceInterface.removeLike(imageLikes);
    
    }
    
    @RequestMapping(value = "/getImageLikes/{imageId}" ,method = RequestMethod.POST)
    public String getImageLikes(@PathVariable("imageId") int imageId,Model model){
    
        ArrayList imageLikesList = imageLikesDAOServiceInterface.getImageLikes(imageId);
        model.addAttribute("imageLikes", imageLikesList);
        return "getImageLikes";
    
    }
    
}
