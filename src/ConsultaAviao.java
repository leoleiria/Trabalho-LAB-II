
public class ConsultaAviao {
	public static void ListaTodos() {
		System.out.println(""+ Aviao.getId()+""+Aviao.getNome()+""+Aviao.getNroAssentos());
	}
	public static Aviao EscolheAviao() {//falta implementar metodo de escolha de aviao
		Aviao avEscolha = new Aviao(Aviao.getId(),Aviao.getNome(),Aviao.getNroAssentos());
		return avEscolha;
	}
}
