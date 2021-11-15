package pe.edu.upc.spring.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Cost;



public interface ICostService {
	public List<Cost> listCost();
	public void delete(int idCost);
	public boolean save(Cost cost);
	public Cost idRef();
	public int findByIdRef(String idRef);
}

