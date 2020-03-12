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
@Table(name = "T_PAGAMENTO")
@SequenceGenerator(sequenceName = "SQ_TB_PAGAMENTO", name = "pagamento", allocationSize = 1)
public class Pagamento {
	@Id
	@Column(name = "cd_pagamento")
	@GeneratedValue(generator = "pagamento", strategy= GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "dt_pagamento", nullable = false)
	private Calendar pagamento;
	
	@Column(name = "vl_pagamento", nullable = false)
	private double valor;
	
	@Column
	@Enumerated
	private FormaPagto formaPagamento;

	public Pagamento(int codigo, Calendar pagamento, double valor, FormaPagto formaPagamento) {
		super();
		this.codigo = codigo;
		this.pagamento = pagamento;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public Pagamento() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getPagamento() {
		return pagamento;
	}

	public void setPagamento(Calendar pagamento) {
		this.pagamento = pagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public FormaPagto getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagto formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
