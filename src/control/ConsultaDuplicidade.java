package control;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.*;
import sistemaDeVendas.SistemaDeVendas;

public class ConsultaDuplicidade {
	public static boolean cliente(Cliente sample) {
		final String queryCheck = "SELECT * from messages WHERE msgid = ?";
		final PreparedStatement ps = conn.prepareStatement(queryCheck);
		ps.setString(1, msgid);
		final ResultSet resultSet = ps.executeQuery();
		for (int x = 0; x < SistemaDeVendas.vCliente.length; x++) {
			if (SistemaDeVendas.vCliente[x] != null) {
				if (sample.getRg() == SistemaDeVendas.vCliente[x].getRg()) {
					System.out.println("Dados já existem: \n" + SistemaDeVendas.vCliente[x]);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean aviao(Aviao sample) {
		for (int x = 0; x < SistemaDeVendas.vAviao.length; x++) {
			if (SistemaDeVendas.vAviao[x] != null) {
				if (sample.getId().equals(SistemaDeVendas.vAviao[x].getId())) {
					System.out.println("Dados já existem: \n" + SistemaDeVendas.vAviao[x]);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean voo(Voo sample) {// adicionar busca de voo com horario
		for (int x = 0; x < SistemaDeVendas.vVoo.length; x++) {
			if (SistemaDeVendas.vVoo[x] != null) {
				if (sample.getPrefixo().equals(SistemaDeVendas.vVoo[x].getPrefixo())) {
					System.out.println("Dados já existem: \n" + SistemaDeVendas.vVoo[x]);
					return false;
				}
			}
		}
		return true;
	}

	public static boolean bilhete(Bilhete sample) {
		for (int x = 0; x < SistemaDeVendas.vBilhete.length; x++) {
			if (SistemaDeVendas.vBilhete[x] != null) {
				if (sample.getLocalizador().equals(SistemaDeVendas.vBilhete[x].getLocalizador())) {
					System.out.println("Dados já existem: \n" + SistemaDeVendas.vBilhete[x]);
					return false;
				}
			}
		}
		return true;
	}
}