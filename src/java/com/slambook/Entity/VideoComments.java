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

    @NamedQuery(name = "VideoComments.getVideoComments",query = "FROM VideoComments comments WHERE comments.videos.videoId = :videoId"),
    @NamedQuery(name = "VideoComments.getVideoCommentsCount",query = "SELECT COUNT(comments.commentId) FROM VideoComments comments WHERE comments.videos.videoId = :videoId")

})
public class VideoComments implements Serializable {
    
    @Id
    @GeneratedValue
    private int commentId;
    
    private int commenterId;
    
    @ManyToOne
    @JoinColumn(name="videoId")
    private Videos videos;

    
    @Transient
    private int currentProfilePicId;
    private String commentText;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date commentDate;
    
    @Transient
    private String name;
    @Transient
    private int userId;
    @Transient
    private int videoId;

   
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(int commenterId) {
        this.commenterId = commenterId;
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
        return commentDate;
    }

    public void setDate(Date date) {
        this.commentDate = date;
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

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
    
    
    
}
