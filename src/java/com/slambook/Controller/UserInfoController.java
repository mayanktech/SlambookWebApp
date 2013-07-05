/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.Album;
import com.slambook.Entity.ImageFileUpload;
import com.slambook.Entity.ProfilePic;
import com.slambook.Entity.UserInfo;
import com.slambook.services.Interfces.AlbumDAOServiceInterface;
import com.slambook.services.Interfces.FriendsDAOServiceInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
import com.slambook.services.Interfces.SlamBookAnswersDAOServiceInterface;
import com.slambook.services.Interfces.UserInfoDAOServiceInterface;
import com.slambook.services.Interfces.VideosDAOServiceInterface;
import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/UserInfo")
public class UserInfoController {
    
    @Autowired
    private ServletContext context;
    @Autowired
    private UserInfoDAOServiceInterface userInfoDAOServiceInterface;
    @Autowired
    private AlbumDAOServiceInterface albumDAOServiceInterface;
    @Autowired
    private VideosDAOServiceInterface videosDAOServiceInterface;
    @Autowired
    private ProfilePicDAOServiceInterface profilePicDAOServiceInterface;
    @Autowired 
    private SlamBookAnswersDAOServiceInterface slamBookAnswersDAOServiceInterface;
    @Autowired
    private FriendsDAOServiceInterface friendsDAOServiceInterface;
    
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(@RequestParam("userId") int userId, Model model, HttpSession session){
        
        UserInfo userInfo = userInfoDAOServiceInterface.getUser(userId);
        
        
        userInfo.setAlbumList(albumDAOServiceInterface.getAlbums(userId, 0));
        userInfo.setVideoList(videosDAOServiceInterface.getVideos(userId, 0));
        userInfo.setProfilePic(profilePicDAOServiceInterface.getCurrentProfilePic(userId));
        userInfo.setSlambookAnswersList(slamBookAnswersDAOServiceInterface.userFriendsAnswers(userId));
        userInfo.setFriendsList(friendsDAOServiceInterface.getUserFriends(userId));
        System.out.println(albumDAOServiceInterface.getAlbums(userId, 0).size()+" "+videosDAOServiceInterface.getVideos(userId, 0).size());
        
        model.addAttribute("profilepic",new ProfilePic());
        model.addAttribute("imageFileUpload",new ImageFileUpload());
        model.addAttribute("albums",new Album());
        model.addAttribute("userInfo", userInfo);
        return "home";
    
    
    }
    
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addUser(UserInfo userInfo){
    
      int userId =  userInfoDAOServiceInterface.addUser(userInfo);
      String realPath = context.getRealPath("/")+"WEB-INF/jsp/resources";
        File file = new File(realPath+"/users/"+userId);
        file.mkdirs();
        File file1 = new File(realPath+"/users/"+userId+"/albums");
        file1.mkdirs();
        File file2 = new File(realPath+"/users/"+userId+"/mp3");
        file2.mkdirs();
        File file3 = new File(realPath+"/users/"+userId+"/profilepic");
        file3.mkdirs();
        File file4 = new File(realPath+"/users/"+userId+"/profilepic/"+"thumbs");
        file4.mkdirs();
        
        
    
    }
    
    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public String editUser(Model model,HttpSession httpSession){
    
    
        int userId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        UserInfo userInfo = userInfoDAOServiceInterface.getUser(userId);
        model.addAttribute("userInfo", userInfo);
        return "editProfile";
        
    }
    
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(UserInfo userInfo,HttpSession httpSession){
    
        int userId = Integer.parseInt(httpSession.getAttribute("userId").toString());
        userInfo.setUserId(userId);
        
        userInfoDAOServiceInterface.updateUser(userInfo);
    
    }
    
    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST)
    public @ResponseBody boolean checkEmail(@RequestParam("email") String email){
    
        return userInfoDAOServiceInterface.checkEmail(email);
    
    }
    
    @RequestMapping(value = "/loginAuthentication",method = RequestMethod.POST)
    public String loginAuthentication(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session){
    
     String redirectUrl = "";
     Boolean status = userInfoDAOServiceInterface.loginAuthentication(email, password);
     if(status == Boolean.TRUE){
     
         int userId = userInfoDAOServiceInterface.getUserIdByEmail(email);
         session.setAttribute("userId", userId);
         redirectUrl = "redirect:/UserInfo/getUser?userId="+userId;
     
     }
     else{
     
     redirectUrl = "redirect:/errorLoginPage";
     
     }
        
     return redirectUrl;
    
    }
}
