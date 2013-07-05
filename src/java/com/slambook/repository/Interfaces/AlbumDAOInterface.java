/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Interfaces;

import com.slambook.Entity.Album;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface AlbumDAOInterface {
    
     public int addAlbum(Album album);
     public void updateAlbum(Album album);
     public int getAlbumCoverImage(int albumId);
     public int getAlbumImageCount(int albumId);
     public void deleteAlbum(int albumId);
     public ArrayList getAlbums(int userId,int clickTimes);
     public ArrayList getAllAlbums(int userId);
     public String getAlbumName(int albumId);
}
