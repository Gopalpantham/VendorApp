package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.model.Vendor;
import com.app.service.IItemService;

@Controller
public class ItemController {
    @Autowired
	private  IItemService service;
   @RequestMapping("/regItem")
    public String showitem(){
		return "ItemReg";	
   }	
	@RequestMapping(value="insertIt",method=RequestMethod.POST)
	public String insertItem(@ModelAttribute("item")Item it,ModelMap map){
		int itemId=service.saveItem(it);
		String Message="Saved item Successfully by"+itemId;
		map.addAttribute("msg", Message);
				return "ItemReg";
		
	}
 @RequestMapping("/viewAllItems")
	public String showItem(ModelMap map){
	 List<Item> li=service.getAllItems();
	 map.addAttribute("it",li);
		return "ItemData";

 }
@RequestMapping("/deleteItem") 
public String deleteItem(@RequestParam("itemId")int itemId){
	service.deleteItem(itemId);
	return "redirect:viewAllItems";
}
@RequestMapping("/editItem")
public String editItem(@RequestParam("itemId")int itemId,ModelMap map){
	Item item=service.getItemById(itemId);
	map.addAttribute("it", item);
	return "ItemDataEdit";
	
}
@RequestMapping("/updateItem")
public String updateItem(@ModelAttribute("item")Item it,ModelMap map){
service.updateItem(it);
return "redirect:viewAllItems";
}
@RequestMapping("/itemExcelExport")
public String showExcel(ModelMap map){
	List<Item> li=service.getAllItems();
	map.addAttribute("its",li);
	return "ItemExcel";
	
}
@RequestMapping("/itemPdfExport")
public String showPdf(ModelMap map){
List<Item> li=	service.getAllItems();
map.addAttribute("items", li);
	return "ItemPdf";
	
}
}