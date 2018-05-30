package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					+ "'WHERE id = " + id ;
			conexao.prepareStatement(sqlupdate);
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
