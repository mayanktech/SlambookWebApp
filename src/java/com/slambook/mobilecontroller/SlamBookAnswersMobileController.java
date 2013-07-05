/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.mobilecontroller;

import com.slambook.Entity.SlamBookAnswers;
import com.slambook.Entity.SlamBookAnswersMobile;
import com.slambook.services.Interfces.SlamBookAnswersDAOServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/mobile/SlamBookAnswers")
public class SlamBookAnswersMobileController {
    
    @Autowired
    private SlamBookAnswersDAOServiceInterface slamBookAnswersDAOServiceInterface;
    
    @RequestMapping(value = "/addAnswers" ,method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void addAnswers(@RequestBody SlamBookAnswers slamBookAnswers){
    
     slamBookAnswersDAOServiceInterface.addAnswers(slamBookAnswers);
    
    }
    
    @RequestMapping(value = "/previewFriendAnswers/{userId}/(friendId)" ,method = RequestMethod.GET)
    public @ResponseBody SlamBookAnswers previewFriendAnswers(@PathVariable("userId") int userId,@PathVariable("friendId") int friendId){
    
        SlamBookAnswers slamBookAnswers = slamBookAnswersDAOServiceInterface.previewFriendAnswers(userId, friendId);
        
        return slamBookAnswers;
       
    }
    
    @RequestMapping(value = "/getSingleFriendAnswers/{userId}/(friendId)" ,method = RequestMethod.GET)
    @ResponseBody 
    public ResponseEntity <com.slambook.Entity.SlamBookAnswersMobile> getSingleFriendAnswers(@PathVariable("userId") int userId,@PathVariable("friendId") int friendId){
    
        SlamBookAnswers slamBookAnswers = slamBookAnswersDAOServiceInterface.getSingleFriendsAnswers(userId, friendId);
        SlamBookAnswersMobile slamBookAnswersMobile = new SlamBookAnswersMobile();
        
        slamBookAnswersMobile.setAns1(slamBookAnswers.getAns1());
        slamBookAnswersMobile.setAns2(slamBookAnswers.getAns2());
        slamBookAnswersMobile.setAns3(slamBookAnswers.getAns3());
        slamBookAnswersMobile.setAns4(slamBookAnswers.getAns4());
        slamBookAnswersMobile.setAns5(slamBookAnswers.getAns5());
        slamBookAnswersMobile.setAns6(slamBookAnswers.getAns6());
        slamBookAnswersMobile.setAns7(slamBookAnswers.getAns7());
        slamBookAnswersMobile.setAns8(slamBookAnswers.getAns8());
        slamBookAnswersMobile.setAns9(slamBookAnswers.getAns9());
        slamBookAnswersMobile.setAns10(slamBookAnswers.getAns10());
        slamBookAnswersMobile.setAns11(slamBookAnswers.getAns11());
        slamBookAnswersMobile.setAns12(slamBookAnswers.getAns12());
        slamBookAnswersMobile.setAns13(slamBookAnswers.getAns13());
        slamBookAnswersMobile.setAllow(slamBookAnswers.getAllow());
        slamBookAnswersMobile.setAnswerId(slamBookAnswers.getAnswerId());
        slamBookAnswersMobile.setCurrentProfilePic(slamBookAnswers.getCurrentProfilePic());
        slamBookAnswersMobile.setDateSend(slamBookAnswers.getDateSend());
        slamBookAnswersMobile.setName(slamBookAnswers.getName());
        slamBookAnswersMobile.setSenderId(slamBookAnswers.getSenderId());
        slamBookAnswersMobile.setUserId(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        ResponseEntity<com.slambook.Entity.SlamBookAnswersMobile> ent = new ResponseEntity<com.slambook.Entity.SlamBookAnswersMobile>(slamBookAnswersMobile,headers,HttpStatus.OK);
        return ent;
       
    }
    
}
