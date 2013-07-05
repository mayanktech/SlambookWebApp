/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.Album;
import com.slambook.Entity.ImageLikes;
import com.slambook.Entity.Images;
import com.slambook.repository.Interfaces.ImageLikesDAOInterface;
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
public class ImageLikesDAOImplementation implements ImageLikesDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public int addLike(ImageLikes imageLikes) {
        
        sessionFactory.getCurrentSession().save(imageLikes);
        
        return getImageLikesCount(imageLikes.getImageId()); 
        
        
    }

    @Override
    public int removeLike(ImageLikes imageLikes) {
     
        Query query = sessionFactory.getCurrentSession().getNamedQuery("ImageLikes.removeLike");
        query.setInteger("imageId",imageLikes.getImageId());
        query.setInteger("userId", imageLikes.getUserId());
        query.executeUpdate();
        return getImageLikesCount(imageLikes.getImageId()); 
    }

    @Override
    public ArrayList getImageLikes(int imageId) {
        
     Query query = sessionFactory.getCurrentSession().getNamedQuery("ImageLikes.getImageLikes");
     query.setInteger("imageId",imageId);
     return  (ArrayList) query.list();
     
        
    }

    @Override
    public int getImageLikesCount(int imageId) {
     
     Query query = sessionFactory.getCurrentSession().getNamedQuery("ImageLikes.getImageLikesCount");
     query.setInteger("imageId",imageId);
     return ((Long)query.uniqueResult()).intValue();
    }

    @Override
    public int returnImageLikesCount(int imageId) {
     Query query = sessionFactory.getCurrentSession().getNamedQuery("ImageLikes.getImageLikesCount");
     query.setInteger("imageId",imageId);
     return (Integer)query.uniqueResult();
    }

    @Override
    public boolean isAlreadyLiked(int imageId, int userId) {
     Boolean alreadyLiked = Boolean.FALSE;
     Query query = sessionFactory.getCurrentSession().getNamedQuery("ImageLikes.isAlreadyLiked");
     query.setInteger("imageId",imageId);
     query.setInteger("userId",userId);
     if(query.uniqueResult() != null){
     
     alreadyLiked = Boolean.TRUE;
         
     }
     return alreadyLiked;
     
    }
    
}
