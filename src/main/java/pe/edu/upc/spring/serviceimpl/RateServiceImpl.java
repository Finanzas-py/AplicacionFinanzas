package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Document;
import pe.edu.upc.spring.model.Rate;
import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.repository.IDocumentRepository;
import pe.edu.upc.spring.repository.IRateRepository;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.IDocumentService;
import pe.edu.upc.spring.service.IRateService;

@Service
public class RateServiceImpl implements IRateService {

	@Autowired
	private IRateRepository dRate;
	
	
	@Override
	@Transactional
	public boolean save(Rate rate) {
		Rate objRate= dRate.save(rate);
		if (objRate == null)
			return false;
		else
			return true;
	}

	
}
