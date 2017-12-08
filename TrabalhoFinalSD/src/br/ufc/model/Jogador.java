package br.ufc.model;

import java.util.Random;

public class Jogador implements Comparable<Jogador> {
	
	private String id;
	private String nome;
	private int acertos;
	private int parcial;

	public Jogador() {
		super();
		this.id = gerarNovoId();
		this.acertos = 0;
	}
	public int getAcertos() {
		return acertos;
	}
	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getParcial() {
		return parcial;
	}
	public void setParcial(int parcial) {
		this.parcial = parcial;
	}
	public String gerarNovoId(){
		Random random = new Random();
		int ini = random.nextInt(10000);
		return ini +"J"+ System.currentTimeMillis();
	}
	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", acertos=" + acertos
				+ ", senha=" + senha + "]";
	}
	@Override
	public int compareTo(Jogador o) {
		if(this.acertos > o.getAcertos()) {
			return -1;
		}
		if(this.acertos < o.getAcertos()) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

