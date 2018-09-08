package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter pw, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.addHeader("Content-Disposition","attchment;filename=Locations.pdf");
	 List<Location> locs= (List<Location>)map.get("locs");
	 Paragraph p=new Paragraph("welcome to pdf view");
	  PdfPTable t=new PdfPTable(5);
	  t.addCell("ID");
	  t.addCell("NAME");
	  t.addCell("CODE");
	  t.addCell("TYPE");
	  t.addCell("NOTE");
	  
	  for(Location loc:locs)
	  {
		  t.addCell(loc.getLocId()+"");
		  t.addCell(loc.getLocName());
		  t.addCell(loc.getLocCode());
		  t.addCell(loc.getLocType());
		  t.addCell(loc.getLocDesc());
	  }
	  doc.add(p);
	  doc.add(t);
	  doc.add(new Paragraph(new Date().toString()));	}
	

}
