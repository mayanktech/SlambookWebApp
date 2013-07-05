/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

import java.util.Date;

/**
 *
 * @author Mayank
 */

public class AddVideoNotification {
   
    private int notificationId;
    private int videoId;
    private int friendId;
    private Date date;
    private String friendName;
    private String videoDescription;
    private int currentProfilePic;

    public int getCurrentProfilePic() {
        return currentProfilePic;
    }

    public void setCurrentProfilePic(int currentProfilePic) {
        this.currentProfilePic = currentProfilePic;
    }
    
    

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
