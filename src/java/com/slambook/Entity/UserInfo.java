/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Mayank
 */
@Entity
@NamedQueries({

@NamedQuery(name="Friends.searchFriendsByName",query="SELECT user.userId,user.firstName,user.lastName from UserInfo user where CONCAT(user.firstName,user.lastName) LIKE (:searchString)"),
@NamedQuery(name="Friends.searchFriendsByEmail",query="SELECT user.userId,user.firstName,user.lastName from UserInfo user where user.email = :email"),
@NamedQuery(name="UserInfo.getEmailById",query="SELECT user.email from UserInfo user where user.userId = :userId"),
@NamedQuery(name="UserInfo.checkEmail",query="SELECT user.email from UserInfo user where user.email LIKE :email"),
@NamedQuery(name="UserInfo.getUserIdByEmail",query="SELECT user.userId from UserInfo user where user.email = :email"),
@NamedQuery(name="UserInfo.getUserByEmail",query="From UserInfo user where user.email = :email"),
@NamedQuery(name="UserInfo.getUserInfoById",query="SELECT user.userId,user.accountStatus,user.birthday,user.braggingRights,user.college,user.email,user.firstName,user.gender,user.introduction,user.lastSessionDestroyedTime,user.lookingFor,user.occupation,user.password,user.placesLived,user.relationshipStatus,user.school,user.tagline,user.website from UserInfo user where user.userId = :userId"),
@NamedQuery(name="UserInfo.updateUserInfo",query="UPDATE UserInfo user SET user.tagline=:tagline , user.introduction=:introduction ,user.braggingRights=:braggingRights , user.placesLived=:placesLived , user.lookingFor=:lookingFor , user.birthday=:birthday , user.email=:email , user.relationshipStatus=:relationshipStatus , user.school=:school , user.college=:college , user.website=:website")

})


public class UserInfo implements  Serializable {
    
    @Id
    @GeneratedValue
    private int userId;
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String birthday;
    private String school;
    private String college;
    private String relationshipStatus;
    private String occupation;
    private String website;
    private String tagline;
    private String introduction;
    private String braggingRights;
    private String placesLived;
    private String lookingFor;
    private String accountStatus;
    private String verificationKey;
    
    
    @Transient
    private int profilePic;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastSessionDestroyedTime;

    
    @OneToMany(mappedBy="userInfo",fetch=FetchType.LAZY)
    private List <com.slambook.Entity.Album> albumList;
    
    @OneToMany(mappedBy="userInfo",fetch=FetchType.LAZY)
    private List <com.slambook.Entity.Messages>messageList;
    
    @OneToMany(mappedBy="userInfo",fetch=FetchType.LAZY)
    private List <com.slambook.Entity.SlamBookAnswers>slambookAnswersList;
    
    @OneToMany(mappedBy="userInfo",fetch=FetchType.LAZY)
    private List <com.slambook.Entity.Videos>videoList;
    
    @OneToMany(mappedBy="userInfo",fetch=FetchType.LAZY)
    private List <com.slambook.Entity.ProfilePic>profilePicList;
    
    @OneToOne(mappedBy = "userInfo")
    private UserDesign userDesign;
   
    
    
    
//    @Transient
//    private ArrayList friendAddAlbumNotification;
//    
//    
//    @Transient
//    private ArrayList friendAddVideoNotification;
//    
//    @Transient
//    private ArrayList friendAddImageNotification;
//    
//    @Transient
//    private ArrayList friendAddProfilePicNotification;
//    
    @Transient
    private ArrayList FriendsAddStuffNotifications;
    
    @Transient
    private ArrayList friendRequestNotifications;
    
    @Transient
    private ArrayList allalbumsList;
    
    @Transient
    private ArrayList friendsList;
    
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBraggingRights() {
        return braggingRights;
    }

    public void setBraggingRights(String braggingRights) {
        this.braggingRights = braggingRights;
    }

    public String getPlacesLived() {
        return placesLived;
    }

    public void setPlacesLived(String placesLived) {
        this.placesLived = placesLived;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getVerificationKey() {
        return verificationKey;
    }

    public void setVerificationKey(String verificationKey) {
        this.verificationKey = verificationKey;
    }

    public Date getLastSessionDestroyedTime() {
        return lastSessionDestroyedTime;
    }

    public void setLastSessionDestroyedTime(Date lastSessionDestroyedTime) {
        this.lastSessionDestroyedTime = lastSessionDestroyedTime;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public List<com.slambook.Entity.Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<com.slambook.Entity.Album> albumList) {
        this.albumList = albumList;
    }

    public List <com.slambook.Entity.Messages> getMessageList() {
        return messageList;
    }

    public void setMessageList(List <com.slambook.Entity.Messages> messageList) {
        this.messageList = messageList;
    }

    public List <com.slambook.Entity.SlamBookAnswers> getSlambookAnswersList() {
        return slambookAnswersList;
    }

    public void setSlambookAnswersList(List <com.slambook.Entity.SlamBookAnswers> slambookAnswersList) {
        this.slambookAnswersList = slambookAnswersList;
    }

    public List <com.slambook.Entity.Videos> getVideoList() {
        return videoList;
    }

    public void setVideoList(List <com.slambook.Entity.Videos> videoList) {
        this.videoList = videoList;
    }

   
    public List <com.slambook.Entity.ProfilePic> getProfilePicList() {
        return profilePicList;
    }

    public void setProfilePicList(List <com.slambook.Entity.ProfilePic> profilePicList) {
        this.profilePicList = profilePicList;
    }

    public ArrayList getUserNotifications() {
        return FriendsAddStuffNotifications;
    }

    public void setUserNotifications(ArrayList FriendsAddStuffNotifications) {
        this.FriendsAddStuffNotifications = FriendsAddStuffNotifications;
    }

    public ArrayList getFriendRequestNotifications() {
        return friendRequestNotifications;
    }

    public void setFriendRequestNotifications(ArrayList friendRequestNotifications) {
        this.friendRequestNotifications = friendRequestNotifications;
    }

    public ArrayList getFriendsAddStuffNotifications() {
        return FriendsAddStuffNotifications;
    }

    public void setFriendsAddStuffNotifications(ArrayList FriendsAddStuffNotifications) {
        this.FriendsAddStuffNotifications = FriendsAddStuffNotifications;
    }

    public ArrayList getAllalbumsList() {
        return allalbumsList;
    }

    public void setAllalbumsList(ArrayList allalbumsList) {
        this.allalbumsList = allalbumsList;
    }

    public ArrayList getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(ArrayList friendsList) {
        this.friendsList = friendsList;
    }

    public UserDesign getUserDesign() {
        return userDesign;
    }

    public void setUserDesign(UserDesign userDesign) {
        this.userDesign = userDesign;
    }
    
    
    

}
