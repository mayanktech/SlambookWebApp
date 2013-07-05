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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mayank
 */
@Entity
@NamedQueries({

    @NamedQuery(name = "ProfilePic.getProfilePics",query = "FROM ProfilePic userProfilePic WHERE userProfilePic.userInfo.userId = :userId"),
    @NamedQuery(name = "ProfilePic.getCurrentProfilePic",query = "SELECT userProfilePic.profilePicId FROM ProfilePic userProfilePic WHERE userProfilePic.userInfo.userId = :userId ORDER BY userProfilePic.profilePicId DESC LIMIT 1"),
    

})

public class ProfilePic implements Serializable {
    
    @Id
    @GeneratedValue
    private int profilePicId;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private UserInfo userInfo;
    
    @Transient
    private MultipartFile imagefile;
    
    public int getProfilePicId() {
        return profilePicId;
    }

    public void setProgilePicId(int profilePicId) {
        this.profilePicId = profilePicId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public MultipartFile getImagefile() {
        return imagefile;
    }

    public void setImagefile(MultipartFile imagefile) {
        this.imagefile = imagefile;
    }
    
    
    
    
}
