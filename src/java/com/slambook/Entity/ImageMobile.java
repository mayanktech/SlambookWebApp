/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

/**
 *
 * @author Mayank
 */
public class ImageMobile {
    private int imageId;
    private int imageLikesCount;
    private Boolean alreadyLiked;
    private int imageCommentCount;
    private String imageDescription;
    private int albumId;

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

   

    public int getImageLikesCount() {
        return imageLikesCount;
    }

    public void setImageLikesCount(int imageLikesCount) {
        this.imageLikesCount = imageLikesCount;
    }

    public Boolean getAlreadyLiked() {
        return alreadyLiked;
    }

    public void setAlreadyLiked(Boolean alreadyLiked) {
        this.alreadyLiked = alreadyLiked;
    }

    public int getImageCommentCount() {
        return imageCommentCount;
    }

    public void setImageCommentCount(int imageCommentCount) {
        this.imageCommentCount = imageCommentCount;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
    
    
    
}
