/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.UserInfo;
import com.slambook.Entity.VideoComments;
import com.slambook.repository.Interfaces.VideoCommentsDAOInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
import com.slambook.services.Interfces.UserInfoDAOServiceInterface;
import com.slambook.services.Interfces.VideoCommentsDAOServiceInterface;
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
public class VideoCommentsDAOServiceImplementation implements VideoCommentsDAOServiceInterface{

    @Autowired
    private VideoCommentsDAOInterface videoCommentsDAOInterface;
    
    @Autowired
    private ProfilePicDAOServiceInterface profilePicDAOServiceInterface;
    
    @Autowired 
    private UserInfoDAOServiceInterface userInfoDAOServiceInterface;
    
    @Override
    public void addVideoComments(VideoComments videoComments) {
       
        videoCommentsDAOInterface.addVideoComments(videoComments);
    }

    @Override
    public ArrayList getVideoComments(int videoId) {
       
        ArrayList <com.slambook.Entity.VideoComments>videoCommentsList = videoCommentsDAOInterface.getVideoComments(videoId);
        
        for(VideoComments videoComments :videoCommentsList){
        
            videoComments.setCurrentProfilePicId(profilePicDAOServiceInterface.getCurrentProfilePic(videoComments.getCommenterId()));
            UserInfo userInfo = userInfoDAOServiceInterface.getUser(videoComments.getCommenterId());
            videoComments.setName(userInfo.getFirstName()+" "+userInfo.getLastName());
        }
        return videoCommentsList;
    }

    @Override
    public int getVideoCommentsCount(int videoId) {
        
        return videoCommentsDAOInterface.getVideoCommentsCount(videoId);
    }
    
}
