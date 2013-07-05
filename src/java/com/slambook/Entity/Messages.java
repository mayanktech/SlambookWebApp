/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Mayank
 */

@Entity
@NamedQueries({

    @NamedQuery(name = "Messages.getConversationMessagesFromFriend",query="FROM Messages message WHERE message.senderId IN (:receiverId,:senderId) AND message.userInfo.userId IN (:receiverId,:senderId) ORDER BY message.messageId DESC"),
    @NamedQuery(name = "Messages.getRealTimeMessages",query="FROM Messages message WHERE message.senderId = :senderId AND message.userInfo.userId = :receiverId AND message.messageId > :messageId ORDER BY message.messageId DESC"),
    @NamedQuery(name = "Messages.getRealTimeMessageId",query="SELECT message.messageId FROM Messages message WHERE message.senderId = :senderId AND message.userInfo.userId = :receiverId AND message.messageId > :messageId ORDER BY message.messageId DESC LIMIT 1"),
    @NamedQuery(name = "Messages.getTop10Messages",query="SELECT MAX(message.messageId),message.senderId,message.userInfo.userId,message.dateSend,message.message FROM Messages message WHERE message.userInfo.userId = :userId GROUP BY message.senderId ORDER BY message.messageId DESC")

})
public class Messages implements Serializable  {
    
    @Id
    @GeneratedValue        
    int messageId;
    int senderId;
    
    String message;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateSend;
    
    @Transient
    int currentProfilePic;
    @Transient
    String senderName;
    
    @ManyToOne
    @JoinColumn(name="receiverId")
    private UserInfo userInfo;
    

    @Transient
    private int userReceiverId;
    
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
    
    

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
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

    
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getUserReceiverId() {
        return userReceiverId;
    }

    public void setUserReceiverId(int userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

    
    
    
    
}
