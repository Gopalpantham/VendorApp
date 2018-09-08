package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CoDecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private CoDecUtil codecUtil;
	
	public boolean isCustTypeSeller(Customer cust){
		return "SELLER".equalsIgnoreCase(cust.getCustType());
	}
	
	public boolean isCustTypeConsumer(Customer cust){
		return "CONSUMER".equalsIgnoreCase(cust.getCustType());
	}
	
	
	public boolean isPwdAndTokenValid(String reqPwd,String reqToken,Customer cust){
		boolean flag=false;
		//1.read pwd,token from DB(cust)
		String encPwd=cust.getPassword();
		String encToken=cust.getAccTock();
		
		//2.do decode pwd,token
		String dbPwd=codecUtil.doDecode(encPwd);
		String dbToken=codecUtil.doDecode(encToken);
		
		//3. compare DB and req pwd,tokens
		if(dbPwd.equals(reqPwd) && dbToken.equals(reqToken))
			flag=true;
		
		//4.return flag 
		return flag;
	}
	
}
