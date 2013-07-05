/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Interfaces;

import com.slambook.Entity.ProfilePic;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface ProfilePicDAOInterface {
      
   public int addProfilePic(ProfilePic profilePic);
    public ArrayList getProfilePics(int userId);
     public int getCurrentProfilePic(int userId);
   
}
