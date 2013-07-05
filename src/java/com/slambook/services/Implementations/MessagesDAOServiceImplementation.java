/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.Messages;
import com.slambook.Entity.UserInfo;
import com.slambook.repository.Interfaces.MessagesDAOInterface;
import com.slambook.services.Interfces.MessagesDAOServiceInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
import com.slambook.services.Interfces.UserInfoDAOServiceInterface;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mayank
 */
@Service
@Transactional
public class MessagesDAOServiceImplementation implements MessagesDAOServiceInterface{

   @Autowired
    private MessagesDAOInterface messagesDAOInterface;
   
   @Autowired
   private UserInfoDAOServiceInterface userInfoDAOServiceInterface;
   
   @Autowired
   private ProfilePicDAOServiceInterface profilePicDAOServiceInterface;
    
    @Override
    public int sendMessage(Messages message) {
       
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(message.getUserReceiverId());
        
        message.setUserInfo(userInfo);
        message.setDateSend(new Date());
        
        return messagesDAOInterface.sendMessage(message);
    }

    @Override
    public ArrayList getConversationMessagesFromFriend(int senderId, int receiverId, int clickTimes) {
      
         ArrayList <com.slambook.Entity.Messages>getmessagesList = messagesDAOInterface.getConversationMessagesFromFriend(senderId, receiverId, clickTimes);
         ArrayList <com.slambook.Entity.Messages> messagesList = new ArrayList<Messages>();
         
         for(Messages messages : getmessagesList)
         
         {
         
             int userSenderId = messages.getSenderId();
             UserInfo userInfo = userInfoDAOServiceInterface.getUser(userSenderId);
             messages.setSenderName(userInfo.getFirstName()+" "+userInfo.getLastName());
             messages.setCurrentProfilePic(profilePicDAOServiceInterface.getCurrentProfilePic(userSenderId));
             messagesList.add(messages);
             
         }
         
         return messagesList;
    }

    @Override
    public ArrayList getTop10Messages(int receiverId) {
       
        ArrayList messagesList = messagesDAOInterface.getTop10Messages(receiverId);
        ArrayList <com.slambook.Entity.Messages>userMessagesList = new ArrayList<Messages>();
        
        for(Object object : messagesList ){
        
            Object[] cols = (Object[]) object;
            Messages messages = new Messages();
            
            messages.setMessage(cols[4].toString());
            int senderId = Integer.parseInt(cols[1].toString());
            messages.setSenderId(senderId);
            UserInfo userInfo = userInfoDAOServiceInterface.getUser(senderId);
            messages.setSenderName(userInfo.getFirstName()+" "+userInfo.getLastName());
            messages.setCurrentProfilePic(profilePicDAOServiceInterface.getCurrentProfilePic(senderId));
            messages.setMessageId(Integer.parseInt(cols[0].toString()));
            messages.setDateSend(new Date());
            
            
            userMessagesList.add(messages);
        
        }
        
        
        return userMessagesList;
    }

    @Override
    public ArrayList getRealTimeMessages(int senderId,int userId,int messageId) {
        
        return messagesDAOInterface.getRealTimeMessages(senderId, userId, messageId);
    
    }

    @Override
    public int getRealTimeMessageId(int senderId, int userId, int messageId) {
        
        return messagesDAOInterface.getRealTimeMessageId(senderId, userId, messageId);
    }
    
    
    
}
