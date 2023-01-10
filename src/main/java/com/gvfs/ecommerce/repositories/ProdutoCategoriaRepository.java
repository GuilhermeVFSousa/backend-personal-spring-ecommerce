package com.gvfs.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gvfs.ecommerce.entity.ProdutoCategoria;

@RepositoryRestResource(collectionResourceRel = "produtoCategoria", path = "produto-categoria")
public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Long> {

}
