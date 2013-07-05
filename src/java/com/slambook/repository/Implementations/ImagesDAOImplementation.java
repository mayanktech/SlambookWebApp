/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.Images;
import com.slambook.repository.Interfaces.ImagesDAOInterface;
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
public class ImagesDAOImplementation implements ImagesDAOInterface {

    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public int addImage(Images image) {
        
        sessionFactory.getCurrentSession().save(image);
        return image.getImageId();
        
    }

    @Override
    public void updateImage(Images image) {
        
        sessionFactory.getCurrentSession().update(image);
        
    }

    @Override
    public int deleteAllImagesFromAlbum(int albumId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteImage(int imageId) {
        
        Images image = (Images) sessionFactory.getCurrentSession().get(Images.class, imageId);
        sessionFactory.getCurrentSession().delete(image);
        return 0; 
    }

    @Override
    public ArrayList getImages(int albumId, int userId, int clickTimes) {
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Images.getImages");
        query.setInteger("albumId",albumId);
        
        return (ArrayList) query.list();
        
        
    }

    @Override
    public int getImageAlbumId(int imageId) {
       Query query = sessionFactory.getCurrentSession().getNamedQuery("Images.getImageAlbumId");
        query.setInteger("imageId",imageId);
        int imageAlbumId = (Integer)query.uniqueResult();
        return imageAlbumId;
     
    }

    @Override
    public void deleteImages(int userId, int albumId, String[] imageIds) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
