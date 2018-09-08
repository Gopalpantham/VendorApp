package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;
@Repository
public class DocumentServiceImpl implements IDocumentService {
    @Autowired 
	private IDocumentDao dao;
	public int saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}

	public List<Object[]> getDocIdAndName() {
		return dao.getDocIdAndName();
	}

	public Document getDocumentById(int fileId) {
		return dao.getDocumentById(fileId);
	}

}
