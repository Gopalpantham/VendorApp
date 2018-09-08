package com.app.controller;



import java.util.List;




import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {
	@Autowired
	private IDocumentService service;

	@RequestMapping("/showDocs")
	public String showDocs(ModelMap map){
		List<Object[]> obj=service.getDocIdAndName();
		map.addAttribute("docs", obj);
		return "Documents";

	}
	@RequestMapping(value="/uploadDoc",method=RequestMethod.POST)
	public String UploadDocument(@RequestParam("fileId")int fileId,
			@RequestParam("fileName")CommonsMultipartFile cmf){

		if(cmf!=null){
			Document doc=new Document();
			doc.setFileId(fileId);
			doc.setFileName(cmf.getOriginalFilename());
			doc.setFileData(cmf.getBytes());
			service.saveDocument(doc);
		}
		return "redirect:showDocs";


	}
	@RequestMapping("/downloadDoc")
	public void downloadDocument(@RequestParam("docId")int fileId,HttpServletResponse res){
		Document doc=service.getDocumentById(fileId);
		res.addHeader("Contentt-Disposition", "attachment);filename ="+doc.getFileName());
		try{
			FileCopyUtils.copy(doc.getFileData(),res.getOutputStream());

		}
		catch(Exception e){e.printStackTrace();
		}

	}}