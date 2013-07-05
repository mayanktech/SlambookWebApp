/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.Messages;
import com.slambook.repository.Interfaces.MessagesDAOInterface;
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
public class MessagesDAOImplementation implements MessagesDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public int sendMessage(Messages message) {
        
        sessionFactory.getCurrentSession().save(message);
        return message.getMessageId();
        
    }

    @Override
    public ArrayList getConversationMessagesFromFriend(int senderId, int receiverId, int clickTimes) {
         int start = 0;
    int end = 0;
    
    if(clickTimes == 0){
    
    start = 0;
    end = 4;
    
    }
    else {
    
    start = 4 * clickTimes;
    end = 4;
    
    }
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Messages.getConversationMessagesFromFriend");
        query.setInteger("senderId",senderId);
        query.setInteger("receiverId", receiverId);
        query.setFirstResult(start);
        query.setMaxResults(end);
        return (ArrayList) query.list();
       
    }

    @Override
    public ArrayList getTop10Messages(int receiverId) {
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Messages.getTop10Messages");
        query.setInteger("userId", receiverId);
        //query.setFirstResult(10);
        //System.out.println(query.list().size());
        return (ArrayList) query.list();
    }

    @Override
    public ArrayList getRealTimeMessages(int senderId,int userId,int messageId) {
       
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Messages.getRealTimeMessages");
        query.setInteger("senderId", senderId);
        query.setInteger("receiverId", userId);
        query.setInteger("messageId", messageId);
        return (ArrayList) query.list();
        
    }

    @Override
    public int getRealTimeMessageId(int senderId, int userId, int messageId) {
    
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Messages.getRealTimeMessageId");
        query.setInteger("senderId", senderId);
        query.setInteger("receiverId", userId);
        query.setInteger("messageId", messageId);
        
        return (Integer)query.list().get(0);
    
    }
    
}
