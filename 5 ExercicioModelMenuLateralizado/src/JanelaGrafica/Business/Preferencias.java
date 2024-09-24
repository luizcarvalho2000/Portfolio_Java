package JanelaGrafica.Business;

import DAO_BLL.PreferenciasDAO;
import Model.PreferenciasVO;
import java.io.File;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.DefaultListModel;


public class Preferencias {	
	
	PreferenciasDAO objPreferenciasDAO;
	
	
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
		try {
			objPreferenciasDAO = new PreferenciasDAO();
			return objPreferenciasDAO.BancoConectado();
		} catch (Exception ex) {
			throw ex;
		} 
	
	}
	
	public DefaultListModel<String> impBdDesconect() throws Exception {
		try {
			objPreferenciasDAO = new PreferenciasDAO();
			return objPreferenciasDAO.BancoDesconectado();
		} catch (Exception ex) {
			throw ex;
		} 
	}

	
	public ResultSet ConsultarBd() throws Exception {
		try {
			objPreferenciasDAO = new PreferenciasDAO();
			return objPreferenciasDAO.ConsultarBD();
		} catch (Exception ex) {
			throw ex;
		} 
	}
	
	public Boolean InserirBd(PreferenciasVO preferencias) throws Exception {
		try {
			objPreferenciasDAO = new PreferenciasDAO();
			return objPreferenciasDAO.InserirBD(preferencias);
		} catch (Exception ex) {
			throw ex;
		} 
	}
	
	public Boolean DeletarBd(PreferenciasVO preferencias) throws Exception {
		try {
			objPreferenciasDAO = new PreferenciasDAO();
			return objPreferenciasDAO.ExcluirBD(preferencias);
		} catch (Exception ex) {
			throw ex;
		} 
	}
	
	public Boolean AlterarBd(PreferenciasVO preferencias) throws Exception {
		try {
			objPreferenciasDAO = new PreferenciasDAO();
			return objPreferenciasDAO.AlterarBD(preferencias);
		} catch (Exception ex) {
			throw ex;
		} 
	}

}


