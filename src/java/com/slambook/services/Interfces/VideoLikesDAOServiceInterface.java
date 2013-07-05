/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Interfces;

import com.slambook.Entity.VideoLikes;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface VideoLikesDAOServiceInterface {
   
    public int addLike(VideoLikes videoLikes);
    public int removeLike(VideoLikes videoLikes);
    public ArrayList getVideoLikes(int videoId);
    public int getVideoLikesCount(int videoId);
    public int returnVideoLikesCount(int videoId);
    public boolean isAlreadyLiked(int videoId,int userId);
}
