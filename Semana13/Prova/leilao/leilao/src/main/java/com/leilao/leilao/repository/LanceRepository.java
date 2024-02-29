package com.leilao.leilao.repository;

import java.util.ArrayList;

import com.leilao.leilao.model.Lance;
import com.leilao.leilao.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanceRepository extends JpaRepository<Lance,Long>{
	
	ArrayList<Lance> findByLeilaoId(Long id);
	ArrayList<Lance> findByConcorrenteId(Long id);
	Lance findTopByLeilaoOrderByValorDesc(Leilao leilao);
	

}
