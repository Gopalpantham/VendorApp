package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class UserController {
	@Autowired
private IUserService service;
	@Autowired
	private CodeUtil code;
	@Autowired
	private CommonUtil common;
	@RequestMapping(value="/showu")
	public String showu(){
		return "UserRegister";
	}
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String saveu(@ModelAttribute("u")User u,ModelMap map){
		//generate Pwd
				String pwd=code.genPwd();
				//set this to model attribute
				u.setPwd(pwd);
				//save into db
				int uId=service.saveUser(u);
			/*	//send email
				String text="Welcome to u : "+u.getUserName()
						+", Login Id is: "+u.getEmail()
					//	+"  or "+u.getMobileNum()
						+", password is: "+u.getPwd();
*/
				/*boolean flag=common.sendEmail(u.getEmail(), "u Created...", text);
				//message to UI
				String message="user '"+uId+"' Created successfully";
				if(flag) message+=", email also sent.";
				else message+=", email sending failed!";
*/
				map.addAttribute("message",uId);
		return "UserRegister";
	}
}
