package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
import com.app.util.CustomerUtil;



@Controller
public class CustomerController {
@Autowired
 private ICustomerService service;
@Autowired
private CustomerUtil util;
@Autowired
private ServletContext context;
@Autowired
private CodeUtil codeUtil;
@Autowired
private CoDecUtil coDecUtil;
@Autowired
private CommonUtil commonUtil;

@RequestMapping("/insertCust")
  public String showPage(){
	return "CustomerReg";
  }
//2. save data and send email
	@RequestMapping(value="/custReg",method=RequestMethod.POST)
	public String saveCust(
			@ModelAttribute("customer")Customer cust,
			ModelMap map)
	{
		//generate PWD,TOKEN
		String pwd=codeUtil.genPwd();
		String token=codeUtil.genToken();
	
		//encode pwd,token
		String encPwd=coDecUtil.doEncode(pwd);
		String encToken=coDecUtil.doEncode(token);
		
		//set encoded pwd,token to cust model object
		cust.setPassword(encPwd);
		cust.setAccTock(encToken);
		
		//save cust object
		int custId=service.saveCustomer(cust);
		
		//send email
		String text="Welcome to Customer : " +cust.getCustName()
				+" , your ID is  : "+cust.getCustEmail()
				+" , password is : "+pwd
				+" , Token is    : "+token
				+" , Type is     : "+cust.getCustType();
		
		boolean flag=commonUtil.sendEmail(cust.getCustEmail(), "Welcome to Customer", text);
		
		//final message
		String message="Customer Saved with Id:"+custId;
		
		if(flag)
			message+=",Email also sent successfully";
		else
			message+=",Email sending failed";

		//send message to UI
		map.addAttribute("msg", message);
		
		return "CustomerReg";
	}
	
	

	@RequestMapping("/viewAllCus")
	public String getAllCust(ModelMap map){
	List <Customer> l=service.getAllCustomers();
	map.addAttribute("customer",l);
		return "CustomerData";		
	}

	@RequestMapping("/deleteCus")
	public String deleteCustomer(@RequestParam("custId")int id,ModelMap map){
		Customer cust=service.getCustomerById(id);
		
		commonUtil.sendEmail(cust.getCustEmail(),"Account has been deleted"
				+ "","Your Account with Id"+cust.getCustId()+"Has been Removed From the Application");
		
		service.deleteCustomer(id);
		
		return "redirect:viewAllCus";
	}
	
    @RequestMapping("/editCus")
	public String editCustomer(@RequestParam("custId")int custId,ModelMap map){
    Customer customer= service.getCustomerById(custId);
    map.addAttribute("cust",customer);
    return "CustomerDataEdit";
}
    @RequestMapping(value="/updateCus",method=RequestMethod.POST)
    public String updateCustomer(@ModelAttribute("customer")Customer cust){
    	//generate PWD,TOKEN
    			String pwd=codeUtil.genPwd();
    			String token=codeUtil.genToken();
    		
    			//encode pwd,token
    			String encPwd=coDecUtil.doEncode(pwd);
    			String encToken=coDecUtil.doEncode(token);
    			
    			//set encoded pwd,token to cust model object
    			cust.setPassword(encPwd);
    			cust.setAccTock(encToken);
    			
    			//save cust object
    			service.updateCustomer(cust);
    			
    			//send email
    			String text="Account has been updated : " +cust.getCustName()
    					+" , your ID is  : "+cust.getCustEmail()
    					+" , password is : "+pwd
    					+" , Token is    : "+token
    					+" , Type is     : "+cust.getCustType();
    			
    			boolean flag=commonUtil.sendEmail(cust.getCustEmail(), "updated account", text);
    			
    			//final message
    			String message="Customer Saved with Id:";
    			
    			if(flag)
    				message+=",Updated Email also sent successfully";
    			else
    				message+=",Email sending failed";


    	return "redirect:viewAllCus";
    	
    }
    @RequestMapping("/custExcelExport")
    public String ExcelData(ModelMap map){
    	List<Customer> custs=service.getAllCustomers();
    	map.addAttribute("custs",custs);
    	return "custExcelView";

    }
    @RequestMapping("/custPdfExport")
    public String showPdfData(ModelMap map){
    	List<Customer> custs=service.getAllCustomers();
    	map.addAttribute("custs",custs);
    	return "custPdfView"; 

    }
    @RequestMapping("/custReportsbar")
    public String generateReports(){
    	List<Object[]> list=service.getCustomerTypeByCount();
    	String path=context.getRealPath("/");
    	util.generatePie(path,list);
    	util.generateBarcharts(path,list);
    	return "CustomerReports";
    }
}	
//3. display data at UI

	//4. show EDI PAGE
	
	//5. do Update operation
	//generate new details and 
	//update in DB also send email
	
	//6. delete customer
	//send email - you are removed from application 
	
	//7. Export data to Excel and PDF
	// do not display ToKen and PWD 
	
	//8. Reports
	//PIE/BAR - custType
	
