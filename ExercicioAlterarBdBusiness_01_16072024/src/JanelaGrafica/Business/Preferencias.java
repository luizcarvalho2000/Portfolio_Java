package JanelaGrafica.Business;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Preferencias {
	
	private JFrame minhaJanela;
	private JList<String> lstbxPreferencias;
	private DefaultTableModel modelo;
	
	// Construtor
	public Preferencias(JFrame minhaJanela, JList<String> lstbxPreferencias, DefaultTableModel modelo) {
		this.minhaJanela = minhaJanela;
		this.lstbxPreferencias = lstbxPreferencias;
		this.modelo = modelo;
	}

	public void impTxtWhile() {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<>();
			int linhaDoarquivo = 0;
			int totalDeLinhaDoArquivo = arrLinhaDoArquivo.size();
			
			modelo.clear();
			
			while (linhaDoarquivo < totalDeLinhaDoArquivo) {
				modelo.addElement(arrLinhaDoArquivo.get(linhaDoarquivo));
				
				linhaDoarquivo++;
				
			}lstbxPreferencias.setModel(modelo);
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void impTxtDoWhile() {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			
			int linhaDoarquivo = 0;
			int totalDeLinhaDoArquivo = arrLinhaDoArquivo.size();
			
			modelo.clear();
			
			do {
				modelo.addElement(arrLinhaDoArquivo.get(linhaDoarquivo));
				linhaDoarquivo++;
			} while (linhaDoarquivo < totalDeLinhaDoArquivo);
			
		    lstbxPreferencias.setModel(modelo);
		    
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void impTxtFor() {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			
			int linhaDoarquivo = 0;
			int totalDeLinhaDoArquivo = arrLinhaDoArquivo.size();
			
			modelo.clear();
			
			for (linhaDoarquivo = 0; linhaDoarquivo < totalDeLinhaDoArquivo; linhaDoarquivo++) {
				modelo.addElement(arrLinhaDoArquivo.get(linhaDoarquivo));
				
			}				
			
		    lstbxPreferencias.setModel(modelo);
		    
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void impTxtForEachInter() {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			
			modelo.clear();
			
			for (String linha : arrLinhaDoArquivo) {
				
				modelo.addElement(linha);
			}
			
		    lstbxPreferencias.setModel(modelo);
		    
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void impTxtForEachExter() {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			
			modelo.clear();
			
			arrLinhaDoArquivo.forEach(linha -> modelo.addElement(linha));

			
		    lstbxPreferencias.setModel(modelo);
		    
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void impBdConect() {
		Connection conn = null;
		try {
			DefaultListModel<String> modelo =  new DefaultListModel<String>();
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();
			
			conn = DriverManager.getConnection(connectString);
			
			String sql = "SELECT Descricao FROM Preferencias_3";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				modelo.addElement(rs.getString("Descricao"));
				
			}lstbxPreferencias.setModel(modelo);
			
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO FECHAR CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		}				
	}
	
	public void impBdDesconect() {
		Connection conn = null;
		List<String> dadosLocais = new ArrayList<String>();
		try {
			DefaultListModel<String> modelo =  new DefaultListModel<String>();
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();
			
			conn = DriverManager.getConnection(connectString);
			
			String sql = "SELECT Descricao FROM Preferencias_3";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String descricao = rs.getString("Descricao");
				modelo.addElement(descricao);
				
				dadosLocais.add(descricao);
				
			}lstbxPreferencias.setModel(modelo);
			
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO FECHAR CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		}				
	}
	
	public void ConsultarBd() {
		Connection conn = null;
		
		try {
			modelo.setRowCount(0);
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();			
			conn = DriverManager.getConnection(connectString);
			
			String sql = "SELECT ID, Descricao FROM Preferencias_3";			
			PreparedStatement ps = conn.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("ID");
				String descricao = rs.getString("Descricao");
				modelo.addRow(new Object[]{id, descricao});	
								
			}
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO FECHAR CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		}				
	}
	
	public void InserirBd(String strPreferenciasIncluidas) {
		Connection conn = null;
		
		try {
			
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();			
			conn = DriverManager.getConnection(connectString);
			
			String strSql = "INSERT INTO Preferencias_3 (Descricao) VALUES (?)";			
			PreparedStatement psql = conn.prepareStatement(strSql);			
			psql.setString(1,  strPreferenciasIncluidas);
			psql.executeUpdate();
			
			conn.close();
			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO FECHAR CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		}				
	}
	
	public void DeletarBd(int id) {
		Connection conn = null;
		
		try {
			
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();
			
			conn = DriverManager.getConnection(connectString);
			
			String strSql = "DELETE FROM Preferencias_3 WHERE ID = ?";			
			PreparedStatement psql = conn.prepareStatement(strSql);			
			psql.setInt(1, id);
			psql.executeUpdate();
			
			conn.close();
			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO FECHAR CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		}				
	}
	
	public void AlterarBd(String novaDescricao, int id) {
		Connection conn = null;
		
		try {
			
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();
			
			conn = DriverManager.getConnection(connectString);
			
			String strSql = "UPDATE Preferencias_3 SET Descricao = ? WHERE ID = ?";			
			PreparedStatement psql = conn.prepareStatement(strSql);			
			psql.setString(1, novaDescricao);
			psql.setInt(2, id);
			psql.executeUpdate();
			
			conn.close();
			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO FECHAR CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		}				
	}
}
