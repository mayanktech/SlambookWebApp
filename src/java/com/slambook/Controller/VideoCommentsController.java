/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.VideoComments;
import com.slambook.Entity.Videos;
import com.slambook.services.Interfces.VideoCommentsDAOServiceInterface;
import com.slambook.services.Interfces.VideosDAOServiceInterface;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/VideoComments")

public class VideoCommentsController {
   
    @Autowired
    private VideoCommentsDAOServiceInterface videoCommentsDAOServiceInterface;
    
    @Autowired
    private VideosDAOServiceInterface videosDAOServiceInterface;
    
    @RequestMapping(value = "/addVideoComment")
    public @ResponseBody int addVideoComment(@ModelAttribute("videoComments") VideoComments videoComments){
        
        Videos videos = new Videos();
        videos.setVideoId(videoComments.getVideoId());
        
        videoComments.setDate(new Date());
        videoComments.setVideos(videos);
        
        videoCommentsDAOServiceInterface.addVideoComments(videoComments);
        return videoComments.getCommentId();
        
    }
    
    @RequestMapping("/getVideoComments/{videoId}")
    public String getVideoComments(@PathVariable("videoId") int videoId,Model model){
    
    ArrayList videoCommentsList = videoCommentsDAOServiceInterface.getVideoComments(videoId);
    model.addAttribute("videoCommentsList", videoCommentsList);
    model.addAttribute("videoCode",videosDAOServiceInterface.getYoutubeVideoCode(videoId));
    return "VideoComments";
    
    }
 }
    
