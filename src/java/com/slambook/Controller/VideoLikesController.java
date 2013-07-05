/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.VideoLikes;
import com.slambook.Entity.Videos;
import com.slambook.services.Interfces.VideoLikesDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/VideoLikes")
public class VideoLikesController {
    
    @Autowired
    private VideoLikesDAOServiceInterface videoLikesDAOServiceInterface;
    
    @RequestMapping(value = "/addVideoLike" ,method = RequestMethod.POST)
    public @ResponseBody int addVideoLike(@ModelAttribute("videoLike") VideoLikes videoLikes){
      
        Videos videos = new Videos();
        videos.setVideoId(videoLikes.getVideoId());
        
        videoLikes.setVideos(videos);
        
        return  videoLikesDAOServiceInterface.addLike(videoLikes);
    
    }
    
     @RequestMapping(value = "/removeVideoLike" ,method = RequestMethod.POST)
     public @ResponseBody int removeVideoLike(@ModelAttribute("videoLike") VideoLikes videoLikes){
      
        return  videoLikesDAOServiceInterface.removeLike(videoLikes);
    
    }
    
    @RequestMapping(value = "/addVideoLike/{videoId}" ,method = RequestMethod.GET) 
    public String getVideoLikes(@PathVariable("videoId") int videoId,Model model){
    
    ArrayList videoLikes =  videoLikesDAOServiceInterface.getVideoLikes(videoId);
    model.addAttribute("videoLikes", videoLikes);
    return "getVideoLikes";
    
    } 
}
