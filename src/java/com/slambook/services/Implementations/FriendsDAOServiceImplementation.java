/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.Friends;
import com.slambook.Entity.UserInfo;
import com.slambook.repository.Interfaces.FriendsDAOInterface;
import com.slambook.services.Interfces.FriendsDAOServiceInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
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
public class FriendsDAOServiceImplementation implements FriendsDAOServiceInterface {

    @Autowired
    private FriendsDAOInterface friendsDAOInterface;
    
    @Autowired 
    private ProfilePicDAOServiceInterface profilePicDAOServiceInterface;
    
    @Autowired
    private UserInfoDAOServiceInterface userInfoDAOServiceInterface;
    
    
    @Override
    public ArrayList searchFriendsByName(String name, int currentUserId) {
        
        ArrayList userInfos = friendsDAOInterface.searchFriendsByName(name, currentUserId); 
        ArrayList<com.slambook.Entity.Friends> friendsList = new ArrayList<Friends>();
        
        for(Object userInfo : userInfos){
        
        Friends friends = new Friends();
        Object[] cols = (Object[]) userInfo;
        int userId = Integer.parseInt(cols[0].toString());
        friends.setFirstName(cols[1].toString());
        friends.setLastName(cols[2].toString());
        friends.setUserId(userId);
        friends.setProfilePicId(profilePicDAOServiceInterface.getCurrentProfilePic(userId));
        friends.setAlreadyFriend(friendsDAOInterface.isAlreadyAFriend(userId, currentUserId));
        
        if(friends.getUserId() != currentUserId){
        
            
        friendsList.add(friends);
        
        }
        }
        
        return friendsList;
        
    }

    @Override
    public ArrayList searchFriendsByEmail(String email) {
       
        return friendsDAOInterface.searchFriendsByEmail(email);
        
    }

    @Override
    public ArrayList getUserFriends(int userId) {
      
        ArrayList <Integer>userInfos = friendsDAOInterface.getUserFriends(userId);
        ArrayList<com.slambook.Entity.Friends> friendsList = new ArrayList<Friends>();
       for(Integer userInfo : userInfos){
        
        Friends friends = new Friends();
        
        int userId1 = userInfo;
        UserInfo userInfo1 = userInfoDAOServiceInterface.getUser(userId1);
        friends.setFirstName(userInfo1.getFirstName());
        friends.setLastName(userInfo1.getLastName());
        friends.setUserId(userId1);
        friends.setProfilePicId(profilePicDAOServiceInterface.getCurrentProfilePic(userId1));
        friendsList.add(friends);
        
        
        }
        
        return friendsList;
    }

    @Override
    public void acceptRequest(int userId, int friendId) {
        
        friendsDAOInterface.acceptRequest(userId, friendId);
    }

    @Override
    public void cancelRequest(int userId, int friendId) {
        
        friendsDAOInterface.cancelRequest(userId, friendId);
    }

    @Override
    public boolean isAlreadyAFriend(int friendId, int userId) {
        
        return friendsDAOInterface.isAlreadyAFriend(friendId, userId);
    }

    @Override
    public int getNumberOfMutualFriends(int friendId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getIdsOfUserFriends(int userId) {
        
        return friendsDAOInterface.getIdsOfUserFriends(userId);
    }
    
}
