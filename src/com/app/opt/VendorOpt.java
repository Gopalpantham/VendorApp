package com.app.opt;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class VendorOpt {

	public List<String> getVendorTypes(){
		return Arrays.asList("CONTRACT","FULLTIME","PARTTIME");
	}
	
	public List<String> getVendorIdTypes(){
		return Arrays.asList("PAN","VOTERID","OTHER");
	}
	
	
	public void addUiComponents(ModelMap map){
		map.addAttribute("venTypesList", getVendorTypes());
		map.addAttribute("venIdTypesList", getVendorIdTypes());
	}
	
	
	
	
	
}
