package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Company;
import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.repository.ICompanyRepository;
import pe.edu.upc.spring.repository.ICostRepository;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ICostService;

@Service
public class CostServiceImpl implements ICostService {

	@Autowired
	private ICostRepository dCost;
	
	
	@Override
	@Transactional
	public boolean save(Cost cost) {
		Cost objCost= dCost.save(cost);
		if (objCost == null)
			return false;
		else
			return true;
	}

	
	@Transactional(readOnly = true)
	public List<Cost> listCost() {
		return dCost.findAll();
	}
	
	@Override
	@Transactional
	public void delete(int idCost) {
		dCost.deleteById(idCost);
		
	}
	
	@Transactional(readOnly = true)
	public Cost idRef() {
		return dCost.idRef();
	}
	
	@Transactional(readOnly = true)
	public int findByIdRef(String idRef) {
		return dCost.findByIdRef(idRef);
	}
}
