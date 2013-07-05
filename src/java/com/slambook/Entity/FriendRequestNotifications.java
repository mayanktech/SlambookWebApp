/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;



/**
 *
 * @author Mayank
 */
public class FriendRequestNotifications {
    
    int friendId;
    int currentProfilePic;
    private String name;
    private String dateSend;
    
    

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getCurrentProfilePic() {
        return currentProfilePic;
    }

    public void setCurrentProfilePic(int currentProfilePic) {
        this.currentProfilePic = currentProfilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }
    
    
    
    
}
