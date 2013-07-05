/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.repository.Interfaces.FriendsDAOInterface;
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
public class FriendsDAOImplementation implements FriendsDAOInterface {

    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public ArrayList searchFriendsByName(String name, int currentUserId) {
        
        name = name+"%";
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Friends.searchFriendsByName");
        query.setString("searchString",name.replace(" ", ""));
        return (ArrayList) query.list();
    
        
    }

    @Override
    public ArrayList searchFriendsByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList getUserFriends(int userId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Friends.getUserFriends");
        query.setInteger("userId",userId);
        query.setBoolean("allow", true);
        return (ArrayList) query.list();
    
    }

    @Override
    public void acceptRequest(int userId, int friendId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancelRequest(int userId, int friendId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isAlreadyAFriend(int friendId, int userId) {
       
        boolean status = false;
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Friends.isAlreadyAFriend");
        query.setInteger("userId",userId);
        query.setInteger("senderId",friendId);
        
        if(!query.list().isEmpty()){
    
        status = true;
    
        }
       
        return status;
    }

    @Override
    public int getNumberOfMutualFriends(int friendId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList getIdsOfUserFriends(int userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
