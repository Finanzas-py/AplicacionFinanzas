package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.RateType;
import pe.edu.upc.spring.model.Type;
import pe.edu.upc.spring.repository.IRateTypeRepository;
import pe.edu.upc.spring.repository.ITypeRepository;
import pe.edu.upc.spring.service.IRateTypeService;
import pe.edu.upc.spring.service.ITypeService;

@Service
public class RateTypeServiceImpl implements IRateTypeService {

	@Autowired
	private IRateTypeRepository dRate;
	
	

	@Transactional(readOnly = true)
	public List<RateType> listRateType() {
		return dRate.findAll();
	}
	
}
