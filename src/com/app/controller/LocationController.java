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

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;



@Controller
public class LocationController   {
	@Autowired
	private ILocationService service;
	@Autowired
	private LocationUtil util;
	@Autowired
	private ServletContext context;
	@RequestMapping("/showLoc")
	public String showPage(){
		return "UserMenu";
	}
	@RequestMapping(value="/regLoc")
	private String locationRegister(){
		return "LocationReg";
	}
@RequestMapping(value="/locRegister",method=RequestMethod.POST)
public String saveLocation(@ModelAttribute("location")Location loc,ModelMap map){
	int locId=service.saveLocation(loc);
	String message="Saved with ID Successfully"+locId;
	map.addAttribute("msg",message);
	return "LocationReg";
}
@RequestMapping("/viewAlllocs")
public String getAllLocation(ModelMap map){
	List<Location> locs=service.getAllLocations();
	map.addAttribute("location",locs);
	return "LocationData";
}
@RequestMapping("/deleteLoc")
public String deleteLocation(@RequestParam("locId")int locId){
	service.deleteLocation(locId);
	return "redirect:viewAlllocs";
}
@RequestMapping("/editLoc")
public String editLocaiton(@RequestParam("locId")int locId,ModelMap map)
{
	Location location=service.getLocationById(locId);
    map.addAttribute("loc",location);
	return "LocationDataEdit";
}
@RequestMapping(value="/updateLoc",method=RequestMethod.POST)
public String updateLocation(@ModelAttribute("location")Location loc){
service.updateLocation(loc);
return "redirect:viewAlllocs";
}
@RequestMapping("/locExcelExport")
public String ExcelData(ModelMap map){
	List<Location> locs=service.getAllLocations();
	map.addAttribute("locs",locs);
	return "locExcelView";

}
@RequestMapping("/locPdfExport")
public String showPdfData(ModelMap map){
	List<Location> locs=service.getAllLocations();
	map.addAttribute("locs",locs);
	return "locPdfview"; 

}
@RequestMapping("/showReportsbar")
public String generateReports(){
	List<Object[]> list=service.getLocationTypeByCount();
	String path=context.getRealPath("/");
	util.generatePie(path,list);
	util.generateBarcharts(path,list);
	return "LocationReports";

}
}
