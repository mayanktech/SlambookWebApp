/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.ProfilePic;
import com.slambook.repository.Interfaces.ProfilePicDAOInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
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
public class ProfilePicDAOServiceImplementation implements ProfilePicDAOServiceInterface{

    @Autowired
    private ProfilePicDAOInterface profilePicDAOInterface;
    
    @Override
    public int addProfilePic(ProfilePic profilePic) {
       
        return profilePicDAOInterface.addProfilePic(profilePic);
    }

    @Override
    public ArrayList getProfilePics(int userId) {
       
        return profilePicDAOInterface.getProfilePics(userId);
    }

    @Override
    public int getCurrentProfilePic(int userId) {
      
        return profilePicDAOInterface.getCurrentProfilePic(userId);
    }
    
}
