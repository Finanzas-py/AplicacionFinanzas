package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Type;


import pe.edu.upc.spring.repository.ITypeRepository;

import pe.edu.upc.spring.service.ITypeService;

@Service
public class TypeServiceImpl implements ITypeService {

	@Autowired
	private ITypeRepository dType;
	
	

	@Transactional(readOnly = true)
	public List<Type> listType() {
		return dType.findAll();
	}
	
}
