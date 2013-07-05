/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.ProfilePic;
import com.slambook.Entity.UserInfo;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/profilepic")
public class ProfilePicController {
    
    @Autowired
    private ServletContext context;
    @Autowired
    private ProfilePicDAOServiceInterface profilePicDAOServiceInterface;
    
    @RequestMapping(value = "/changeprofilepic" ,method = RequestMethod.POST)
    public @ResponseBody int changeProfilePic(@ModelAttribute("profilepic") ProfilePic  profilePic, HttpSession session){
    
    String realPath = context.getRealPath("/")+"WEB-INF/jsp/resources";
    BufferedImage image = null;
        UserInfo userInfo = new UserInfo();
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        userInfo.setUserId(userId);
    profilePic.setUserInfo(userInfo);
   
    
     int profilePicId = profilePicDAOServiceInterface.addProfilePic(profilePic);
    
    MultipartFile imagefile = profilePic.getImagefile();
    File uploadedFile = new File(realPath+"/users/"+userId+"/profilepic/"+profilePicId+".jpg");
    FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(uploadedFile);
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProfilePicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fileOutputStream.write(imagefile.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(ProfilePicController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            image = ImageIO.read(uploadedFile);
        } catch (IOException ex) {
            Logger.getLogger(ProfilePicController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        BufferedImage thumbnail1 = Scalr.resize(image, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 200, 200, Scalr.OP_ANTIALIAS);
        try {
            ImageIO.write(thumbnail1, "jpg", new File(realPath+"/users/"+userId+"/profilepic/thumbs/"+profilePicId+".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ProfilePicController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    return profilePicId;
    
    }
    
}
