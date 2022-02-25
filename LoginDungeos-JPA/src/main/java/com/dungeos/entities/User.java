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
public class User implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    //DEFINIR ATRIBUTOS QUE SER�O AS COLUNAS DA TABELA GERADA   
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    @Column(nullable = false) @Lob
    private @NotNull String nomeuser;
	
	@Column(nullable = false) @Lob
    private @NotNull String datanasc;
	
	@Column(nullable = false) @Lob
    private @NotNull String senha;
	
	@Column(nullable = false) @Lob
    private @NotNull String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//GETTERS and SETTERS
	public Long getIduser() {
		return iduser;
	}
	
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getNomeuser() {
		return nomeuser;
	}

	public void setNomeuser(String nomeuser) {
		this.nomeuser = nomeuser;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
