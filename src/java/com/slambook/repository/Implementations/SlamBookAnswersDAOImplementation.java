/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.repository.Implementations;

import com.slambook.Entity.SlamBookAnswers;
import com.slambook.repository.Interfaces.SlamBookAnswersDAOInterface;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mayank
 */
@Repository
public class SlamBookAnswersDAOImplementation implements SlamBookAnswersDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void addAnswers(SlamBookAnswers slamBookAnswers) {
       
        sessionFactory.getCurrentSession().save(slamBookAnswers);
    }

    @Override
    public ArrayList userFriendsAnswers(int userId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("SlambookAnswers.userFriendsAnswers");
        query.setInteger("userId",userId);
        return (ArrayList) query.list();
    
    }

    @Override
    public SlamBookAnswers previewFriendAnswers(int userId, int friendId) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("SlambookAnswers.previewFriendsAnswers");
        query.setInteger("userId",userId);
        query.setInteger("senderId",friendId);
        return (SlamBookAnswers) query.uniqueResult();
    
    }

    @Override
    public SlamBookAnswers getSingleFriendsAnswers(int userId, int friendId) {
       Query query = sessionFactory.getCurrentSession().getNamedQuery("SlambookAnswers.getSingleFriendsAnswers");
        query.setInteger("userId",userId);
        query.setInteger("senderId",friendId);
        return (SlamBookAnswers) query.uniqueResult();
    
        
    }
    
}
