package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Company;
import pe.edu.upc.spring.model.TermRate;
import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.repository.ITermRateRepository;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ITermRateService;

@Service
public class TermRateServiceImpl implements ITermRateService {

	@Autowired
	private ITermRateRepository dTermRate;
	
	

	@Transactional(readOnly = true)
	public List<TermRate> listTermRate() {
		return dTermRate.findAll();
	}
	
}
