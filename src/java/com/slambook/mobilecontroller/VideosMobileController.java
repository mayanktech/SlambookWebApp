/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.Videos;
import com.slambook.Entity.VideosMobile;
import com.slambook.services.Interfces.VideosDAOServiceInterface;
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
@RequestMapping("/mobile/Videos")
public class VideosMobileController {
    
    @Autowired
    private VideosDAOServiceInterface videosDAOServiceInterface;
    
    @RequestMapping(value = "/addVideo" ,method = RequestMethod.PUT)
    public @ResponseBody int addVideo(@RequestBody Videos videos){
    
     return videosDAOServiceInterface.addVideo(videos);
     
    }
    
    @RequestMapping(value = "/deleteVideo/{videoId}" ,method = RequestMethod.DELETE)
    public @ResponseBody int deleteVideo(@PathVariable("videoId") int videoId){
    
       return videosDAOServiceInterface.deleteVideo(videoId);
    
    }
    
     @RequestMapping(value = "/getVideos/{userId}/{clickTimes}" ,method = RequestMethod.GET)
     @ResponseBody 
     public ResponseEntity <java.util.ArrayList<com.slambook.Entity.VideosMobile>> getVideos(@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes){
     
     ArrayList <com.slambook.Entity.Videos>videosList = videosDAOServiceInterface.getVideos(userId, clickTimes);
     ArrayList <com.slambook.Entity.VideosMobile>videosMobileList = new ArrayList<VideosMobile>();
     
     for(Videos videos : videosList){
     
     VideosMobile videosMobile = new VideosMobile();
     videosMobile.setAlreadyLiked(videos.getAlreadyLiked());
     videosMobile.setUserId(userId);
     videosMobile.setVideoCommentsCount(videos.getVideoCommentsCount());
     videosMobile.setVideoDescription(videos.getVideoDescription());
     videosMobile.setVideoId(videos.getVideoId());
     videosMobile.setVideoLikesCount(videos.getVideoLikesCount());
     videosMobile.setVideoUrl(videos.getVideoUrl());
     videosMobileList.add(videosMobile);
     
     
     }
     
     HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<java.util.ArrayList<com.slambook.Entity.VideosMobile>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.VideosMobile>>(videosMobileList,headers,HttpStatus.OK);
        return ent;
     
         
     }
    
}
