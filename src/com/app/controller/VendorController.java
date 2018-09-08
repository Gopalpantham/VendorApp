package com.app.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Vendor;
import com.app.opt.VendorOpt;
import com.app.service.IVendorService;
import com.app.util.VendorUtil;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private VendorUtil util;
	@Autowired
	private ServletContext context;
	@Autowired
	private VendorOpt opt;
	@RequestMapping("/regVen")
	public String showPage(){
		return "VendorReg";
	}
@RequestMapping(value="/insertven",method=RequestMethod.POST)
public String saveVendor(@ModelAttribute("vendor")Vendor ven,ModelMap map){
	int venId=service.saveVendor(ven);
	String Message="Saved with ID Successfully"+venId;
	map.addAttribute("msg",Message);
	return "VendorReg";
}
@RequestMapping(value="viewAllvens")
public String viewVendor(ModelMap map){
	List<Vendor> vens=service.getAllVendors();
	map.addAttribute("vendor", vens);
	return "VendorData";
}
@RequestMapping("/deleteVen")
public String deleteVendor(@RequestParam("venId")int VenId){
	service.deleteVendor(VenId);
	return "redirect:viewAllvens";
	
}
@RequestMapping("/editVen")
public String editVendor(@RequestParam("venId")int VenId,ModelMap map){
   Vendor vendor=service.getVendorById(VenId);
    opt.addUiComponents(map);
   map.addAttribute("ven",vendor);
     	return "VendorDataEdit";
}
@RequestMapping("/updateVen")
public String updateVendor(@ModelAttribute("vendor")Vendor ven,ModelMap map){	
	service.updateVendor(ven);
	return "redirect:viewAllvens";
	
}
@RequestMapping("/venExcelExport")
public String ShowExcelData(ModelMap map){
	List<Vendor> vens=service.getAllVendors();
	map.addAttribute("vens",vens);
	return "venExcelView";
	
}
@RequestMapping("/venPdfExport")
public String ShowPdfData(ModelMap map){
	List<Vendor> vens=service.getAllVendors();
	map.addAttribute("vens", vens);
	return "venPdfview";
}
@RequestMapping("/showVensReports")
public String generatesReports(){
	List<Object[]> li=service.getVendorTypeCount();
	String path=context.getRealPath("/");
	util.generatePie(path,li);
	util.generateBarcharts(path,li);
	return "VendorReports";
}
}
