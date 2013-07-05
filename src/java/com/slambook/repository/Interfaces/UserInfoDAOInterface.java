/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Interfaces;

import com.slambook.Entity.UserInfo;

/**
 *
 * @author Mayank
 */
public interface UserInfoDAOInterface {
     public UserInfo getUser(int userId);
     public int addUser(UserInfo user);
     public String updateUser(UserInfo user);
     public void deleteUser(UserInfo user);
     public String getUserEmailById(int userId);
     public int getUserIdByEmail(String email);
     public boolean isAFriend(int userId,int friendId);
     public UserInfo getUserInfo(int userId);
     public boolean checkEmail(String email);
     public boolean loginAuthentication(String email,String password);
}
