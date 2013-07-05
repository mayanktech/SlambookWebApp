/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 *
 * @author Mayank
 */

@Entity
@NamedQueries({

    @NamedQuery(name="ImageLikes.removeLike",query="DELETE FROM ImageLikes likes WHERE likes.images.imageId = :imageId AND likes.userId = :userId"),
     @NamedQuery(name="ImageLikes.getImageLikes",query="FROM ImageLikes likes WHERE likes.images.imageId = :imageId"),
     @NamedQuery(name="ImageLikes.getImageLikesCount",query="SELECT COUNT(likes.imageLikeId) FROM ImageLikes likes WHERE likes.images.imageId = :imageId"),
     @NamedQuery(name="ImageLikes.isAlreadyLiked",query="FROM ImageLikes likes WHERE likes.images.imageId = :imageId AND likes.userId = :userId")   
})
public class ImageLikes implements Serializable {
    
    @Id
    @GeneratedValue
    private int imageLikeId;
    
    @ManyToOne
    @JoinColumn(name="imageId")
    private Images images;
   
    @Transient
    private int friendId;
    @Transient
    private String friendName;
    @Transient
    private int currentProfilePic;
    
    private int userId;
    
    @Transient
    private int albumId;
    
    @Transient
    private int imageId;
    
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getCurrentProfilePic() {
        return currentProfilePic;
    }

    public void setCurrentProfilePic(int currentProfilePic) {
        this.currentProfilePic = currentProfilePic;
    }

    public int getImageLikeId() {
        return imageLikeId;
    }

    public void setImageLikeId(int imageLikeId) {
        this.imageLikeId = imageLikeId;
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
