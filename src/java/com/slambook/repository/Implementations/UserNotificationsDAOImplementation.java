/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.UserNotifications;
import com.slambook.repository.Interfaces.UserNotificationsDAOInterface;
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
public class UserNotificationsDAOImplementation implements UserNotificationsDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public int addUserNotifiaction(UserNotifications userNotifications) {
        
        sessionFactory.getCurrentSession().save(userNotifications);
        return userNotifications.getNotificationId();
    }

    @Override
    public ArrayList getFriendsNotifications(int userId, int clickTimes) {
       Query query = sessionFactory.getCurrentSession().getNamedQuery("UserNotifications.getFriendsNotifications");
        query.setInteger("userId",userId);
        query.setFirstResult(4);
        query.setMaxResults(clickTimes*4);
        return (ArrayList) query.list();
        
    }
    
}
