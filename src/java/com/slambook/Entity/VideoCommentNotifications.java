/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.model;

/**
 *
 * @author Mayank
 */
public class VideoCommentNotifications {
    
    private int videoId;
    private int userId;
    private String date;
    private int notificationId;
    private String friendName;
    private int friendCurrentProfilePic;
    private String videoName;
    private int friendId;

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    
    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
    
    

    public int getFriendCurrentProfilePic() {
        return friendCurrentProfilePic;
    }

    public void setFriendCurrentProfilePic(int friendCurrentProfilePic) {
        this.friendCurrentProfilePic = friendCurrentProfilePic;
    }
    
    

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
   
}
