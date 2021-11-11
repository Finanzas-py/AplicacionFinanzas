package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Company;

import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ICompanyRepository dCompany;
	
	

	@Transactional(readOnly = true)
	public List<Company> listCompany() {
		return dCompany.findAll();
	}
	
}
