/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

/**
 *
 * @author Mayank
 */
public class AlbumMobile {
    
    private int albumId;
    private String albumName;
    private String albumSummary;
    private String albumDate;
    private int userId;
    private int coverImageId;
    private int albumImageCount;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumSummary() {
        return albumSummary;
    }

    public void setAlbumSummary(String albumSummary) {
        this.albumSummary = albumSummary;
    }

    public String getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(String albumDate) {
        this.albumDate = albumDate;
    }

    public int getCoverImageId() {
        return coverImageId;
    }

    public void setCoverImageId(int coverImageId) {
        this.coverImageId = coverImageId;
    }

    public int getAlbumImageCount() {
        return albumImageCount;
    }

    public void setAlbumImageCount(int albumImageCount) {
        this.albumImageCount = albumImageCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    
    
}
