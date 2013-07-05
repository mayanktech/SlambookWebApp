/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.UserInfo;
import com.slambook.Entity.Videos;
import com.slambook.services.Interfces.VideosDAOServiceInterface;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/Videos")
public class VideosController {
    
    @Autowired
    private VideosDAOServiceInterface videosDAOServiceInterface;
    
    @RequestMapping(value = "/addVideo" ,method = RequestMethod.POST)
    public @ResponseBody int addVideo(@ModelAttribute("video") Videos videos,HttpSession httpSession){
    
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(Integer.parseInt(httpSession.getAttribute("userId").toString()));
        videos.setUserInfo(userInfo);
        return videosDAOServiceInterface.addVideo(videos);
     
    }
    
    @RequestMapping(value = "/deleteVideo/{videoId}" ,method = RequestMethod.POST)
    public @ResponseBody int deleteVideo(@PathVariable("videoId") int videoId){
    
       return videosDAOServiceInterface.deleteVideo(videoId);
    
    }
    
     @RequestMapping(value = "/getVideos/{userId}/{clickTimes}" ,method = RequestMethod.POST)
    public String getVideos(@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes, Model model){
     
     ArrayList videosList = videosDAOServiceInterface.getVideos(userId, clickTimes);
     model.addAttribute("videosList", videosList);
     return "getVideos";
         
     }
     
    @RequestMapping(value = "/LoadMoreUserVideos/{userId}/{clickTimes}" ,method = RequestMethod.POST)
    public String getMoreUserVideos(@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes, Model model){
     
     ArrayList videosList = videosDAOServiceInterface.getVideos(userId, clickTimes);
     model.addAttribute("videoList", videosList);
     return "LoadMoreUserVideos";
         
     }
     
     @RequestMapping(value = "/getFriendsVideos/{friendId}/{clickTimes}" ,method = RequestMethod.POST)
    public String getFriendsVideos(@PathVariable("friendId") int friendId,@PathVariable("clickTimes") int clickTimes, Model model){
     
     ArrayList videosList = videosDAOServiceInterface.getVideos(friendId, clickTimes);
     model.addAttribute("videoList", videosList);
     return "viewFriendsVideos";
         
     }
    
}
