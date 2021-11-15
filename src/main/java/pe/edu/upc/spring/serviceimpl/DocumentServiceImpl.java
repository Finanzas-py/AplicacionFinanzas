package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.Document;
import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.repository.IDocumentRepository;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentRepository dDocument;
	
	
	@Override
	@Transactional
	public boolean save(Document document) {
		Document objDocument= dDocument.save(document);
		if (objDocument == null)
			return false;
		else
			return true;
	}


	@Transactional(readOnly = true)
	public List<Document> listDocument() {
		return dDocument.findAll();
	}
	
}
