/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Interfaces;

import com.slambook.Entity.ImageComments;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface ImageCommentsDAOInterface {

    public ArrayList getImageComments(int imageId);
    public void addImageComments(ImageComments imageComments);
    public int getImageCommentsCount(int imageId) ;
}


