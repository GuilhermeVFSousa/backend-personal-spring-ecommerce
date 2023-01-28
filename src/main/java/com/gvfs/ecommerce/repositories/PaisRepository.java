package com.gvfs.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gvfs.ecommerce.entity.Pais;

@RepositoryRestResource(collectionResourceRel = "paises", path = "paises")
public interface PaisRepository extends JpaRepository<Pais, Integer>{

}
