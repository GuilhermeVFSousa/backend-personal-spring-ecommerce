package com.gvfs.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pais")
@Getter @Setter
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "nome_pt")
	private String nomePT;
	
	@Column(name = "sigla")
	private String sigla;
	
	@Column(name = "bacen")
	private Integer bacen;
	
	@OneToMany(mappedBy = "pais")
	@JsonIgnore
	private List<Estado> estados;

}
