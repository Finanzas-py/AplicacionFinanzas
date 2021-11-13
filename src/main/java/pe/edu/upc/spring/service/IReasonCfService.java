package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.ReasonCf;
import pe.edu.upc.spring.model.ReasonCi;



public interface IReasonCfService {
	public List<ReasonCf> listReasonCf();
	public List<ReasonCf> SearchById(String idReasonCf);

}

