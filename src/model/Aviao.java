package model;

public class Aviao {
	private String id;
	private String nome;
	private int nroAssentos;

	public Aviao(String id, String nome, int nroAssentos) {
		this.id = id;
		this.nome = nome;
		this.nroAssentos = nroAssentos;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getNroAssentos() {
		return nroAssentos;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Nome: " + nome + ", Nro de assentos: " + nroAssentos;
	}

}
