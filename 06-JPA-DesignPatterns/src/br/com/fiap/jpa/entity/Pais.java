package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PAIS")
@SequenceGenerator(name="pais",sequenceName = "SQ_TB_PAIS",allocationSize = 1)
public class Pais {

	@Id
	@Column(name="cd_pais")
	@GeneratedValue(generator = "pais", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pais", length = 100, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_surgimento")
	private Calendar dataSurgimento;

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

	public Calendar getDataSurgimento() {
		return dataSurgimento;
	}

	public void setDataSurgimento(Calendar dataSurgimento) {
		this.dataSurgimento = dataSurgimento;
	}	
	
}
