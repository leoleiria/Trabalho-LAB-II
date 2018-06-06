package control;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemaDeVendas.SistemaDeVendas;
import view.Console;

public class consulta {
	public static void ConsultaCliente() {
		String sql = "SELECT * FROM cliente";

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

	}

	public static void ConsultaClienteNome() {
		String clinomeBusca = Console.scanString("Digite o nome do cliente:");
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "SELECT * FROM cliente WHERE nomecliente Like '%" + clinomeBusca + "%'";
			PreparedStatement comando = conexao.prepareStatement(sql);

			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // RG: " + resultado.getString("rg"));
				System.out.print(" // Nome: " + resultado.getString("nomecliente"));
				System.out.println(" // Telefone: " + resultado.getString("telefone"));
			}

			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void ConsultaAviao() {
		try {
			String sql = "SELECT * FROM aviao";

			ResultSet resultado = RequestDB.consulta(sql);
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Nome: " + resultado.getString("nome"));
				System.out.println(" // Assentos: " + resultado.getString("assentos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ConsultaVoo() {
		try {
			String sql = "SELECT voo.*,aviao.nome FROM voo,aviao where aviao.id = voo.aviao";

			ResultSet resultado = RequestDB.consulta(sql);
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Prefixo: " + resultado.getString("prefixo"));
				System.out.print(" // Origem: " + resultado.getString("origem"));
				System.out.print(" // Destino: " + resultado.getString("destino"));
				System.out.print(" // Horário: " + resultado.getString("horario"));
				System.out.println(" // Avião: " + resultado.getString("nome"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ConsultaBilhete() {
		try {
			String sql = "SELECT distinct bilhete.*, cliente.nomecliente FROM bilhete,cliente,voo\r\n" + 
					"where cliente.id = bilhete.idcliente";

			ResultSet resultado = RequestDB.consulta(sql);
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Localizador: " + resultado.getString("localizador"));
				System.out.print(" // Cliente: " + resultado.getString("nomecliente"));
				System.out.print(" // Vôo: " + resultado.getString("idvoo"));
				System.out.println(" // Horário da Venda: " + resultado.getString("horacompra"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
