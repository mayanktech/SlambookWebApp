/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.VideoComments;
import com.slambook.Entity.VideoCommentsMobile;
import com.slambook.services.Interfces.VideoCommentsDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/VideoComments")

public class VideoCommentsMobileController {
   
    @Autowired
    private VideoCommentsDAOServiceInterface videoCommentsDAOServiceInterface;
    
    @RequestMapping(value = "/addVideoComment")
    public @ResponseBody int addVideoComment(@RequestBody VideoComments videoComments){
        
        videoCommentsDAOServiceInterface.addVideoComments(videoComments);
        return videoComments.getCommentId();
        
    }
    
    @RequestMapping("/getVideoComments/{videoId}")
    @ResponseBody
    public  ResponseEntity <java.util.ArrayList<com.slambook.Entity.VideoCommentsMobile>> getVideoComments(@PathVariable("videoId") int videoId){
    
    ArrayList <com.slambook.Entity.VideoComments>videoCommentsList = videoCommentsDAOServiceInterface.getVideoComments(videoId);
    ArrayList<com.slambook.Entity.VideoCommentsMobile> videoCommentsMobilesList = new ArrayList<VideoCommentsMobile>();
    
    for( VideoComments videoComments : videoCommentsList){
    
    VideoCommentsMobile videoCommentsMobile = new VideoCommentsMobile();
    videoCommentsMobile.setCommentDate(videoComments.getCommentDate());
    videoCommentsMobile.setCommentId(videoComments.getCommentId());
    videoCommentsMobile.setCommentText(videoComments.getCommentText());
    videoCommentsMobile.setCommenterId(videoComments.getCommenterId());
    videoCommentsMobile.setCurrentProfilePicId(videoComments.getCurrentProfilePicId());
    videoCommentsMobile.setName(videoComments.getName());
    videoCommentsMobile.setUserId(videoComments.getUserId());
    videoCommentsMobile.setVideoId(videoId);
    videoCommentsMobilesList.add(videoCommentsMobile);
    
    }
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    ResponseEntity<java.util.ArrayList<com.slambook.Entity.VideoCommentsMobile>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.VideoCommentsMobile>>(videoCommentsMobilesList,headers,HttpStatus.OK);
        
    return ent;
    
    }
 }
    
