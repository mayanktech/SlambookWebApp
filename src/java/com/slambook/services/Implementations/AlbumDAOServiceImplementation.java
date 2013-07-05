/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.Album;
import com.slambook.repository.Interfaces.AlbumDAOInterface;
import com.slambook.services.Interfces.AlbumDAOServiceInterface;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mayank
 */
@Service
@Transactional
public class AlbumDAOServiceImplementation implements AlbumDAOServiceInterface{

    @Autowired
    private AlbumDAOInterface albumDAOInterface;
    
    @Override
    public int addAlbum(Album album) {
        
        return albumDAOInterface.addAlbum(album);
        
    }

    @Override
    public void updateAlbum(Album album) {
        
        albumDAOInterface.updateAlbum(album);
    }

    @Override
    public int getAlbumCoverImage(int albumId) {
       
      return albumDAOInterface.getAlbumCoverImage(albumId);
    }

    @Override
    public int getAlbumImageCount(int albumId) {
       
        return albumDAOInterface.getAlbumImageCount(albumId);
    }

    @Override
    public void deleteAlbum(int albumId) {
        
        albumDAOInterface.deleteAlbum(albumId);
        
    }

    @Override
    public ArrayList getAlbums(int userId, int clickTimes) {
       
        
        ArrayList <com.slambook.Entity.Album>albumList = albumDAOInterface.getAlbums(userId, clickTimes);
        for(Album album : albumList){
        
        
           System.out.println(album.getAlbumId());
           System.out.println(getAlbumCoverImage(album.getAlbumId()));
            album.setCoverImageId(getAlbumCoverImage(album.getAlbumId()));
            System.out.println(album.getCoverImageId()+"Hiiiiii");
            album.setAlbumImageCount(getAlbumImageCount(album.getAlbumId()));
        
        }
        
        return albumList;
    }

    @Override
    public ArrayList getAllAlbums(int userId) {
        
        return albumDAOInterface.getAllAlbums(userId);
        
    }

    @Override
    public String getAlbumName(int albumId) {
        
        return albumDAOInterface.getAlbumName(albumId);
    }
    
}
