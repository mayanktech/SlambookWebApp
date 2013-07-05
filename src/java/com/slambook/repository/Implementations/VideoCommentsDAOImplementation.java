/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.VideoComments;
import com.slambook.repository.Interfaces.VideoCommentsDAOInterface;
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
public class VideoCommentsDAOImplementation implements VideoCommentsDAOInterface {

    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void addVideoComments(VideoComments videoComments) {
        
        sessionFactory.getCurrentSession().save(videoComments);
        
    }

    @Override
    public ArrayList getVideoComments(int videoId) {
       Query query = sessionFactory.getCurrentSession().getNamedQuery("VideoComments.getVideoComments");
        query.setInteger("videoId",videoId);
        return (ArrayList) query.list();
    }

    @Override
    public int getVideoCommentsCount(int videoId) {
       Query query = sessionFactory.getCurrentSession().getNamedQuery("VideoComments.getVideoCommentsCount");
        query.setInteger("videoId",videoId);
        return ((Long)(query.uniqueResult())).intValue();
    }
    
}
