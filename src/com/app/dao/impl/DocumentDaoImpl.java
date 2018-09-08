package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {
    @Autowired
	private HibernateTemplate ht;
	public int saveDocument(Document doc) {
		return (Integer)ht.save(doc);
	}

	public List<Object[]> getDocIdAndName() {
    String hql="select fileId,fileName from com.app.model.Document";
    @SuppressWarnings("unchecked")
	List<Object[]> obj=ht.find(hql);
		return obj;
	}

	public Document getDocumentById(int fileId) {
		return ht.get(Document.class, fileId);
	}

}
