package pe.edu.upc.spring.service;

import java.util.List;


import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.Users;



public interface ICostService {
	public List<Cost> listCost();
	public boolean save(Cost cost);

}

