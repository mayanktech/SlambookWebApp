/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.Album;
import com.slambook.Entity.ImageFileUpload;
import com.slambook.Entity.Images;
import com.slambook.services.Interfces.ImagesDAOServiceInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.imgscalr.Scalr;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/Images")

public class ImagesController {
   
   @Autowired
   private ServletContext context;
   @Autowired 
   private ImagesDAOServiceInterface imagesDAOServiceInterface;
   
   @RequestMapping(value = "/addImage" ,method = RequestMethod.POST)
   public void addImage(@ModelAttribute("imageFileUpload") ImageFileUpload image, HttpSession session, BindingResult bindingResult){
   String realPath = context.getRealPath("/")+"WEB-INF/jsp/resources";  
   int userId = Integer.parseInt(session.getAttribute("userId").toString());
   List <MultipartFile> files = image.getUpload();
       System.out.println(files.size());
    Images images = new Images();
    Album album = new Album();
    album.setAlbumId(image.getAlbumId());
    images.setAlbum(album);
    images.setAlbumId(image.getAlbumId());
            System.out.println(image.getAlbumId());
       
       for (MultipartFile multipartFile : files) {
 
           BufferedImage imageFile = null;
           int imageId = imagesDAOServiceInterface.addImage(images);
           File uploadedFile = new File(realPath+"/users/"+userId+"/albums/"+image.getAlbumId()+"/"+imageId+".jpg");  
           FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(uploadedFile);
           
        } catch (FileNotFoundException ex) {
            
        }
          
        try {
            fileOutputStream.write(multipartFile.getBytes());
        } catch (IOException ex) {
            
        }
        
        try {
            imageFile = ImageIO.read(uploadedFile);
        } catch (IOException ex) {
           
        }
    
        BufferedImage thumbnail1 = Scalr.resize(imageFile, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 200, 200, Scalr.OP_ANTIALIAS);
        try {
            ImageIO.write(thumbnail1, "jpg", new File(realPath+"/users/"+userId+"/albums/"+image.getAlbumId()+"/thumbs/"+imageId+".jpg"));
        } catch (IOException ex) {
            
        }
       
       }
   
   }
   
    @RequestMapping(value = "/updateImage" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
   public void updateImage(@ModelAttribute("image") Images image, BindingResult bindingResult){
   
   imagesDAOServiceInterface.updateImage(image);
   
   }
    
    
   @RequestMapping(value = "/deleteImage/{imageId}" ,method = RequestMethod.POST,headers ={"Accept=text/xml,application/json"})
   public @ResponseBody int deleteImage(@PathVariable("imageId") int imageId){
   
   return imagesDAOServiceInterface.deleteImage(imageId);
   
   }
   
   @RequestMapping(value = "/getImages/{albumId}/{userId}" ,method = RequestMethod.POST)
   public String getImages(@PathVariable("albumId") int albumId,@PathVariable("userId") int userId, Model model){
       
    ArrayList imagesList =  imagesDAOServiceInterface.getImages(albumId, userId, 1);
       System.out.println(imagesList.size());
    model.addAttribute("imagesList", imagesList);
    return "getAlbumImages";
   
   }
   
   @RequestMapping(value = "/getFriendsImages/{albumId}/{friendId}" ,method = RequestMethod.POST)
   public String getFriendsImages(@PathVariable("albumId") int albumId,@PathVariable("friendId") int friendId, Model model){
       
    ArrayList imagesList =  imagesDAOServiceInterface.getImages(albumId, friendId, 1);
       System.out.println(imagesList.size());
    model.addAttribute("imagesList", imagesList);
    model.addAttribute("friendId", friendId);
    return "viewFriendsAlbumImages";
   
   }
   
   
}
