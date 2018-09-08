package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/item")
public class ItemServiceProvider {
	
	
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemService service;
	@Autowired
	private ICustomerService custservice;
	@Autowired
	private CustomerValidator custvalidator;
	
	
	@POST
	@Path("/save")
	public String saveItem(
		@HeaderParam("user")String userName,
		@HeaderParam("password")String password,
		@HeaderParam("token")String token,
		String itemJson	)
	{
		
		//basic null or empty validation check
		if(userName==null || "".equals(userName.trim()))
			return "Please provide Username";
		if(password==null || "".equals(password.trim()))
			return "Please provide password";
		if(token==null || "".equals(token.trim()))
			return "Please provide token";
		if(itemJson==null || "".equals(itemJson.trim()))
			return "Please provide JSON for Item";
		
		
		
		//1. verify customer using email(username)
		Customer cust=custservice.getCustomerByEmail(userName);
		if(cust==null){
			return "Invalid Username provided..please try with valid username";
		}
		
		
		//2. verify req pwd,token with cust(DB) details
		//using custvalidator
		boolean flag=custvalidator.isPwdAndTokenValid(password, token, cust);
		if(!flag){ //flag==false
			return "Invalid password/token provided...";
		}
		
		
		//3. also check custType seller or not?
		flag=custvalidator.isCustTypeSeller(cust);
		if(!flag){ //flag==false
			return "Only Seller Customer can do Item save";
		}
		
		//4.convert JSON to Object
		Object ob=jsonUtil.ConvertJsonToObject(itemJson, Item.class);
		if(ob==null)
			return "Invalid JSON Format for Item Data";
		Item item=null;
		if(ob instanceof Item){ //To avoid ClassCastException
			item=(Item)ob;
		}
		//link Item with Customer
		item.setCustId(cust.getCustId());
		//5.save Item
		int itemId=service.saveItem(item);
		
		//6. return final message
		String message="Item saved with Id:"+itemId;
		return message;
	}
	
}


