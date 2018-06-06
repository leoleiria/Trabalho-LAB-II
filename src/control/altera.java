package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import model.DateFormater;
import view.Console;

public class altera {
	public static void AlterarCliente() {
		consulta.ConsultaCliente();
		String id = Console.scanString("Digite ID da pessoa desejada: ");
		String sql = "SELECT * FROM cliente WHERE id='" + id + "'";
		ResultSet resultado = RequestDB.consulta(sql);
		try {
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // RG: " + resultado.getString("rg"));
				System.out.print(" // Nome: " + resultado.getString("nomecliente"));
				System.out.println(" // Telefone: " + resultado.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String novonome = Console.scanString("Digite o novo nome desejado: ");
		String novotelefone = Console.scanString("Digite novo telefone desejado: ");
		String sqlupdate = "UPDATE cliente SET nomecliente = '" + novonome + "', telefone = '" + novotelefone
				+ "'WHERE id = " + id;
		RequestDB.update(sqlupdate);

	}

	public static void AlterarAviao() {
		consulta.ConsultaAviao();
		String id = Console.scanString("Digite ID do avião desejado: ");
		String sql = "SELECT * FROM aviao WHERE id='" + id + "'";
		ResultSet resultado = RequestDB.consulta(sql);
		try {
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Nome: " + resultado.getString("nome"));
				System.out.println(" // Assentos: " + resultado.getString("assentos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String novonome = Console.scanString("Digite o novo nome desejado: ");
		String novoassentos = Console.scanString("Digite novo número de assentos: ");
		String sqlupdate = "UPDATE aviao SET nome = '" + novonome + "', assentos = '" + novoassentos + "'WHERE id = "
				+ id;
		RequestDB.update(sqlupdate);

	}

	public static void AlterarVoo() {
			consulta.ConsultaVoo();
			String id = Console.scanString("Digite ID do voo desejado: ");
			String sql = "SELECT * FROM voo WHERE id='" + id + "'";
			ResultSet resultado = RequestDB.consulta(sql);
			try {
				while (resultado.next()) {
					System.out.print("ID: " + resultado.getInt("id"));
					System.out.print(" // Prefixo: " + resultado.getString("prefixo"));
					System.out.print(" // Origem: " + resultado.getString("origem"));
					System.out.print(" // Destino: " + resultado.getString("destino"));
					System.out.print(" // Horário: " + resultado.getString("horario"));
					System.out.println(" // Avião: " + resultado.getString("aviao"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String novoprefixo = Console.scanString("Digite o novo prefixo desejado: ");
			String novaorigem = Console.scanString("Digite a nova origem desejado: ");
			String novodestino = Console.scanString("Digite o novo destino desejado: ");
			LocalTime novohorario = DateFormater.localTime("Digite o novo horário de partida(hh:mm): ");
			consulta.ConsultaAviao();
			int novoaviao = Console.scanInt("Digite o ID do novo avião: ");
			String sqlupdate = "UPDATE voo SET prefixo = '" + novoprefixo + "', origem = '" + novaorigem
					+ "', destino = '" + novodestino + "', horario = '" + novohorario + "', aviao= '" + novoaviao
					+ "'WHERE id = " + id;
			RequestDB.update(sqlupdate);

		
	}

	public static void AlterarBilhete() {
			consulta.ConsultaBilhete();
			String id = Console.scanString("Digite ID do bilhete desejado: ");
			String sql = "SELECT bilhete.*,cliente.nomecliente,voo.prefixo FROM bilhete,cliente,voo where bilhete.idvoo = voo.id and cliente.id = bilhete.idcliente and bilhete.id ='"
					+ id + "'";
			ResultSet resultado = RequestDB.consulta(sql);
			try {
				while (resultado.next()) {
					System.out.print("ID: " + resultado.getInt("id"));
					System.out.print(" // Localizador: " + resultado.getString("localizador"));
					System.out.print(" // Cliente: " + resultado.getString("nomecliente"));
					System.out.print(" // Vôo: " + resultado.getString("prefixo"));
					System.out.println(" // Horário da Venda: " + resultado.getString("datahora"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			int novocliente;
			int novovoo;
			do {
				consulta.ConsultaCliente();
				novocliente = Console.scanInt("Digite o ID do novo cliente: ");
				consulta.ConsultaVoo();
				novovoo = Console.scanInt("Digite o Id do novo Voo: ");
			} while (novocliente == 0 || novovoo == 0);
			LocalDateTime novodataHora = DateFormater.localDateTime().now();
			String sqlupdate = "UPDATE bilhete SET idcliente = '" + novocliente + "', idvoo = '" + novovoo
					+ "', horacompra = '" + novodataHora + "'WHERE id = " + id;
			RequestDB.update(sqlupdate);
			
	}
}
