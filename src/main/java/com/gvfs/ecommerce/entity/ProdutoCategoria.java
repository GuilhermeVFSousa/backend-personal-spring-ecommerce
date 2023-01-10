package com.gvfs.ecommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto_categoria")
//@Data ===> Não utilizando quando houver relações OneToMany ou ManyToOne
@Getter @Setter
public class ProdutoCategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "categoria_nome")
	private String categoriaNome;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private Set<Produto> produtos;

}
