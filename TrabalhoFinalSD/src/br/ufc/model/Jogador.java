package br.ufc.model;

public class Jogador {
	
	private Integer id;
	private String nome;
	private String posiçao;
	private String senha;
	
	public Jogador(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPosiçao() {
		return posiçao;
	}
	public void setPosiçao(String posiçao) {
		this.posiçao = posiçao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", posiçao=" + posiçao + "]";
	}
	
	
}

