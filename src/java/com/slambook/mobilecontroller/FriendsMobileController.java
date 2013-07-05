/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.services.Interfces.FriendsDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/Friends")
public class FriendsMobileController {
    
    @Autowired
    private FriendsDAOServiceInterface friendsDAOServiceInterface;
    
    @RequestMapping(value = "/searchFriendsByName/{friendName}/{userId}" ,method = RequestMethod.PUT)
    public @ResponseBody ArrayList<com.slambook.Entity.Friends> searchFriendsByName(@PathVariable("friendName") String friendName,@PathVariable("userId") int userId){
    
    
        ArrayList friendsList = friendsDAOServiceInterface.searchFriendsByName(friendName, userId);
        
        return friendsList;
        
    }
    
    @RequestMapping(value = "/acceptRequest/{userId}/{friendId}" ,method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void acceptRequest(@PathVariable("userId") int userId,@PathVariable("friendId") int friendId){
        
        friendsDAOServiceInterface.acceptRequest(userId, friendId);
    
    }
    
    @RequestMapping(value = "/cancelRequest/{userId}/{friendId}" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void cancelRequest(@PathVariable("userId") int userId,@PathVariable("friendId") int friendId){
        
        friendsDAOServiceInterface.cancelRequest(userId, friendId);
    
    }
    
    
    @RequestMapping(value = "/getUserFriendsList/{{userId}" ,method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity <java.util.ArrayList<com.slambook.Entity.Friends>> getUserFriendsList(@PathVariable("userId") int userId){
    
    
        ArrayList <com.slambook.Entity.Friends>friendsList = friendsDAOServiceInterface.getUserFriends(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<java.util.ArrayList<com.slambook.Entity.Friends>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.Friends>>(friendsList,headers,HttpStatus.OK);
        return ent;
        
    }
    
    
}
