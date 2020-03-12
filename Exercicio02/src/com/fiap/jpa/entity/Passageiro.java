package com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PASSAGEIRO")
@SequenceGenerator(sequenceName ="SQ_TB_PASSAGEIRO", name = "passageiro", allocationSize = 1)
public class Passageiro {
	@Id
	@Column(name = "cd_passageiro")
	@GeneratedValue(generator = "passageiro", strategy= GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_passageiro", nullable = false)
	private String nome;
	
	@Column(name = "dt_nascimento")
	private Calendar nascimento;
	
	@Enumerated
	@Column(name = "ds_genero")
	private Genero genero;
	public Passageiro(int codigo, String nome, Calendar nascimento, Genero genero) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nascimento = nascimento;
		this.genero = genero;
	}
	public Passageiro() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
