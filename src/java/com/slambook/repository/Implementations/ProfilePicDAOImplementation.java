/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.ProfilePic;
import com.slambook.repository.Interfaces.ProfilePicDAOInterface;
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
public class ProfilePicDAOImplementation implements ProfilePicDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public int addProfilePic(ProfilePic profilePic) {
        
        sessionFactory.getCurrentSession().save(profilePic);
        return profilePic.getProfilePicId();
        
    }

    @Override
    public ArrayList getProfilePics(int userId) {
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("ProfilePic.getProfilePics");
        query.setInteger("userId",userId);
        return (ArrayList) query.list();
    }

    @Override
    public int getCurrentProfilePic(int userId) {
       
        int CurrentProfilePicId = 0;
        Query query = sessionFactory.getCurrentSession().getNamedQuery("ProfilePic.getCurrentProfilePic");
        query.setInteger("userId",userId);
         Integer RealCurrentProfilePicId = 0;
         if(!query.list().isEmpty()){   
         RealCurrentProfilePicId = (Integer)query.list().get(0);
         }
        
        
        
        CurrentProfilePicId = RealCurrentProfilePicId;
        
        
        return CurrentProfilePicId;
     
    }
    
}
