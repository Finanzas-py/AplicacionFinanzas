package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.ReasonCi;



public interface IReasonCiService {
	public List<ReasonCi> listReasonCi();
	public List<ReasonCi> SearchById(String idReasonCi);

}

