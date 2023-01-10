package com.gvfs.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvfs.ecommerce.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
