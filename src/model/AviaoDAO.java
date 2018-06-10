package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;

public class AviaoDAO {
	
	public void create(Aviao a) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO aviao (nome, assentos) VALUE (?,?)");
			stmt.setString(1,a.getNome());
			stmt.setInt(2,a.getNroAssentos());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
		} finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
				
	}

}
