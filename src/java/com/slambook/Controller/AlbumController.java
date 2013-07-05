/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.Album;
import com.slambook.Entity.UserInfo;
import com.slambook.services.Interfces.AlbumDAOServiceInterface;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/album")
public class AlbumController {
   
    @Autowired
    private ServletContext context;
    @Autowired
    private AlbumDAOServiceInterface albumDAOServiceInterface;
    
    @RequestMapping(value = "/addAlbum" ,method = RequestMethod.POST)
    public @ResponseBody int addAlbum(@ModelAttribute("album") Album album, BindingResult bindingResult, HttpSession session){
    
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        album.setUserInfo(userInfo);
        String realPath = context.getRealPath("/")+"WEB-INF/jsp/resources";
        int albumId = albumDAOServiceInterface.addAlbum(album);
        File albumFolder = new File(realPath+"/users/"+userId+"/albums/"+albumId);
        albumFolder.mkdirs();
        File albumThumbsFolder = new File(realPath+"/users/"+userId+"/albums/"+albumId+"/thumbs");
        albumThumbsFolder.mkdirs();
        
        return album.getAlbumId();
        
    }
    
    @RequestMapping(value = "/deleteAlbum/{albumId}" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAlbum(@PathVariable("albumId") int albumId){
    
    
        albumDAOServiceInterface.deleteAlbum(albumId);
    
    }
    
    @RequestMapping(value = "/updateAlbum" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateAlbum(@ModelAttribute("album") Album album, BindingResult bindingResult){
    
        albumDAOServiceInterface.updateAlbum(album);
        
    }
    
    @RequestMapping(value = "/getUserAlbums/{userId}/{clickTimes}" ,method = RequestMethod.GET)
    public String getUserAlbum(@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes ,Model model ){
    
        
        ArrayList userAlbums = albumDAOServiceInterface.getAlbums(userId,clickTimes);
        model.addAttribute("userAlbums", userAlbums);
        return "getUserAlbums";
    
    }
    
    @RequestMapping(value = "/getUserFriendsAlbums/{userId}/{clickTimes}" ,method = RequestMethod.GET)
    public String getUserFriendsAlbum(@PathVariable("userId") int friendId,@PathVariable("clickTimes") int clickTimes ,Model model ){
    
        
        ArrayList userAlbums = albumDAOServiceInterface.getAlbums(friendId,clickTimes);
        model.addAttribute("albumList", userAlbums);
        model.addAttribute("friendId", friendId);
        return "viewFriendsAlbum";
    
    }
    
    @RequestMapping(value = "/LoadMoreUserAlbums/{userId}/{clickTimes}" ,method = RequestMethod.POST)
    public String getMoreUserAlbum(@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes ,Model model ){
    
        
        ArrayList userAlbums = albumDAOServiceInterface.getAlbums(userId,clickTimes);
        model.addAttribute("albumList", userAlbums);
        model.addAttribute("userId",userId);
        return "LoadMoreUserAlbums";
    
    }
    
    
}
