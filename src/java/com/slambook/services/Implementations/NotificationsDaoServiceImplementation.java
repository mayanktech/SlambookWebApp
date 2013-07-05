/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.repository.Interfaces.NotificationsDaoInterface;
import com.slambook.services.Interfces.NotificationsDaoServiceInterface;
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
public class NotificationsDaoServiceImplementation implements NotificationsDaoServiceInterface{

    @Autowired
    private NotificationsDaoInterface notificationsDaoInterface;
    
    @Override
    public ArrayList getNotifications(int userId) {
       
      return  notificationsDaoInterface.getNotifications(userId);
    
    }
    
}
