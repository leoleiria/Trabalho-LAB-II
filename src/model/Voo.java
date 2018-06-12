package model;
import java.time.LocalTime;

public class Voo {
	private String prefixo;
	private String origem;
	private String destino;
	private LocalTime time;
	private int aviao;
	
	public Voo(String prefixo, String origem, String destino, LocalTime time, int aviao) {
		this.prefixo = prefixo;
		this.origem = origem;
		this.destino = destino;
		this.time = time;
		this.aviao = aviao;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public LocalTime getData() {
		return time;
	}

	public int getAviao() {
		return aviao;
	}

	@Override
	public String toString() {
		return "Prefixo: " + prefixo + ", origem: " + origem + ", destino: " + destino + ", Horario: " + time+", aviao "+aviao;
	}

	
}