/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Interfces;

import com.slambook.Entity.UserNotifications;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface UserNotificationsDAOServiceInterface {
    public int addUserNotifiaction(UserNotifications userNotifications);
     public ArrayList getFriendsNotifications(int userId,int clickTimes);
     
}
