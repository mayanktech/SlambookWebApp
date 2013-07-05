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
public class MessagesMobile {
    
    private int messageId;
    private int senderId;
    private String message;
    private Date dateSend;
    private int currentProfilePic;
    private String senderName;
    private int userId;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public int getCurrentProfilePic() {
        return currentProfilePic;
    }

    public void setCurrentProfilePic(int currentProfilePic) {
        this.currentProfilePic = currentProfilePic;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
