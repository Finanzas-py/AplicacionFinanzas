package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Company;
import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.repository.ICostRepository;
import pe.edu.upc.spring.repository.IReasonCiRepository;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ICostService;
import pe.edu.upc.spring.service.IReasonCiService;

@Service
public class ReasonCiServiceImpl implements IReasonCiService {

	@Autowired
	private IReasonCiRepository dReasonCi;
	
	@Transactional(readOnly = true)
	public List<ReasonCi> listReasonCi() {
		return dReasonCi.findAll();
	}
	
}
