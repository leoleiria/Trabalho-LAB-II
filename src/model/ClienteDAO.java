package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;

public class ClienteDAO {
	
	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO cliente (nome, rg, telefone) VALUES (?,?,?)");
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getRg());
			stmt.setString(3, c.getTelefone());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			ConnectionFactory.closeConnection(con,stmt);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			ConnectionFactory.closeConnection(con,stmt);
		}		
	}
	
	public void select() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("select * from cliente");
						
			
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Nome: " + resultado.getString("nome"));
				System.out.print(" // RG: " + resultado.getInt("rg"));
				System.out.print(" // Telefone: " + resultado.getString("nome"));
				System.out.println("");
			}
			System.out.println("");
			ConnectionFactory.closeConnection(con,stmt);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar: "+ex);
			ConnectionFactory.closeConnection(con,stmt);
		}		
	}
}
