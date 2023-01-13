package com.gvfs.ecommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gvfs.ecommerce.entity.Produto;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	//URL = api/produtos/search/findByCategoriaId?id=xxxxx
	Page<Produto> findByCategoriaId(@Param("id") Long id, Pageable pageable);

}
