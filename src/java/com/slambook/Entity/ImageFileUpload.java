/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Entity;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mayank
 */
public class ImageFileUpload {
   
    private List <MultipartFile> upload;
    private int albumId;

    public List <MultipartFile> getUpload() {
        return upload;
    }

    public void setUpload(List <MultipartFile> upload) {
        this.upload = upload;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
    
    
    
}
