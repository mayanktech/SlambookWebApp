/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.services.Interfces;

import com.slambook.Entity.SlamBookAnswers;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public interface SlamBookAnswersDAOServiceInterface {
    
    public void addAnswers(SlamBookAnswers slamBookAnswers);
    public ArrayList userFriendsAnswers(int userId);
    public SlamBookAnswers previewFriendAnswers(int userId,int friendId);
    public SlamBookAnswers getSingleFriendsAnswers(int userId, int friendId);
    
    
}
