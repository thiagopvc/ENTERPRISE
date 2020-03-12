package com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_CORRIDA")
@SequenceGenerator(sequenceName = "SQ_TB_CORRIDA", name = "corrida", allocationSize = 1)
public class Corrida {

	@Id
	@Column(name = "cd_corrida")
	@GeneratedValue(generator = "corrida", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_origem")
	private String origem;

	@Column(name = "ds_destino")
	private String destino;

	@Column(name = "dt_corrida")
	private Calendar corrida;

	@Column(name = "vl_corrida", nullable = false)
	private double valor;

	public Corrida() {
		super();
	}

	public Corrida(int codigo, String origem, String destino, Calendar corrida, double valor) {
		super();
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.corrida = corrida;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getCorrida() {
		return corrida;
	}

	public void setCorrida(Calendar corrida) {
		this.corrida = corrida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
