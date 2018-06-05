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
		try {
			String id = Console.scanString("Digite ID da pessoa desejada: ");
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "SELECT * FROM cliente WHERE id='" + id + "'";
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // RG: " + resultado.getString("rg"));
				System.out.print(" // Nome: " + resultado.getString("nomecliente"));
				System.out.println(" // Telefone: " + resultado.getString("telefone"));
			}
			String novonome = Console.scanString("Digite o novo nome desejado: ");
			String novotelefone = Console.scanString("Digite novo telefone desejado: ");
			String sqlupdate = "UPDATE cliente SET nomecliente = '" + novonome + "', telefone = '" + novotelefone
					+ "'WHERE id = " + id;
			conexao.prepareStatement(sqlupdate).executeUpdate();
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void AlterarAviao() {
		try {
			String id = Console.scanString("Digite ID do avião desejado: ");
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "SELECT * FROM aviao WHERE id='" + id + "'";
			PreparedStatement comando = conexao.prepareStatement(sql);

			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Nome: " + resultado.getString("nome"));
				System.out.println(" // Assentos: " + resultado.getString("assentos"));
			}
			String novonome = Console.scanString("Digite o novo nome desejado: ");
			String novoassentos = Console.scanString("Digite novo número de assentos: ");
			String sqlupdate = "UPDATE aviao SET nome = '" + novonome + "', assentos = '" + novoassentos
					+ "'WHERE id = " + id;
			conexao.prepareStatement(sqlupdate).executeUpdate();
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void AlterarVoo() {
		try {
			String id = Console.scanString("Digite ID do voo desejado: ");
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "SELECT * FROM voo WHERE id='" + id + "'";
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Prefixo: " + resultado.getString("prefixo"));
				System.out.print(" // Origem: " + resultado.getString("origem"));
				System.out.print(" // Destino: " + resultado.getString("destino"));
				System.out.print(" // Horário: " + resultado.getString("horario"));
				System.out.println(" // Avião: " + resultado.getString("aviao"));
			}
			String novoprefixo = Console.scanString("Digite o novo prefixo desejado: ");
			String novaorigem = Console.scanString("Digite a nova origem desejado: ");
			String novodestino = Console.scanString("Digite o novo destino desejado: ");
			LocalTime novohorario = DateFormater.localTime("Digite o novo horário de partida(hh:mm): ");
			int novoaviao = Console.scanInt("Digite o ID do novo avião: ");
			String sqlupdate = "UPDATE voo SET prefixo = '" + novoprefixo + "', origem = '" + novaorigem
					+ "', destino = '" + novodestino + "', horario = '" + novohorario + "', aviao= '" + novoaviao
					+ "'WHERE id = " + id;
			conexao.prepareStatement(sqlupdate).executeUpdate();
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void AlterarBilhete() {
		try {
			String id = Console.scanString("Digite ID do voo desejado: ");
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "SELECT bilhete.*,cliente.nomecliente,voo.prefixo FROM bilhete,cliente,voo where bilhete.idvoo = voo.id and cliente.id = bilhete.idcliente and bilhete.id ='"
					+ id + "'";
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Localizador: " + resultado.getString("localizador"));
				System.out.print(" // Cliente: " + resultado.getString("nomecliente"));
				System.out.print(" // Vôo: " + resultado.getString("prefixo"));
				System.out.println(" // Horário da Venda: " + resultado.getString("datahora"));
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
			int novoaviao = Console.scanInt("Digite o ID do novo avião: ");
			String sqlupdate = "UPDATE bilhete SET idcliente = '" + novocliente + "', idvoo = '" + novovoo + "', horario = '" + novodataHora + "'WHERE id = " + id;
			conexao.prepareStatement(sqlupdate).executeUpdate();
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
