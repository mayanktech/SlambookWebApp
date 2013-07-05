/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slambook.Controller;

import com.slambook.Entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mayank
 */
@Controller
public class Demo {
    
   
    
    @RequestMapping("/")
	public String Example(Model model) {

		model.addAttribute("user", new UserInfo());
                
		return "index";
	}
    
}
