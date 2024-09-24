package Business;

import java.io.File;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.DefaultListModel;

import DAO.PreferenciasDAO;
import MODEL.PreferenciasVO;

public class PreferenciasBusiness {
	PreferenciasDAO objPreferenciasDAO;
	
	Boolean resultado = false;
	
	public DefaultListModel<String> impTxtWhile() throws Exception {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			int linhaDoArquivo = 0;
			int totalLinhaDoArquivo = arrLinhaDoArquivo.size();
			
			modelo.clear();
			
			while (linhaDoArquivo < totalLinhaDoArquivo) {
                modelo.addElement(arrLinhaDoArquivo.get(linhaDoArquivo));
                linhaDoArquivo++;
            }
			return modelo;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DefaultListModel<String> impTxtDoWhile() throws Exception {
		try {
			File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
			
			List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
			
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			int linhaDoArquivo = 0;
			int totalLinhaDoArquivo = arrLinhaDoArquivo.size();
			
			modelo.clear();
			
			do {
                modelo.addElement(arrLinhaDoArquivo.get(linhaDoArquivo));
                linhaDoArquivo++;
            } while (linhaDoArquivo < totalLinhaDoArquivo);			
			
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
			int linhaDoArquivo = 0;
			int totalLinhaDoArquivo = arrLinhaDoArquivo.size();
			
			modelo.clear();
			
			for (linhaDoArquivo = 0; linhaDoArquivo < totalLinhaDoArquivo; linhaDoArquivo++) {
                modelo.addElement(arrLinhaDoArquivo.get(linhaDoArquivo));
            }		
			
			return modelo;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DefaultListModel<String> impTxtForInter() throws Exception {
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
	
	public DefaultListModel<String> impTxtForExt() throws Exception {
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
			return objPreferenciasDAO.DeletarBD(preferencias);	

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
