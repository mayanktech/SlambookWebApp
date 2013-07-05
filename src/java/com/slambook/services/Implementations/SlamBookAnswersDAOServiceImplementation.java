/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.SlamBookAnswers;
import com.slambook.Entity.UserInfo;
import com.slambook.repository.Interfaces.SlamBookAnswersDAOInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
import com.slambook.services.Interfces.SlamBookAnswersDAOServiceInterface;
import com.slambook.services.Interfces.UserInfoDAOServiceInterface;
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
public class SlamBookAnswersDAOServiceImplementation implements SlamBookAnswersDAOServiceInterface{

    @Autowired
    private SlamBookAnswersDAOInterface slamBookAnswersDAOInterface;
    
    @Autowired
    private ProfilePicDAOServiceInterface profilePicDAOServiceInterface;
    
    @Autowired
    private UserInfoDAOServiceInterface userInfoDAOServiceInterface;
    
    @Override
    public void addAnswers(SlamBookAnswers slamBookAnswers) {
       
        slamBookAnswersDAOInterface.addAnswers(slamBookAnswers);
    }

    @Override
    public ArrayList userFriendsAnswers(int userId) {
        
       ArrayList <com.slambook.Entity.SlamBookAnswers>userFriendsAnswersList = slamBookAnswersDAOInterface.userFriendsAnswers(userId);
       ArrayList <com.slambook.Entity.SlamBookAnswers>userFriendsAnswers = new ArrayList<SlamBookAnswers>();
        
       
       for(SlamBookAnswers slamBookAnswers: userFriendsAnswersList){
       
       
           UserInfo userInfo = userInfoDAOServiceInterface.getUser(slamBookAnswers.getSenderId());
           
           slamBookAnswers.setCurrentProfilePic(profilePicDAOServiceInterface.getCurrentProfilePic(slamBookAnswers.getSenderId()));
           slamBookAnswers.setName(userInfo.getFirstName()+" "+userInfo.getLastName());
           
           userFriendsAnswers.add(slamBookAnswers);
       
       }
       
       return userFriendsAnswers;
        
    }

    @Override
    public SlamBookAnswers previewFriendAnswers(int userId, int friendId) {
      
        return slamBookAnswersDAOInterface.previewFriendAnswers(userId, friendId);
    }

    @Override
    public SlamBookAnswers getSingleFriendsAnswers(int userId, int friendId) {
       
        return slamBookAnswersDAOInterface.getSingleFriendsAnswers(userId, friendId);
        
    }
    
    
    
}
