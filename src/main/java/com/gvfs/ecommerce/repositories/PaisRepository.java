package com.gvfs.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gvfs.ecommerce.entity.Pais;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "paises", path = "paises")
public interface PaisRepository extends JpaRepository<Pais, Integer>{

}
