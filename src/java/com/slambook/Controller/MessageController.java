/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.Album;
import com.slambook.Entity.Messages;
import com.slambook.services.Interfces.MessagesDAOServiceInterface;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    
    @Autowired
    private MessagesDAOServiceInterface messagesDAOServiceInterface;
    
    @RequestMapping(value = "/addMessage" ,method = RequestMethod.POST)
    public @ResponseBody int addMessage(Messages message, BindingResult bindingResult){
    
        messagesDAOServiceInterface.sendMessage(message);
        return message.getMessageId();
        
    }
    
    @RequestMapping(value = "/getMessages" ,method = RequestMethod.POST)
    public String getMessagesFromFriend(@RequestParam("senderId") int senderId,@RequestParam("clickTimes") int clickTimes,Model model,HttpSession session){
    
    int receiverId = Integer.parseInt(session.getAttribute("userId").toString());
    ArrayList messageList = messagesDAOServiceInterface.getConversationMessagesFromFriend(senderId, receiverId, clickTimes);
        System.out.println(""+messageList.size());
    model.addAttribute("messages", messageList);
    model.addAttribute("senderId", senderId);
    return "GetFriendsConversationMessages";
    
    }
    
    @RequestMapping(value = "/getTop10Messages" ,method = RequestMethod.POST)
    public String getTop10Messages(@RequestParam("userId") int userId,Model model, HttpSession session){
    
    
    ArrayList top10MessagesList = messagesDAOServiceInterface.getTop10Messages(userId);
    System.out.println(top10MessagesList.size());
    model.addAttribute("messageList", top10MessagesList);
    return "GetUserUniqueMessages";
    
    }
    
    
    @RequestMapping(value = "/getRealTimeMessageId" ,method = RequestMethod.POST)
    public @ResponseBody int getRealTimeMessageId(@RequestParam("senderId") int senderId,@RequestParam("messageId") int messageId,HttpSession session){
    
       int userId = Integer.parseInt(session.getAttribute("userId").toString());
       return messagesDAOServiceInterface.getRealTimeMessageId(senderId, userId, messageId);
        
    }
    
    @RequestMapping(value = "/getRealTimeMessages" ,method = RequestMethod.POST)
    public String getRealTimeMessagesFromFriend(@RequestParam("senderId") int senderId,@RequestParam("messageId") int messageId,Model model,HttpSession session){
    
    int receiverId = Integer.parseInt(session.getAttribute("userId").toString());
    ArrayList messageList = messagesDAOServiceInterface.getRealTimeMessages(senderId, receiverId, messageId);
    System.out.println(""+messageList.size());
    model.addAttribute("messages", messageList);
    model.addAttribute("senderId", senderId);
    return "GetFriendsConversationMessages";
    
    }
    
}
