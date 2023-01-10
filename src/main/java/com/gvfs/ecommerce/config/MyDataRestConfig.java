package com.gvfs.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.gvfs.ecommerce.entity.Produto;
import com.gvfs.ecommerce.entity.ProdutoCategoria;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

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
	}
	
	

}














