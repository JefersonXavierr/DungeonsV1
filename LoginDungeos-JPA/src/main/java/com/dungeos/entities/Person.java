package com.dungeos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class Person implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    //DEFINIR ATRIBUTOS QUE SER�O AS COLUNAS DA TABELA GERADA   
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idperson;

    @Column(nullable = false) @Lob
    private @NotNull String nomeperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String alinhamentoperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String nivelperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String vidaperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String armaduraperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String strperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String dexperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String conperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String inteperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String sabperson;
	
	@Column(nullable = false) @Lob
    private @NotNull String carperson;
	
	public Long getIdperson() {
		return idperson;
	}

	public void setIdperson(Long idperson) {
		this.idperson = idperson;
	}

	public String getNomeperson() {
		return nomeperson;
	}

	public void setNomeperson(String nomeperson) {
		this.nomeperson = nomeperson;
	}

	public String getAlinhamentoperson() {
		return alinhamentoperson;
	}

	public void setAlinhamentoperson(String alinhamentoperson) {
		this.alinhamentoperson = alinhamentoperson;
	}

	public String getNivelperson() {
		return nivelperson;
	}

	public void setNivelperson(String nivelperson) {
		this.nivelperson = nivelperson;
	}

	public String getVidaperson() {
		return vidaperson;
	}

	public void setVidaperson(String vidaperson) {
		this.vidaperson = vidaperson;
	}

	public String getArmaduraperson() {
		return armaduraperson;
	}

	public void setArmaduraperson(String armaduraperson) {
		this.armaduraperson = armaduraperson;
	}

	public String getStrperson() {
		return strperson;
	}

	public void setStrperson(String strperson) {
		this.strperson = strperson;
	}

	public String getDexperson() {
		return dexperson;
	}

	public void setDexperson(String dexperson) {
		this.dexperson = dexperson;
	}

	public String getConperson() {
		return conperson;
	}

	public void setConperson(String conperson) {
		this.conperson = conperson;
	}

	public String getInteperson() {
		return inteperson;
	}

	public void setInteperson(String inteperson) {
		this.inteperson = inteperson;
	}

	public String getSabperson() {
		return sabperson;
	}

	public void setSabperson(String sabperson) {
		this.sabperson = sabperson;
	}

	public String getCarperson() {
		return carperson;
	}

	public void setCarperson(String carperson) {
		this.carperson = carperson;
	}
	

}
