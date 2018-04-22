package model;
import java.time.LocalDate;

public class Voo {
	private String prefixo;
	private String origem;
	private String destino;
	private LocalDate horario;
	private Aviao aviao;
	
	public Voo(String prefixo, String origem, String destino, LocalDate horario, Aviao aviao) {
		this.prefixo = prefixo;
		this.origem = origem;
		this.destino = destino;
		this.horario = horario;
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

	public LocalDate getHorario() {
		return horario;
	}

	public Aviao getAviao() {
		return aviao;
	}

	@Override
	public String toString() {
		return "Prefixo: " + prefixo + ", origem: " + origem + ", destino: " + destino + ", horario: " + horario
				+ ", aviao: " + aviao.getNome();
	}

	
}