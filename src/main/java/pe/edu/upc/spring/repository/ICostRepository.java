package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Company;
import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.model.Users;


@Repository
public interface ICostRepository extends JpaRepository<Cost, Integer>{
	

}
