/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.Videos;
import com.slambook.repository.Interfaces.VideosDAOInterface;
import com.slambook.services.Interfces.VideoCommentsDAOServiceInterface;
import com.slambook.services.Interfces.VideoLikesDAOServiceInterface;
import com.slambook.services.Interfces.VideosDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mayank
 */
@Service
@Transactional
public class VideosDAOServiceImplementation implements VideosDAOServiceInterface{

    @Autowired
    private VideosDAOInterface videosDAOInterface;
    
    @Autowired
    private VideoCommentsDAOServiceInterface videoCommentsDAOServiceInterface;
    
    @Autowired
    private VideoLikesDAOServiceInterface videoLikesDAOServiceInterface;
    
    @Override
    public ArrayList getVideos(int userId, int clickTimes) {
    
        ArrayList <com.slambook.Entity.Videos>videoList =  videosDAOInterface.getVideos(userId, clickTimes);
        
        for( Videos videos : videoList){
        
            videos.setAlreadyLiked(videoLikesDAOServiceInterface.isAlreadyLiked(videos.getVideoId(), userId));
            videos.setVideoLikesCount(videoLikesDAOServiceInterface.getVideoLikesCount(videos.getVideoId()));
            videos.setVideoCommentsCount(videoCommentsDAOServiceInterface.getVideoCommentsCount(videos.getVideoId()));
        }
        
        return videoList;
        
    }

    @Override
    public int addVideo(Videos video) {
       
        return videosDAOInterface.addVideo(video);
    }

    @Override
    public void updateVideo(Videos video) {
      
        videosDAOInterface.updateVideo(video);
    }

    @Override
    public int deleteVideo(int videoId) {
       return videosDAOInterface.deleteVideo(videoId);
    }

    @Override
    public String getYoutubeVideoId(String youtubeUrl) {
       
        return videosDAOInterface.getYoutubeVideoId(youtubeUrl);
    }

    @Override
    public String getYoutubeVideoCode(int videoId) {
       
        return videosDAOInterface.getYoutubeVideoCode(videoId);
    }

    @Override
    public String getVideoDescription(int videoId) {
        
        return videosDAOInterface.getVideoDescription(videoId);
    }
    
}
