/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.VideoLikes;
import com.slambook.repository.Interfaces.VideoLikesDAOInterface;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mayank
 */
@Repository
public class VideoLikesDAOImplementation implements VideoLikesDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public int addLike(VideoLikes videoLikes) {
        
        sessionFactory.getCurrentSession().save(videoLikes);
        
        return getVideoLikesCount(videoLikes.getVideoId());
        
    }

    @Override
    public int removeLike(VideoLikes videoLikes) {
       
        int videoId = videoLikes.getVideoLikeId();
        sessionFactory.getCurrentSession().delete(videoLikes);
        return getVideoLikesCount(videoId);
        
    }

    @Override
    public ArrayList getVideoLikes(int videoId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("VideoLikes.getVideoLikes");
        query.setInteger("videoId",videoId);
        return (ArrayList) query.list();
        
    }

    @Override
    public int getVideoLikesCount(int videoId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("VideoLikes.getVideoLikesCount");
        query.setInteger("videoId",videoId);
        return ((Long)(query.uniqueResult())).intValue();
       
    }

    @Override
    public int returnVideoLikesCount(int videoId) {
       Query query = sessionFactory.getCurrentSession().getNamedQuery("VideoLikes.getVideoLikesCount");
        query.setInteger("videoId",videoId);
        return (Integer) query.uniqueResult();
    }

    @Override
    public boolean isAlreadyLiked(int videoId, int userId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("VideoLikes.isAlreadyLiked");
        query.setInteger("videoId",videoId);
        query.setInteger("userId", userId);
        int i = query.list().size();
        
        if(i != 0){
        
            return true;
        
        }
        else{
        
            return false;
        
        }
        
    }
    
}
