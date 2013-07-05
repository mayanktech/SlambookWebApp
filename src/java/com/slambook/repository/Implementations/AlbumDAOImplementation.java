/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.Album;
import com.slambook.repository.Interfaces.AlbumDAOInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mayank
 */
@Repository
public class AlbumDAOImplementation implements AlbumDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
   
    
    @Override
    public int addAlbum(Album album) {
        
    sessionFactory.getCurrentSession().save(album);
    return album.getAlbumId();
        
    }

    @Override
    public void updateAlbum(Album album) {
        
       sessionFactory.getCurrentSession().update(album);
        
    }

    @Override
    public int getAlbumCoverImage(int albumId) {
        
     Query query = sessionFactory.getCurrentSession().getNamedQuery("Album.getAlbumCoverImage");
     query.setInteger("albumId", albumId);
     int coverImage;
     coverImage = (Integer)query.list().get(0);
     
     
     return coverImage;
        
    }

    @Override
    public int getAlbumImageCount(int albumId) {
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Album.getAlbumImageCount");
        query.setInteger("albumId",albumId);
        int imageCount = ((Long)query.uniqueResult()).intValue();
        return imageCount;
     
    }

    @Override
    public void deleteAlbum(int albumId) {
        
      Album album = (Album) sessionFactory.getCurrentSession().get("Album", albumId);
      sessionFactory.getCurrentSession().delete(album);
      
    
    }
    

    @Override
  
    public ArrayList getAlbums(int userId, int clickTimes) {
         
        int start = 0;
    int end = 0;
    
    if(clickTimes == 0){
    
    start = 0;
    end = 4;
    
    }
    else {
    
    start = 4 * clickTimes;
    end = 4;
    
    }
   
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Album.getUserAlbums");
        query.setInteger("userId",userId);
        query.setFirstResult(start);
        query.setMaxResults(end);
        return (ArrayList) query.list();
        
        
    }

    @Override
    public ArrayList getAllAlbums(int userId) {
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Album.getAllAlbumName");
        query.setInteger("userId",userId);
        return (ArrayList) query.list();
        
    }

    @Override
    public String getAlbumName(int albumId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Album.getAlbumName");
        query.setInteger("albumId",albumId);
        String albumName = (String)query.uniqueResult();
        return albumName;
     
    }
    
}
