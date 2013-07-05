/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.VideoLikes;
import com.slambook.Entity.VideoLikesMobile;
import com.slambook.services.Interfces.VideoLikesDAOServiceInterface;
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

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/VideoLikes")
public class VideoLikesMobileController {
    
    @Autowired
    private VideoLikesDAOServiceInterface videoLikesDAOServiceInterface;
    
    @RequestMapping(value = "/addVideoLike" ,method = RequestMethod.PUT)
    public @ResponseBody int addVideoLike(@RequestBody VideoLikes videoLikes){
      
        return  videoLikesDAOServiceInterface.addLike(videoLikes);
    
    }
    
     @RequestMapping(value = "/removeVideoLike" ,method = RequestMethod.DELETE)
     public @ResponseBody int removeVideoLike(@RequestBody VideoLikes videoLikes){
      
        return  videoLikesDAOServiceInterface.removeLike(videoLikes);
    
    }
    
    @RequestMapping(value = "/getVideoLike/{videoId}" ,method = RequestMethod.GET) 
    @ResponseBody 
    public ResponseEntity <java.util.ArrayList<com.slambook.Entity.VideoLikesMobile>> getVideoLikes(@PathVariable("videoId") int videoId){
    
    ArrayList <com.slambook.Entity.VideoLikes>videoLikesList =  videoLikesDAOServiceInterface.getVideoLikes(videoId);
    ArrayList<com.slambook.Entity.VideoLikesMobile> videoLikesMobileList = new ArrayList<VideoLikesMobile>();
    
    for (VideoLikes videoLikes :videoLikesList){
    
    VideoLikesMobile videoLikesMobile = new VideoLikesMobile();
    videoLikesMobile.setCurrentProfilePic(videoLikes.getCurrentProfilePic());
    videoLikesMobile.setFriendId(videoLikes.getFriendId());
    videoLikesMobile.setFriendName(videoLikes.getFriendName());
    videoLikesMobile.setUserId(videoLikes.getUserId());
    videoLikesMobile.setVideoId(videoId);
    videoLikesMobile.setVideoLikeId(videoLikes.getVideoLikeId());
    videoLikesMobileList.add(videoLikesMobile);
    
    }
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    ResponseEntity<java.util.ArrayList<com.slambook.Entity.VideoLikesMobile>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.VideoLikesMobile>>(videoLikesMobileList,headers,HttpStatus.OK);
    return ent;
    
    } 
}
