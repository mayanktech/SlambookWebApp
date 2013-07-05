/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Interfces;

import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface FriendsDAOServiceInterface {
   
     public ArrayList searchFriendsByName(String name,int currentUserId);
     public ArrayList searchFriendsByEmail(String email);
     public ArrayList getUserFriends(int userId);
     public void acceptRequest(int userId,int friendId);
     public void cancelRequest(int userId,int friendId);
     public boolean isAlreadyAFriend(int friendId,int userId);
     public int getNumberOfMutualFriends(int friendId);
     public ArrayList getIdsOfUserFriends(int userId);
    
}
