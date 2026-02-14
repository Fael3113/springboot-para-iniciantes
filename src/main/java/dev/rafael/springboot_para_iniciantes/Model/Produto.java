package dev.rafael.springboot_para_iniciantes.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Double preco;

	public Produto() {}

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	//Set Id é desnecessário, pois é gerenciado pelo próprio banco de dados
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
