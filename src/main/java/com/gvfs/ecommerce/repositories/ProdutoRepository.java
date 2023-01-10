package com.gvfs.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gvfs.ecommerce.entity.Produto;

@RepositoryRestResource(collectionResourceRel = "produto", path = "produtos")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
