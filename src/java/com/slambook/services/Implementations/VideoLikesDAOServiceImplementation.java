/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.VideoLikes;
import com.slambook.repository.Interfaces.VideoLikesDAOInterface;
import com.slambook.services.Interfces.VideoLikesDAOServiceInterface;
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
public class VideoLikesDAOServiceImplementation implements VideoLikesDAOServiceInterface{

    @Autowired
    private VideoLikesDAOInterface videoLikesDAOInterface;
    
    @Override
    public int addLike(VideoLikes videoLikes) {
       
        return videoLikesDAOInterface.addLike(videoLikes);
    }

    @Override
    public int removeLike(VideoLikes videoLikes) {
       
        return videoLikesDAOInterface.removeLike(videoLikes);
    }

    @Override
    public ArrayList getVideoLikes(int videoId) {
       
        return videoLikesDAOInterface.getVideoLikes(videoId);
    }

    @Override
    public int getVideoLikesCount(int videoId) {
       
        return videoLikesDAOInterface.getVideoLikesCount(videoId);
    }

    @Override
    public int returnVideoLikesCount(int videoId) {
       
        return videoLikesDAOInterface.returnVideoLikesCount(videoId);
    }

    @Override
    public boolean isAlreadyLiked(int videoId, int userId) {
       
        return videoLikesDAOInterface.isAlreadyLiked(videoId, userId);
    }
    
}
