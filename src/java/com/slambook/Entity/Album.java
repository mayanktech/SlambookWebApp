/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;



/**
 *
 * @author Mayank
 */

@Entity
@NamedQueries({

    @NamedQuery(name="Album.getUserAlbums",query="from Album userAlbum where userAlbum.userInfo.userId = :userId ORDER BY userAlbum.albumId DESC "),
    @NamedQuery(name="Album.getAlbumName",query="select useralbum.albumName from Album useralbum where useralbum.albumId = :albumId"),
    @NamedQuery(name="Album.getAllAlbumName",query="select useralbum.albumName from Album useralbum where useralbum.userInfo.userId = :userId")

})
public class Album implements Serializable {
    
    @Id
    @GeneratedValue
    int albumId;
    
    
    String albumName;
    String albumSummary;
    String albumDate;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private UserInfo userInfo;
    
    @OneToMany(mappedBy="album")
    private List<com.slambook.Entity.Images> imagesList;
    
    @Transient
    int coverImageId;
    
    
    @Transient
    int albumImageCount;
    
    
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
    
    public String getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(String albumDate) {
        this.albumDate = albumDate;
    }

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<com.slambook.Entity.Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<com.slambook.Entity.Images> imagesList) {
        this.imagesList = imagesList;
    }

    
    
    
    
}
