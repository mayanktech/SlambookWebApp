/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Interfaces;

import com.slambook.Entity.Videos;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface VideosDAOInterface {
    
     public ArrayList getVideos(int userId,int clickTimes);
     public int addVideo(Videos video);
     public void updateVideo(Videos video);
     public int deleteVideo(int videoId);
     public String getYoutubeVideoId(String youtubeUrl);
     public String getYoutubeVideoCode(int videoId);
     public String getVideoDescription(int videoId);
    
}
