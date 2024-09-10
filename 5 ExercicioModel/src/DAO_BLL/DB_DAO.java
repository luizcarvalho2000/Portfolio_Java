package DAO_BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DB_DAO {
	private static DB_DAO instancia;
	private Connection con;
	private String url = "jdbc:ucanaccess://C:\\Curso programar\\Java\\Preferencias\\Preferencias_3_09022024.accdb";
	
	private DB_DAO() {
		
	}
	
	public static DB_DAO getInstancia() {
		if (instancia == null) {
			instancia = new DB_DAO();
		}
		return instancia;
	}
	
	public Connection getConexao() {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection(url);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados" + ex.getMessage().toString());
		}
		return con;
	}
	
	public void closeConexao() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados" + ex.getMessage().toString());
			}
		}
	}
}