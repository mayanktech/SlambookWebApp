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

@NamedQuery(name="Friends.getUserFriends",query="SELECT answers.senderId from SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.allow = :allow"),
@NamedQuery(name="Friends.acceptRequest",query="from SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.allow = :allow AND answers.senderId = :senderId"),
@NamedQuery(name="Friends.cancelRequest",query="DELETE from SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.senderId = :senderId"),
@NamedQuery(name="Friends.acceptRequest1",query="UPDATE SlamBookAnswers answers SET answers.allow = true WHERE answers.userInfo.userId = :userId AND answers.senderId = :senderId"),
@NamedQuery(name="Friends.isAlreadyAFriend",query="from SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.senderId = :senderId"),
@NamedQuery(name="Friends.getIdsOfUserFriends",query="SELECT answers.senderId from SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.allow = :allow"),
@NamedQuery(name="SlambookAnswers.userFriendsAnswers",query="FROM SlamBookAnswers answers WHERE answers.userInfo.userId = :userId"),
@NamedQuery(name="SlambookAnswers.previewFriendsAnswers",query="FROM SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.senderId = :senderId"),
@NamedQuery(name="SlambookAnswers.isAFriend",query="SELECT answers.allow FROM SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.senderId = :senderId"),
@NamedQuery(name="SlambookAnswers.getSingleFriendsAnswers",query="FROM SlamBookAnswers answers WHERE answers.userInfo.userId = :userId AND answers.senderId = :senderId")

})

public class SlamBookAnswers implements Serializable {
    
    
    @Id
    @GeneratedValue        
    private int answerId;
    
    int senderId;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private UserInfo userInfo;
    
    Boolean allow;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateSend;
    
    @Transient
    String name;
    
    @Transient
    int currentProfilePic;
    
    @Transient
    private int receiverId;
    
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    String ans5;
    String ans6;
    String ans7;
    String ans8;
    String ans9;
    String ans10;
    String ans11;
    String ans12;
    String ans13;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    
    public Boolean getAllow() {
        return allow;
    }

    public void setAllow(Boolean allow) {
        this.allow = allow;
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
    
    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getAns5() {
        return ans5;
    }

    public void setAns5(String ans5) {
        this.ans5 = ans5;
    }

    public String getAns6() {
        return ans6;
    }

    public void setAns6(String ans6) {
        this.ans6 = ans6;
    }

    public String getAns7() {
        return ans7;
    }

    public void setAns7(String ans7) {
        this.ans7 = ans7;
    }

    public String getAns8() {
        return ans8;
    }

    public void setAns8(String ans8) {
        this.ans8 = ans8;
    }

    public String getAns9() {
        return ans9;
    }

    public void setAns9(String ans9) {
        this.ans9 = ans9;
    }

    public String getAns10() {
        return ans10;
    }

    public void setAns10(String ans10) {
        this.ans10 = ans10;
    }

    public String getAns11() {
        return ans11;
    }

    public void setAns11(String ans11) {
        this.ans11 = ans11;
    }

    public String getAns12() {
        return ans12;
    }

    public void setAns12(String ans12) {
        this.ans12 = ans12;
    }

    public String getAns13() {
        return ans13;
    }

    public void setAns13(String ans13) {
        this.ans13 = ans13;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
    
    
    
    
}
