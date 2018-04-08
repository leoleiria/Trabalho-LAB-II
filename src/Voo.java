import java.time.LocalDate;

public class Voo {
	private static String origem;
	private static String destino;
	private static LocalDate horario;
	private static Aviao aviao;
	
	public Voo(String origem, String destino, LocalDate horario, Aviao aviao) {
		this.origem = origem;
		this.destino = destino;
		this.horario = horario;
		this.aviao = aviao;
	}

	public static String getOrigem() {
		return origem;
	}

	public static String getDestino() {
		return destino;
	}

	public static LocalDate getHorario() {
		return horario;
	}

	public static Aviao getAviao() {
		return aviao;
	}
	
}