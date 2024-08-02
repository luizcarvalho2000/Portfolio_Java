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


public class Preferencias {	
	
	Boolean resultado = false;

	public DefaultListModel<String> impTxtWhile()  throws Exception {
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
				
			}

			return modelo;
			
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DefaultListModel<String> impTxtDoWhile()  throws Exception {
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
			
		    return modelo;
		    
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DefaultListModel<String> impTxtFor() throws Exception {
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
			
		    return modelo;
		    
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DefaultListModel<String> impTxtForEachInter() throws Exception {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			
			modelo.clear();
			
			for (String linha : arrLinhaDoArquivo) {
				
				modelo.addElement(linha);
			}
			
			return modelo;
		    
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DefaultListModel<String> impTxtForEachExter() throws Exception {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			
			modelo.clear();
			
			arrLinhaDoArquivo.forEach(linha -> modelo.addElement(linha));

			
			return modelo;
		    
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DefaultListModel<String> impBdConect() throws Exception {
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
			}
			
			return modelo;
		}
			    
		catch (Exception ex) {
				throw ex;
		}finally {
			if (conn != null); {
				try {
					conn.close();
				}catch (Exception ex) {
						throw ex;
				}
			}
		}				
	}
	
	public DefaultListModel<String> impBdDesconect() throws Exception {
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
			}
			conn.close();
			
			return modelo;
		    
		} catch (Exception ex) {
			throw ex;
		}
			
		
	}

	
	public ResultSet ConsultarBd() throws Exception {
		Connection conn = null;
		
		try {
			
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();			
			conn = DriverManager.getConnection(connectString);
			
			String sql = "SELECT ID, Descricao FROM Preferencias_3";			
			PreparedStatement ps = conn.prepareStatement(sql);			
			ResultSet rsPreferencias = ps.executeQuery();
			
			return rsPreferencias;				
					
		} catch (Exception ex) {
			throw ex;
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					throw ex;
				}
			}
		}				
	}
	
	public Boolean InserirBd(String strPreferenciasIncluidas) throws Exception {
		Connection conn = null;
		
		try {
			
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();			
			conn = DriverManager.getConnection(connectString);
			
			String strSql = "INSERT INTO Preferencias_3 (Descricao) VALUES (?)";			
			PreparedStatement psql = conn.prepareStatement(strSql);			
			psql.setString(1,  strPreferenciasIncluidas);	
			
			if (psql.executeUpdate() > 0) {
				resultado = true;
			} else {
				resultado = false;
			}
			
			return resultado;
			
		} catch (Exception ex) {
			throw ex;
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					throw ex;
				}
			}
		}				
	}
	
	public Boolean DeletarBd(int id) throws Exception {
		Connection conn = null;
		
		try {
			
			String servDriver = "jdbc:ucanaccess://";
			String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
			String connectString = servDriver + bancoDeDados.trim();
			
			conn = DriverManager.getConnection(connectString);
			
			String strSql = "DELETE FROM Preferencias_3 WHERE ID = ?";			
			PreparedStatement psql = conn.prepareStatement(strSql);			
			psql.setInt(1, id);
			
			
			if (psql.executeUpdate() > 0) {
				resultado = true;
			}else {
				resultado = false;
			}
			return resultado;
			
		} catch (Exception ex) {
			throw ex;
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					throw ex;
				}
			}
		}				
	}
	
	public Boolean AlterarBd(String novaDescricao, int id) throws Exception {
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
			
			if (psql.executeUpdate() > 0) {
				resultado = true;
			}else {
				resultado = false;
			}
			return resultado;

			
		} catch (Exception ex) {
			throw ex;
		}finally {
			if (conn != null); {
				try {
					conn.close();
				} catch (Exception ex) {
					throw ex;
				}
			}
		}				
					
	}
}

