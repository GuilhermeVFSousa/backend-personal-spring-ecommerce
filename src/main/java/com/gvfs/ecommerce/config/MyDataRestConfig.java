package com.gvfs.ecommerce.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.gvfs.ecommerce.entity.Produto;
import com.gvfs.ecommerce.entity.ProdutoCategoria;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		// desabilitar o métodos HTTP para Produto (PUT, POST e DELETE)
		config.getExposureConfiguration()
			.forDomainType(Produto.class)
			.withItemExposure((metdata, httpMethod) -> httpMethod.disable(theUnsupportedActions))
			.withCollectionExposure((metdata, httpMethod) -> httpMethod.disable(theUnsupportedActions));
		
		// desabilitar o métodos HTTP para ProdutoCategoria (PUT, POST e DELETE)
		config.getExposureConfiguration()
			.forDomainType(ProdutoCategoria.class)
			.withItemExposure((metdata, httpMethod) -> httpMethod.disable(theUnsupportedActions))
			.withCollectionExposure((metdata, httpMethod) -> httpMethod.disable(theUnsupportedActions));
				
		// expor os Ids no JSON
		exposeIds(config);
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		// expose entity ids
		
		// obter uma collection de todas entity classes do entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		//criar um array de entity types
		List<Class> entityClasses = new ArrayList<>();
		
		//obter o entity type das entidades
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
			
		// expor os ids das entidades para o array de entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
			
		
	}
	
	

}














