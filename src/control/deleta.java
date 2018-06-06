package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.Console;

public class deleta {
	public static void DeletarCliente() {
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
			System.out.println("Deletar este usuário?\n[1] Sim\n[2] Não");
			int resposta = Console.scanInt("Opção > ");
			if (resposta == 1) {
				String sqldelete = "DELETE FROM cliente WHERE id=" + id;
				conexao.prepareStatement(sqldelete).executeUpdate();
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

	public static void DeletarAviao() {
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
			System.out.println("Deletar este avião?\n[1] Sim\n[2] Não");
			int resposta = Console.scanInt("Opção > ");
			if (resposta == 1) {
				String sqldelete = "DELETE FROM aviao WHERE id=" + id;
				conexao.prepareStatement(sqldelete).executeUpdate();
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

	public static void DeletarVoo() {
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
			System.out.println("Deletar este voo?\n[1] Sim\n[2] Não");
			int resposta = Console.scanInt("Opção > ");
			if (resposta == 1) {
				String sqldelete = "DELETE FROM voo WHERE id=" + id;
				conexao.prepareStatement(sqldelete).executeUpdate();
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

	public static void DeletarBilhete() {
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
		System.out.println("Deletar este voo?\n[1] Sim\n[2] Não");
		int resposta = Console.scanInt("Opção > ");
		if (resposta == 1) {
			String sqldelete = "DELETE FROM bilhete WHERE id=" + id;
			RequestDB.update(sqldelete);
		}

	}
}
