/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.UserInfo;
import com.slambook.Entity.UserInfoMobile;
import com.slambook.services.Interfces.AlbumDAOServiceInterface;
import com.slambook.services.Interfces.FriendsDAOServiceInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
import com.slambook.services.Interfces.SlamBookAnswersDAOServiceInterface;
import com.slambook.services.Interfces.UserInfoDAOServiceInterface;
import com.slambook.services.Interfces.VideosDAOServiceInterface;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/UserInfo")
public class UserInfoMobileController {
    
    @Autowired
    private UserInfoDAOServiceInterface userInfoDAOServiceInterface;
    
    
    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public  ResponseEntity <UserInfoMobile> getUser(@PathVariable("userId") int userId){
        
        UserInfoMobile userInfo = userInfoDAOServiceInterface.getUserInfo(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<UserInfoMobile> ent = new ResponseEntity<UserInfoMobile>(userInfo,headers,HttpStatus.CREATED);
        return ent;
    
    
    }
    
    @RequestMapping(value = "/addUser",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void addUser(@RequestBody UserInfo userInfo){
    
        userInfoDAOServiceInterface.addUser(userInfo);
    
    }
}
