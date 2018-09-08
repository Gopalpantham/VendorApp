package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Item;


public class ItemExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("Content-Disposition", "attachment;filename=ItemS.xls");
		@SuppressWarnings("unchecked")
		List<Item>Its=(List<Item>) map.get("its");
		HSSFSheet sheet=book.createSheet("ITEMS");
		setHead(sheet);
		setBody(sheet,Its);
	}
private void setHead(HSSFSheet sheet){
	int rownum=0;
	HSSFRow row=sheet.createRow(rownum);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("NAME");
	row.createCell(2).setCellValue("COST");
	row.createCell(3).setCellValue("DISCOUNT");
	row.createCell(4).setCellValue("CUSTOMER ID");
}
private void setBody(HSSFSheet sheet,List<Item> Its){
	int rownum=1;
	for(Item It:Its){
		HSSFRow row=sheet.createRow(rownum);
		row.createCell(0).setCellValue(It.getItemId());
		row.createCell(1).setCellValue(It.getItemName());
		row.createCell(2).setCellValue(It.getItemCost());
		row.createCell(3).setCellValue(It.getDiscount());
		row.createCell(4).setCellValue(It.getCustId());
		rownum++;
	}
		}
}