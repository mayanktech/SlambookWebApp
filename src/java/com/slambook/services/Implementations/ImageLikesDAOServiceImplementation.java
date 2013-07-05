/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.ImageLikes;
import com.slambook.repository.Interfaces.ImageLikesDAOInterface;
import com.slambook.services.Interfces.ImageLikesDAOServiceInterface;
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
public class ImageLikesDAOServiceImplementation implements ImageLikesDAOServiceInterface{

    @Autowired
    private ImageLikesDAOInterface imageLikesDAOInterface;
    
    @Override
    public int addLike(ImageLikes imageLikes) {
        
        return imageLikesDAOInterface.addLike(imageLikes);
    }

    @Override
    public int removeLike(ImageLikes imageLikes) {
       
        return imageLikesDAOInterface.removeLike(imageLikes);
        
    }

    @Override
    public ArrayList getImageLikes(int imageId) {
        
        return imageLikesDAOInterface.getImageLikes(imageId);
        
    }

    @Override
    public int getImageLikesCount(int imageId) {
        
        return imageLikesDAOInterface.getImageLikesCount(imageId);
    }

    @Override
    public int returnImageLikesCount(int imageId) {
       
        return imageLikesDAOInterface.returnImageLikesCount(imageId);
    }

    @Override
    public boolean isAlreadyLiked(int imageId, int userId) {
        
        return imageLikesDAOInterface.isAlreadyLiked(imageId, userId);
    }
    
}
