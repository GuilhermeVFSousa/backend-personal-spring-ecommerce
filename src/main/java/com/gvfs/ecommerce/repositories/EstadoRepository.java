package com.gvfs.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gvfs.ecommerce.entity.Estado;

@RepositoryRestResource(collectionResourceRel = "estados", path = "estados")
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	List<Estado> findByPaisSigla(@Param("sigla") String sigla);
	List<Estado> findByPaisId(@Param("id") int id);

}
