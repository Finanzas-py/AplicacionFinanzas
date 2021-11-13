package pe.edu.upc.spring.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Company;
import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.ReasonCf;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.repository.ICostRepository;
import pe.edu.upc.spring.repository.IReasonCfRepository;
import pe.edu.upc.spring.repository.IReasonCiRepository;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ICostService;
import pe.edu.upc.spring.service.IReasonCfService;
import pe.edu.upc.spring.service.IReasonCiService;

@Service
public class ReasonCfServiceImpl implements IReasonCfService {

	@Autowired
	private IReasonCfRepository dReasonCf;
	
	@Transactional(readOnly = true)
	public List<ReasonCf> listReasonCf() {
		return dReasonCf.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<ReasonCf> SearchById(String idReasonCf) {
		return dReasonCf.SearchById(idReasonCf);
	}

}
