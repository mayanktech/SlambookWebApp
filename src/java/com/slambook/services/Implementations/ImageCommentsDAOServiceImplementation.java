/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Implementations;

import com.slambook.Entity.ImageComments;
import com.slambook.Entity.UserInfo;
import com.slambook.repository.Interfaces.ImageCommentsDAOInterface;
import com.slambook.services.Interfces.ImageCommentsDAOServiceInterface;
import com.slambook.services.Interfces.ProfilePicDAOServiceInterface;
import com.slambook.services.Interfces.UserInfoDAOServiceInterface;
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
public class ImageCommentsDAOServiceImplementation implements ImageCommentsDAOServiceInterface {

    @Autowired
    private ImageCommentsDAOInterface imageCommentsDAOInterface;
    
    @Autowired
    private ProfilePicDAOServiceInterface profilePicDAOServiceInterface;
    
    @Autowired 
    private UserInfoDAOServiceInterface userInfoDAOServiceInterface;
    
    @Override
    public ArrayList getImageComments(int imageId) {
       
        ArrayList <com.slambook.Entity.ImageComments>imageCommentsList = imageCommentsDAOInterface.getImageComments(imageId);
        
        for(ImageComments imageComments : imageCommentsList){
        
            imageComments.setCurrentProfilePicId(profilePicDAOServiceInterface.getCurrentProfilePic(imageComments.getCommenterId()));
            UserInfo userInfo = userInfoDAOServiceInterface.getUser(imageComments.getCommenterId());
            imageComments.setName(userInfo.getFirstName()+" "+userInfo.getLastName());
        
        }
        return imageCommentsList;
    }

    @Override
    public void addImageComments(ImageComments imageComments) {
       imageCommentsDAOInterface.addImageComments(imageComments);
    }

    @Override
    public int getImageCommentsCount(int imageId) {
       return imageCommentsDAOInterface.getImageCommentsCount(imageId);
    }
    
}
