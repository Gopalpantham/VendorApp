package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("Content-Disposition","attchment;filename=Items.pdf");
	 List<Item> Items= (List<Item>)map.get("items");
	 Paragraph p=new Paragraph("welcome to pdf view");
	  PdfPTable t=new PdfPTable(5);
	  t.addCell("ID");
	  t.addCell("NAME");
	  t.addCell("COST");
	  t.addCell("DISCOUNT");
	  t.addCell("CUSTOMER ID");
	  
	  for(Item Item:Items)
	  {
		  t.addCell(Item.getItemId()+"");
		  t.addCell(Item.getItemName());
		  t.addCell(Item.getItemCost()+"");
		  t.addCell(Item.getDiscount()+"");
		  t.addCell(Item.getCustId()+"");
	  }
	  doc.add(p);
	  doc.add(t);
	  doc.add(new Paragraph(new Date().toString()));	}
	

}
