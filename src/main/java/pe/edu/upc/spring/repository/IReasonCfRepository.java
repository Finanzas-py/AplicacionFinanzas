package pe.edu.upc.spring.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Company;
import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.ReasonCf;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.model.Users;


@Repository
public interface IReasonCfRepository extends JpaRepository<ReasonCf, Integer>{
	
	@Query("from ReasonCf r where CAST(r.idReasonCf AS string) like %:idReasonCf%")
	List<ReasonCf> SearchById(@Param("idReasonCf")String idReasonCf);
	
}
