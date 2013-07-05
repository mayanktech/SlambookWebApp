/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.Album;
import com.slambook.Entity.AlbumMobile;
import com.slambook.services.Interfces.AlbumDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/album")
public class AlbumMobileController {
   
    @Autowired
    private AlbumDAOServiceInterface albumDAOServiceInterface;
    
    @RequestMapping(value = "/addAlbum" ,method = RequestMethod.PUT)
    public @ResponseBody int addAlbum(@RequestBody Album album){
    
        albumDAOServiceInterface.addAlbum(album);
        return album.getAlbumId();
        
    }
    
    @RequestMapping(value = "/deleteAlbum/{albumId}" ,method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAlbum(@PathVariable("albumId") int albumId){
    
    
        albumDAOServiceInterface.deleteAlbum(albumId);
    
    }
    
    @RequestMapping(value = "/updateAlbum" ,method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAlbum(@RequestBody Album album){
    
        albumDAOServiceInterface.updateAlbum(album);
        
    }
    
    @RequestMapping(value = "/getUserAlbums/{userId}/{clickTimes}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <java.util.ArrayList<com.slambook.Entity.AlbumMobile>> getUserAlbum(@PathVariable("userId") int userId,@PathVariable("clickTimes") int clickTimes){
    
        
        ArrayList <com.slambook.Entity.Album>userAlbums = albumDAOServiceInterface.getAlbums(userId,clickTimes);
        ArrayList <com.slambook.Entity.AlbumMobile>userAlbumsMobile = new ArrayList<AlbumMobile>();
        for(Album album : userAlbums){
        
        AlbumMobile albumMobile = new AlbumMobile();
        albumMobile.setAlbumDate(album.getAlbumDate());
        albumMobile.setAlbumId(album.getAlbumId());
        albumMobile.setAlbumImageCount(album.getAlbumImageCount());
        albumMobile.setAlbumName(album.getAlbumName());
        albumMobile.setAlbumSummary(album.getAlbumSummary());
        albumMobile.setCoverImageId(album.getCoverImageId());
        albumMobile.setUserId(userId);
        userAlbumsMobile.add(albumMobile);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<java.util.ArrayList<com.slambook.Entity.AlbumMobile>> ent = new ResponseEntity<java.util.ArrayList<com.slambook.Entity.AlbumMobile>>(userAlbumsMobile,headers,HttpStatus.OK);
        return ent;
    }
    
    
}
