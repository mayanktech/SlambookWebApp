/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.Images;
import com.slambook.repository.Interfaces.ImagesDAOInterface;
import com.slambook.services.Interfces.ImageCommentsDAOServiceInterface;
import com.slambook.services.Interfces.ImageLikesDAOServiceInterface;
import com.slambook.services.Interfces.ImagesDAOServiceInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
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
public class ImagesDAOServiceImplementation implements ImagesDAOServiceInterface {

    @Autowired
    private ImagesDAOInterface imagesDAOInterface;
    
    @Autowired
    private ImageLikesDAOServiceInterface imageLikesDAOServiceInterface;
    
    @Autowired
    private ImageCommentsDAOServiceInterface imageCommentsDAOServiceInterface;
    
    
    @Override
    public int addImage(Images image) {
        
       return imagesDAOInterface.addImage(image);
        
    }

    @Override
    public void updateImage(Images image) {
        
        imagesDAOInterface.updateImage(image);
    }

    @Override
    public int deleteAllImagesFromAlbum(int albumId) {
       
         return imagesDAOInterface.deleteAllImagesFromAlbum(albumId);
    }

    @Override
    public int deleteImage(int imageId) {
        
        return imagesDAOInterface.deleteImage(imageId);
    }

    @Override
    public ArrayList getImages(int albumId, int userId, int clickTimes) {
       
      
        ArrayList <com.slambook.Entity.Images>imagesList = imagesDAOInterface.getImages(albumId, userId, clickTimes);
        
        for(Images images : imagesList){
        
        images.setAlbumId(albumId);
        images.setAlreadyLiked(imageLikesDAOServiceInterface.isAlreadyLiked(images.getImageId(), userId));
        images.setImageLikesCount(imageLikesDAOServiceInterface.getImageLikesCount(images.getImageId()));
        images.setImageCommentCount(imageCommentsDAOServiceInterface.getImageCommentsCount(images.getImageId()));
        
        }
        return  imagesList;
        
    }

    @Override
    public int getImageAlbumId(int imageId) {
        
        return imagesDAOInterface.getImageAlbumId(imageId);
    }

    @Override
    public void deleteImages(int userId, int albumId, String[] imageIds) {
       
        imagesDAOInterface.deleteImages(userId, albumId, imageIds);
    }
    
}
