/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 *
 * @author Mayank
 */

@Entity
@NamedQueries({

    @NamedQuery(name = "VideoLikes.getVideoLikes",query = "FROM VideoLikes likes WHERE likes.videos.videoId = :videoId"),
    @NamedQuery(name = "VideoLikes.getVideoLikesCount",query = "SELECT COUNT(likes.videoLikeId) FROM VideoLikes likes WHERE likes.videos.videoId = :videoId"),
    @NamedQuery(name = "VideoLikes.isAlreadyLiked",query = "FROM VideoLikes likes WHERE likes.videos.videoId = :videoId AND likes.userId = :userId")

})
public class VideoLikes implements Serializable {
  
    @Id
    @GeneratedValue
    private int videoLikeId;
    
    @ManyToOne
    @JoinColumn(name="videoId")
    private Videos videos;

    
    @Transient
    private int friendId;
    
    @Transient
    private String friendName;
    
    @Transient
    private int currentProfilePic;
    
    
    private int userId;
    
    @Transient
    private int videoId;
   
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getCurrentProfilePic() {
        return currentProfilePic;
    }

    public void setCurrentProfilePic(int currentProfilePic) {
        this.currentProfilePic = currentProfilePic;
    }

    public int getVideoLikeId() {
        return videoLikeId;
    }

    public void setVideoLikeId(int videoLikeId) {
        this.videoLikeId = videoLikeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
    
    
    
}
