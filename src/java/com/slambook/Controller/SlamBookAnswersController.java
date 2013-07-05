/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.SlamBookAnswers;
import com.slambook.Entity.UserInfo;
import com.slambook.services.Interfces.SlamBookAnswersDAOServiceInterface;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mayank
 */
@Controller
@RequestMapping("/SlamBookAnswers")
public class SlamBookAnswersController {
    
    @Autowired
    private SlamBookAnswersDAOServiceInterface slamBookAnswersDAOServiceInterface;
    
    @RequestMapping(value = "/addAnswers" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addAnswers(SlamBookAnswers slamBookAnswers, BindingResult bindingResult,HttpSession session){
    
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(slamBookAnswers.getReceiverId());
        
        slamBookAnswers.setUserInfo(userInfo);
        
        slamBookAnswers.setAllow(Boolean.TRUE);
        
        slamBookAnswers.setSenderId(userId);
        slamBookAnswersDAOServiceInterface.addAnswers(slamBookAnswers);
    
    }
    
    @RequestMapping(value = "/previewFriendAnswers" ,method = RequestMethod.POST)
    public String previewFriendAnswers(@RequestParam("userId") int userId,@RequestParam("friendId") int friendId,Model model ){
    
        SlamBookAnswers slamBookAnswers = slamBookAnswersDAOServiceInterface.previewFriendAnswers(userId, friendId);
        model.addAttribute("answers", slamBookAnswers);
        return "previewAnswers";
       
    }
    
}
