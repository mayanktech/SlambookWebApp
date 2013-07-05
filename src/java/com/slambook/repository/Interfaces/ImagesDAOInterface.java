/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Interfaces;

import com.slambook.Entity.Images;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface ImagesDAOInterface {
    
    public int addImage(Images image);
     public void updateImage(Images image);
      public int deleteAllImagesFromAlbum(int albumId);
       public int deleteImage(int imageId);
       public ArrayList getImages(int albumId,int userId,int clickTimes);
       public int getImageAlbumId(int imageId);
       public void deleteImages(int userId,int albumId,String imageIds[]);
}
