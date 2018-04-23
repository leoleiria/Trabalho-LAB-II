import model.*;

public class ConsultaDuplicidade {
	public static boolean cliente(Cliente sample) {
		for (int x = 0; x < SistemaDeVendas.vCliente.length; x++) {
			if (SistemaDeVendas.vCliente[x] == null) {
				return true;
			} else if (sample.getTelefone() == SistemaDeVendas.vCliente[x].getTelefone()
					|| sample.getRg() == SistemaDeVendas.vCliente[x].getRg()) {
				System.out.println("Dados já existem: \n" + SistemaDeVendas.vCliente[x]);
				return false;
			}
		}
		return true;
	}

	public static boolean aviao(Aviao sample) {//ta cadastrando mesmo assim
		for (int x = 0; x < SistemaDeVendas.vAviao.length; x++) {
			if (SistemaDeVendas.vAviao[x] == null) {
				return true;
			} else if (sample.getNome() == SistemaDeVendas.vAviao[x].getNome()
					|| sample.getId() == SistemaDeVendas.vAviao[x].getId()) {
				System.out.println("Dados já existem: \n" + SistemaDeVendas.vAviao[x]);
				return false;
			}
		}
		return true;
	}

	public static boolean voo(Voo sample) {//adicionar busca de voo com horario
		for (int x = 0; x < SistemaDeVendas.vVoo.length; x++) {
			if (SistemaDeVendas.vVoo[x] == null) {
				return true;
			} else if (sample.getPrefixo() == SistemaDeVendas.vVoo[x].getPrefixo()
					|| sample.getAviao() == SistemaDeVendas.vVoo[x].getAviao()) {
				System.out.println("Dados já existem: \n" + SistemaDeVendas.vVoo[x]);
				return false;
			}
		}
		return true;
	}

	public static boolean bilhete(Bilhete sample) {
		for (int x = 0; x < SistemaDeVendas.vBilhete.length; x++) {
			if (SistemaDeVendas.vBilhete[x] == null) {
				return true;
			} else if (sample.getLocalizador() == SistemaDeVendas.vBilhete[x].getLocalizador()) {
				System.out.println("Dados já existem: \n" + SistemaDeVendas.vBilhete[x]);
				return false;
			}
		}
		return true;
	}
}