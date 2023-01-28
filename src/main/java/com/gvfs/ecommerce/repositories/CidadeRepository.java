package com.gvfs.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gvfs.ecommerce.entity.Cidade;

@RepositoryRestResource(collectionResourceRel = "cidades", path = "cidades")
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	List<Cidade> findByEstadoUf(@Param("uf") String uf);

}
