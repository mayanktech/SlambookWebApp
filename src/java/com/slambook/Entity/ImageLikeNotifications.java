/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.model;

/**
 *
 * @author Mayank
 */
public class ImageLikeNotifications {
    
    private int imageId;
    private int albumId;
    private int userId;
    private int friendId;
    private String date;
    private int notificationId;
    private String friendName;
    private String albumName;
    private int friendCurrentProfilePic;
    

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getFriendCurrentProfilePic() {
        return friendCurrentProfilePic;
    }

    public void setFriendCurrentProfilePic(int friendCurrentProfilePic) {
        this.friendCurrentProfilePic = friendCurrentProfilePic;
    }
    
    
    
}
