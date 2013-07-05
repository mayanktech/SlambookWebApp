/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Interfces;

import com.slambook.Entity.Messages;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface MessagesDAOServiceInterface {
   
   public int sendMessage(Messages message);
   public ArrayList getConversationMessagesFromFriend(int senderId,int receiverId,int clickTimes);
   public ArrayList getTop10Messages(int receiverId);
   public ArrayList getRealTimeMessages(int senderId,int userId,int messageId);
   public int getRealTimeMessageId(int senderId,int userId,int messageId);
    
}
