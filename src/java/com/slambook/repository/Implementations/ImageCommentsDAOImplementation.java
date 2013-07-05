/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.ImageComments;
import com.slambook.repository.Interfaces.ImageCommentsDAOInterface;
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
public class ImageCommentsDAOImplementation implements ImageCommentsDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public ArrayList getImageComments(int imageId) {
       
        Query query = sessionFactory.getCurrentSession().getNamedQuery("ImageComments.getImageComments");
        query.setInteger("imageId", imageId);
        return (ArrayList) query.list();
        
        
    }

    @Override
    public void addImageComments(ImageComments imageComments) {
        sessionFactory.getCurrentSession().save(imageComments);
    }

    @Override
    public int getImageCommentsCount(int imageId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("ImageComments.getImageCommentsCount");
        query.setInteger("imageId", imageId);
        return ((Long)query.uniqueResult()).intValue();
    }
    
}
