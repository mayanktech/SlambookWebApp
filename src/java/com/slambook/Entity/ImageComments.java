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

    @NamedQuery(name="ImageComments.getImageComments",query="FROM ImageComments userImageComments WHERE userImageComments.images.imageId = :imageId"),
    @NamedQuery(name="ImageComments.getImageCommentsCount",query="SELECT COUNT(userImageComments.commentId) FROM ImageComments userImageComments WHERE userImageComments.images.imageId = :imageId")
    
})
public class ImageComments implements Serializable {
    
    @Id
    @GeneratedValue
    private int commentId;
    
    private int commenterId;
    
    @ManyToOne
    @JoinColumn(name="imageId")
    private Images images;
    
    @Transient
    private int currentProfilePicId;
    
    private String commentText;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @Transient
    private String name;
    
    @Transient
    private int userId;
    
    @Transient
    private int albumId;
    
    @Transient
    private int imageId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    

    public int getCurrentProfilePicId() {
        return currentProfilePicId;
    }

    public void setCurrentProfilePicId(int currentProfilePicId) {
        this.currentProfilePicId = currentProfilePicId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(int commenterId) {
        this.commenterId = commenterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    
    
    
}
