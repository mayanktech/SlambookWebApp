/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.UserNotifications;
import com.slambook.repository.Interfaces.UserNotificationsDAOInterface;
import com.slambook.services.Interfces.UserNotificationsDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mayank
 */
@Service
@Transactional
public class UserNotificationsDAOServiceImplementation implements UserNotificationsDAOServiceInterface{

    private UserNotificationsDAOInterface userNotificationsDAOInterface;

    @Override
    public int addUserNotifiaction(UserNotifications userNotifications) {
        
        return userNotificationsDAOInterface.addUserNotifiaction(userNotifications);
    }

    @Override
    public ArrayList getFriendsNotifications(int userId, int clickTimes) {
       
        return userNotificationsDAOInterface.getFriendsNotifications(userId, clickTimes);
    }
    
}
