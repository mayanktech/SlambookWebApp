/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Interfces;

import com.slambook.Entity.VideoComments;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface VideoCommentsDAOServiceInterface {
  
    public void addVideoComments(VideoComments videoComments);
    public ArrayList getVideoComments(int videoId);
    public int getVideoCommentsCount(int videoId);
    
}
