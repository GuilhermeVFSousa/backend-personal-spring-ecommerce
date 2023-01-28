package com.gvfs.ecommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gvfs.ecommerce.entity.Produto;

@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	//URL = api/produtos/search/findByCategoriaId?id=xxxxx
	Page<Produto> findByCategoriaId(@Param("id") Long id, Pageable pageable);
	
	Page<Produto> findByNomeContaining(@Param("nome") String nome, Pageable pageable);

}
