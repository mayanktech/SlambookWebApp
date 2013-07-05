/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.UserInfo;
import com.slambook.Entity.UserInfoMobile;
import com.slambook.repository.Interfaces.UserInfoDAOInterface;
import com.slambook.services.Interfces.UserInfoDAOServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mayank
 */
@Service
@Transactional
public class UserInfoDAOServiceImplementation implements UserInfoDAOServiceInterface{

    @Autowired
    private UserInfoDAOInterface userInfoDAOInterface;
    @Override
    public UserInfo getUser(int userId) {
        
        return userInfoDAOInterface.getUser(userId);
    }

    @Override
    public int addUser(UserInfo user) {
       
        int userId = userInfoDAOInterface.addUser(user);
        return userId;
    }

    @Override
    public String updateUser(UserInfo user) {
       
        return userInfoDAOInterface.updateUser(user);
    }

    @Override
    public void deleteUser(UserInfo user) {
       
        userInfoDAOInterface.deleteUser(user);
    }

    @Override
    public String getUserEmailById(int userId) {
      return userInfoDAOInterface.getUserEmailById(userId);
    }

    @Override
    public int getUserIdByEmail(String email) {
       
        return userInfoDAOInterface.getUserIdByEmail(email);
    }

    @Override
    public boolean isAFriend(int userId, int friendId) {
      
        return userInfoDAOInterface.isAFriend(userId, friendId);
    }

    @Override
    public UserInfoMobile getUserInfo(int userId) {
        
        UserInfo userInfo =  userInfoDAOInterface.getUserInfo(userId);
        UserInfoMobile userInfoMobile = new UserInfoMobile();
        userInfoMobile.setAccountStatus(userInfo.getAccountStatus());
        userInfoMobile.setBirthday(userInfo.getBirthday());
        userInfoMobile.setBraggingRights(userInfo.getBraggingRights());
        userInfoMobile.setCollege(userInfo.getCollege());
        userInfoMobile.setEmail(userInfo.getEmail());
        userInfoMobile.setFirstName(userInfo.getFirstName());
        userInfoMobile.setGender(userInfo.getGender());
        userInfoMobile.setIntroduction(userInfo.getIntroduction());
        userInfoMobile.setLastName(userInfo.getLastName());
        userInfoMobile.setLookingFor(userInfo.getLookingFor());
        userInfoMobile.setOccupation(userInfo.getOccupation());
        userInfoMobile.setPassword(userInfo.getPassword());
        userInfoMobile.setPlacesLived(userInfo.getPlacesLived());
        userInfoMobile.setRelationshipStatus(userInfo.getRelationshipStatus());
        userInfoMobile.setSchool(userInfo.getSchool());
        userInfoMobile.setTagline(userInfo.getTagline());
        userInfoMobile.setUserId(userInfo.getUserId());
        userInfoMobile.setVerificationKey(null);
        userInfoMobile.setWebsite(userInfo.getWebsite());
        return userInfoMobile;
    }

    @Override
    public boolean checkEmail(String email) {
        
        return userInfoDAOInterface.checkEmail(email);
    }

    @Override
    public boolean loginAuthentication(String email, String password) {
       
        return userInfoDAOInterface.loginAuthentication(email, password);
    }
    
}
