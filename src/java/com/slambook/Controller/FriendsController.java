/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.services.Interfces.FriendsDAOServiceInterface;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/Friends")
public class FriendsController {
    
    @Autowired
    private FriendsDAOServiceInterface friendsDAOServiceInterface;
    
    @RequestMapping(value = "/searchFriendsByName/{friendName}" ,method = RequestMethod.POST)
    public String searchFriendsByName(@PathVariable("friendName") String friendName, Model model, HttpSession httpSession){
    
    
        int userId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        ArrayList friendsList = friendsDAOServiceInterface.searchFriendsByName(friendName, userId);
        model.addAttribute("friendsList", friendsList);
        return "searchFriends";
        
    }
    
    @RequestMapping(value = "/acceptRequest/{userId}/{friendId}" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void acceptRequest(@PathVariable("userId") int userId,@PathVariable("friendId") int friendId){
        
        friendsDAOServiceInterface.acceptRequest(userId, friendId);
    
    }
    
    @RequestMapping(value = "/cancelRequest/{userId}/{friendId}" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void cancelRequest(@PathVariable("userId") int userId,@PathVariable("friendId") int friendId){
        
        friendsDAOServiceInterface.cancelRequest(userId, friendId);
    
    }
    
    @RequestMapping(value = "/addFriend" ,method = RequestMethod.GET)
    public String addFriendToSlambook(){
    
    return "addFriend";
        
    }
    
}
