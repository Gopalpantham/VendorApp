package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("Content-Disposition","attchment;filename=Vendor.pdf");
	List<Vendor> vens= (List<Vendor>)map.get("vens");
	 Paragraph p=new Paragraph("welcome to pdf view");
	  PdfPTable t=new PdfPTable(5);
	  t.addCell("ID");
	  t.addCell("CODE");
	  t.addCell("NAME");
	  t.addCell("TYPE");
	  t.addCell("ADDRESS");
	  t.addCell("IDTYPE");
	  t.addCell("IDNUM");

	  
	  for(Vendor ven:vens)
	  {
		  t.addCell(ven.getVenId()+"");
		  t.addCell(ven.getVenCode());
		  t.addCell(ven.getVenName());
		  t.addCell(ven.getVenType());
		  t.addCell(ven.getVenAddr());
		  t.addCell(ven.getVenIdType());
		  t.addCell(ven.getVenIdNum());
	  }
	  doc.add(p);
	  doc.add(t);
	  doc.add(new Paragraph(new Date().toString()));	}
	

}
