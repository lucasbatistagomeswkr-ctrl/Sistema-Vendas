package com.projeto.sistema.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String numero;
	private String bairro;
	private String email;
	private String funcao;
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}

	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getNumero() {
		return numero;
	}









	public void setNumero(String numero) {
		this.numero = numero;
	}









	public String getBairro() {
		return bairro;
	}









	public void setBairro(String bairro) {
		this.bairro = bairro;
	}









	public String getEmail() {
		return email;
	}









	public void setEmail(String email) {
		this.email = email;
	}









	public String getFuncao() {
		return funcao;
	}









	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}









	public Cidade getCidade() {
		return cidade;
	}









	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}









	public static long getSerialversionuid() {
		return serialVersionUID;
	}









	






	

	
	@ManyToOne 
	private Cidade cidade;
	
	
}
