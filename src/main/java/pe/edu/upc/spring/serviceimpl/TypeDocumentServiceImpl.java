package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Company;
import pe.edu.upc.spring.model.TermRate;
import pe.edu.upc.spring.model.TypeDocument;
import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.repository.ITermRateRepository;
import pe.edu.upc.spring.repository.ITypeDocumentRepository;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ITermRateService;
import pe.edu.upc.spring.service.ITypeDocumentService;

@Service
public class TypeDocumentServiceImpl implements ITypeDocumentService {

	@Autowired
	private ITypeDocumentRepository dTypeDocument;
	
	

	@Transactional(readOnly = true)
	public List<TypeDocument> listTypeDocument() {
		return dTypeDocument.findAll();
	}
	
}
