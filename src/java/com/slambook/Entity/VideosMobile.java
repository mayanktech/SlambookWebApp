/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

/**
 *
 * @author Mayank
 */
public class VideosMobile {
    private int videoId;
    private int userId;
    private String videoUrl;
    private String videoDescription;
    private int videoLikesCount;
    private int videoCommentsCount;
    private Boolean alreadyLiked;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public int getVideoLikesCount() {
        return videoLikesCount;
    }

    public void setVideoLikesCount(int videoLikesCount) {
        this.videoLikesCount = videoLikesCount;
    }

    public int getVideoCommentsCount() {
        return videoCommentsCount;
    }

    public void setVideoCommentsCount(int videoCommentsCount) {
        this.videoCommentsCount = videoCommentsCount;
    }

    public Boolean getAlreadyLiked() {
        return alreadyLiked;
    }

    public void setAlreadyLiked(Boolean alreadyLiked) {
        this.alreadyLiked = alreadyLiked;
    }
    
    
    
}
