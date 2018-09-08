package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractExcelView{


	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
	
	res.addHeader("Content-Disposition", "attachment;filename=Vendor.xls");
	@SuppressWarnings("unchecked")
	List<Vendor> vens=(List<Vendor>)map.get("vens");
	HSSFSheet sheet=book.createSheet("vens");
	setHead(sheet);
	setbody(sheet,vens);
	}
		
	
	private void setHead(HSSFSheet sheet){
		int rownum=0;
		HSSFRow row=sheet.createRow(rownum);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("CODE");
	row.createCell(2).setCellValue("NAME");
	row.createCell(3).setCellValue("vTYPE");
	row.createCell(4).setCellValue("ADDRESS");
	row.createCell(5).setCellValue("venIdTye");
	row.createCell(6).setCellValue("VidNo");

	}
	private void setbody(HSSFSheet sheet,List<Vendor> vens){
		int rownum=1;
	for(Vendor ven:vens){
		 HSSFRow row=sheet.createRow(rownum++);
		 row.createCell(0).setCellValue(ven.getVenId());
		 row.createCell(1).setCellValue(ven.getVenCode());
		 row.createCell(2).setCellValue(ven.getVenName());
		 row.createCell(3).setCellValue(ven.getVenAddr());
		 row.createCell(4).setCellValue(ven.getVenType());
		 row.createCell(5).setCellValue(ven.getVenIdType());
		 row.createCell(6).setCellValue(ven.getVenDsc());
		}
		
	}
}
