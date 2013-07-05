/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.Album;
import com.slambook.Entity.AlbumMobile;
import com.slambook.Entity.Messages;
import com.slambook.Entity.MessagesMobile;
import com.slambook.services.Interfces.MessagesDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/message")
public class MessageMobileController {
    
    @Autowired
    private MessagesDAOServiceInterface messagesDAOServiceInterface;
    
    @RequestMapping(value = "/addMessage" ,method = RequestMethod.PUT)
    public @ResponseBody int addMessage(@RequestBody Messages message){
    
        messagesDAOServiceInterface.sendMessage(message);
        return message.getMessageId();
        
    }
    
    @RequestMapping(value = "/getMessagesFromFriend/{senderId}/{receiverId}/{clickTimes}" ,method = RequestMethod.GET)
    public @ResponseBody ArrayList<com.slambook.Entity.Messages> getMessages(@PathVariable("senderId") int senderId,@PathVariable("receiverId") int receiverId, @PathVariable("clickTimes") int clickTimes){
    
    ArrayList messageList = messagesDAOServiceInterface.getConversationMessagesFromFriend(senderId, receiverId, clickTimes);
   
    return messageList;
    
    }
    @RequestMapping(value = "/getMessages/{userId}/{clickTimes}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <java.util.ArrayList<com.slambook.Entity.MessagesMobile>> getUserMessages(@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes){
    
        
        ArrayList <com.slambook.Entity.Messages>userMessages = messagesDAOServiceInterface.getTop10Messages(userId);
        ArrayList <com.slambook.Entity.MessagesMobile>userTop10Messages = new ArrayList<MessagesMobile>();
        for(Messages messages : userMessages){
        
            MessagesMobile messagesMobile = new MessagesMobile();
            messagesMobile.setCurrentProfilePic(messages.getCurrentProfilePic());
            messagesMobile.setDateSend(messages.getDateSend());
            messagesMobile.setMessage(messages.getMessage());
            messagesMobile.setMessageId(messages.getMessageId());
            messagesMobile.setSenderId(messages.getSenderId());
            messagesMobile.setSenderName(messages.getSenderName());
            messagesMobile.setUserId(userId);
            userTop10Messages.add(messagesMobile);
            
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<java.util.ArrayList<com.slambook.Entity.MessagesMobile>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.MessagesMobile>>(userTop10Messages,headers,HttpStatus.OK);
        return ent;
    }
    
    
}
