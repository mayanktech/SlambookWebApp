/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.repository.Interfaces.NotificationsDaoInterface;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mayank
 */
@Repository
public class NotificationsDAOImplementation implements NotificationsDaoInterface {

    @Override
    public ArrayList getNotifications(int userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
