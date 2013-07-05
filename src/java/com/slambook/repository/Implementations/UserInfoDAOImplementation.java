/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.UserInfo;
import com.slambook.repository.Interfaces.UserInfoDAOInterface;
import java.util.ArrayList;
import java.util.Random;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mayank
 */
@Repository
public class UserInfoDAOImplementation implements UserInfoDAOInterface{

   
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public UserInfo getUser(int userId) {
        
      return  (UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class,userId);
        
    }

    @Override
    public int addUser(UserInfo user) {
       
        sessionFactory.getCurrentSession().save(user);
        
        long range = 12345678999999999L;
        Random r = new Random();
        long number = (long)(r.nextDouble()*range);
        user.setVerificationKey(Long.toString(number));
        
        return user.getUserId();
    }

    @Override
    public String updateUser(UserInfo user) {
       
        Query query = sessionFactory.getCurrentSession().getNamedQuery("UserInfo.updateUserInfo");
        query.setString("tagline", user.getTagline());
        query.setString("introduction", user.getIntroduction());
        query.setString("braggingRights", user.getBraggingRights());
        query.setString("placesLived", user.getPlacesLived());
        query.setString("lookingFor",user.getLookingFor());
        query.setString("birthday", user.getBirthday());
        query.setString("email", user.getEmail());
        query.setString("relationshipStatus", user.getRelationshipStatus());
        query.setString("school", user.getSchool());
        query.setString("college", user.getCollege());
        query.setString("website", user.getWebsite());
        query.executeUpdate();
        return "Updated";
    }

    @Override
    public void deleteUser(UserInfo user) {
        
        sessionFactory.getCurrentSession().delete(user);
        
    }

    @Override
    public String getUserEmailById(int userId) {
     Query query = sessionFactory.getCurrentSession().getNamedQuery("UserInfo.getEmailById");
     query.setInteger("userId",userId);
     return (String) query.uniqueResult();
    }

    @Override
    public int getUserIdByEmail(String email) {
     Query query = sessionFactory.getCurrentSession().getNamedQuery("UserInfo.getUserIdByEmail");
     query.setString("email",email);
     return (Integer) query.uniqueResult();
    }

    @Override
    public boolean isAFriend(int userId, int friendId) {
     Query query = sessionFactory.getCurrentSession().getNamedQuery("SlambookAnswers.isAFriend");
     query.setInteger("userId",userId);
     query.setInteger("senderId",friendId);
     return (Boolean) query.uniqueResult();
    }

    @Override
    public UserInfo getUserInfo(int userId) {
      
//        Query query = sessionFactory.getCurrentSession().getNamedQuery("UserInfo.getUserInfoById");
//        query.setInteger("userId",userId);
//        return (UserInfo) query.uniqueResult();
//        
         return  (UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class,userId);
     
        
    }

    @Override
    public boolean checkEmail(String email) {
       
     Boolean status = false;
     Query query = sessionFactory.getCurrentSession().getNamedQuery("UserInfo.checkEmail");
     query.setString("email","%"+email+"%");
     
     if(query.list() != null & query.list().size() != 0 ){
     
         status = true;
     
     }
     return status;
     
     
    }
    
    
    @Override
    public boolean loginAuthentication(String email,String password){
    
     String emailDB = "";
     String passwordDB = "";
     String accountStatus="";
        
     Boolean status = false;
     Query query = sessionFactory.getCurrentSession().getNamedQuery("UserInfo.getUserByEmail");
     query.setString("email",email);
     
     
     if(query.uniqueResult() != null){
     UserInfo userInfo = (UserInfo)query.uniqueResult();
     emailDB = userInfo.getEmail();
     passwordDB = userInfo.getPassword();
     accountStatus = userInfo.getAccountStatus();
     }
    
     if(emailDB.equals(email) && passwordDB.equals(password)){
        
         status = true;
        
        } 
        else {
        
         status = false;
            
        }
        
    
     return status;
    }
    
}
