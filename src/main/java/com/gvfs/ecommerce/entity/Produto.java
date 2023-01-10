package com.gvfs.ecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "unidade_preco")
	private BigDecimal unidadePreco; 
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "ativo")
	private boolean ativo;
	
	@Column(name = "unidades_em_estoque")
	private Integer unidadeEmEstoque;
	
	@Column(name = "data_criacao")
	@CreationTimestamp
	private Date dataCriacao;
	
	@Column(name = "ultimo_updated")
	@UpdateTimestamp
	private Date UltimoUpdate;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private ProdutoCategoria categoria;

}
