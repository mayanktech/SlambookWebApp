/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Interfaces;

import com.slambook.Entity.ImageLikes;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface ImageLikesDAOInterface {
    
     public int addLike(ImageLikes imageLikes);
     public int removeLike(ImageLikes imageLikes);
     public ArrayList getImageLikes(int imageId);
     public int getImageLikesCount(int imageId);
     public int returnImageLikesCount(int imageId);
     public boolean isAlreadyLiked(int imageId,int userId);
    
}
