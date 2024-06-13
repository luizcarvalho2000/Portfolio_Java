import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JanelaGrafica {
	JFrame minhaJanela;
	JList<String> lstbxPreferencias;
	JScrollPane scrLstbx;
	
	//Crinado Janela Principal
	
	public JanelaGrafica() {
		minhaJanela = new JFrame();
		minhaJanela.setTitle("Janela Grafica");
		minhaJanela.setSize(500,550);
		minhaJanela.setLocale(null);
		minhaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Iniciando componetes graficos
		
		init();
		minhaJanela.setVisible(true);
		
	}
	
	private void init() {
		// Criando Cores
		
		Color Cinza = Color.decode("#708090");
		Color Prata = Color.decode("#c9c9c9");
		Color Branco = Color.decode("#effffd");
		
		
		// Criando painel para agrupar componentes
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Prata);
		
		// Adicionando panel a janela principal
		
		minhaJanela.getContentPane().add(panel, BorderLayout.CENTER);
		
		// Definindo tamanho dos botões
		
		int intLargura = 200;
		int intAltura = 15;
		int intMargemesquerda = 15;
		int intMargemSuperior =+ 10;
		int intAltLstbx = 414;
		int intLargLstbx = 240;
		
		// Criando Botões
		
		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setSize(intLargura, intAltura);
		lblMensagem.setLocation(intMargemesquerda, intMargemSuperior);
		panel.add(lblMensagem);
		
		JButton btnMensagem = new JButton("Mensagem");
		btnMensagem.setSize(intLargura, intAltura);
		btnMensagem.setLocation(intMargemesquerda, lblMensagem.getY() +18);
		btnMensagem.setBackground(Cinza);
		btnMensagem.setForeground(Branco);
		panel.add(btnMensagem);
		
		JLabel lblDesvCond = new JLabel("Desvio Condicional:");
		lblDesvCond.setSize(intLargura, intAltura);
		lblDesvCond.setLocation(intMargemesquerda, btnMensagem.getY() +18);
		panel.add(lblDesvCond);
		
		JButton btnDesvCond = new JButton("Desvio Condicional");
		btnDesvCond.setSize(intLargura, intAltura);
		btnDesvCond.setLocation(intMargemesquerda, lblDesvCond.getY() +18);
		btnDesvCond.setBackground(Cinza);
		btnDesvCond.setForeground(Branco);
		panel.add(btnDesvCond);
		
		JLabel lblDesvEncad = new JLabel("Desvio Encadeado:");
		lblDesvEncad.setSize(intLargura, intAltura);
		lblDesvEncad.setLocation(intMargemesquerda, btnDesvCond.getY() +18);
		panel.add(lblDesvEncad);
		
		JButton btnDesvEncad = new JButton("Desvio Encadeado");
		btnDesvEncad.setSize(intLargura, intAltura);
		btnDesvEncad.setLocation(intMargemesquerda, lblDesvEncad.getY() +18);
		btnDesvEncad.setBackground(Cinza);
		btnDesvEncad.setForeground(Branco);
		panel.add(btnDesvEncad);
		
		JLabel lblSwitchCase = new JLabel("Switch Case:");
		lblSwitchCase.setSize(intLargura, intAltura);
		lblSwitchCase.setLocation(intMargemesquerda, btnDesvEncad.getY() +18);
		panel.add(lblSwitchCase);
		
		JButton btnSwitchCase = new JButton("Switch Case");
		btnSwitchCase.setSize(intLargura, intAltura);
		btnSwitchCase.setLocation(intMargemesquerda, lblSwitchCase.getY() +18);
		btnSwitchCase.setBackground(Cinza);
		btnSwitchCase.setForeground(Branco);
		panel.add(btnSwitchCase);
		
		JLabel lblImpTxtWhile = new JLabel("Importa Texto While:");
		lblImpTxtWhile.setSize(intLargura, intAltura);
		lblImpTxtWhile.setLocation(intMargemesquerda, btnSwitchCase.getY() +18);
		panel.add(lblImpTxtWhile);
		
		JButton btnImpTxtWhile = new JButton("Importa Texto While");
		btnImpTxtWhile.setSize(intLargura, intAltura);
		btnImpTxtWhile.setLocation(intMargemesquerda, lblImpTxtWhile.getY() +18);
		btnImpTxtWhile.setBackground(Cinza);
		btnImpTxtWhile.setForeground(Branco);
		panel.add(btnImpTxtWhile);
		
		JLabel lblImpTxtDoWhile = new JLabel("Importa Texto Do While:");
		lblImpTxtDoWhile.setSize(intLargura, intAltura);
		lblImpTxtDoWhile.setLocation(intMargemesquerda, btnImpTxtWhile.getY() +18);
		panel.add(lblImpTxtDoWhile);
		
		JButton btnImpTxtDoWhile = new JButton("Importa Texto Do While");
		btnImpTxtDoWhile.setSize(intLargura, intAltura);
		btnImpTxtDoWhile.setLocation(intMargemesquerda, lblImpTxtDoWhile.getY() +18);
		btnImpTxtDoWhile.setBackground(Cinza);
		btnImpTxtDoWhile.setForeground(Branco);
		panel.add(btnImpTxtDoWhile);
		
		JLabel lblImpTxtFor = new JLabel("Importa Texto For:");
		lblImpTxtFor.setSize(intLargura, intAltura);
		lblImpTxtFor.setLocation(intMargemesquerda, btnImpTxtDoWhile.getY() +18);
		panel.add(lblImpTxtFor);
		
		JButton btnImpTxtFor = new JButton("Importa Texto For");
		btnImpTxtFor.setSize(intLargura, intAltura);
		btnImpTxtFor.setLocation(intMargemesquerda, lblImpTxtFor.getY() +18);
		btnImpTxtFor.setBackground(Cinza);
		btnImpTxtFor.setForeground(Branco);
		panel.add(btnImpTxtFor);
		
		JLabel lblImpTxtForEachInterno = new JLabel("Importa Texto ForEachInterno:");
		lblImpTxtForEachInterno.setSize(intLargura, intAltura);
		lblImpTxtForEachInterno.setLocation(intMargemesquerda, btnImpTxtFor.getY() +18);
		panel.add(lblImpTxtForEachInterno);
		
		JButton btnImpTxtForEachInterno = new JButton("Importa Texto ForEachInterno");
		btnImpTxtForEachInterno.setSize(intLargura, intAltura);
		btnImpTxtForEachInterno.setLocation(intMargemesquerda, lblImpTxtForEachInterno.getY() +18);
		btnImpTxtForEachInterno.setBackground(Cinza);
		btnImpTxtForEachInterno.setForeground(Branco);
		panel.add(btnImpTxtForEachInterno);
		
		
		JLabel lblImpTxtForEachExterno = new JLabel("Importa Texto ForEach Externo:");
		lblImpTxtForEachExterno.setSize(intLargura, intAltura);
		lblImpTxtForEachExterno.setLocation(intMargemesquerda, btnImpTxtForEachInterno.getY() +18);
		panel.add(lblImpTxtForEachExterno);
		
		JButton btnImpTxtForEachExterno = new JButton("Importa Texto ForEach Externo");
		btnImpTxtForEachExterno.setSize(intLargura, intAltura);
		btnImpTxtForEachExterno.setLocation(intMargemesquerda, lblImpTxtForEachExterno.getY() +18);
		btnImpTxtForEachExterno.setBackground(Cinza);
		btnImpTxtForEachExterno.setForeground(Branco);
		panel.add(btnImpTxtForEachExterno);
		
		JLabel lblImpBdConect = new JLabel("Importar Banco Conectado:");
		lblImpBdConect.setSize(intLargura, intAltura);
		lblImpBdConect.setLocation(intMargemesquerda, btnImpTxtForEachExterno.getY() +18);
		panel.add(lblImpBdConect);
		
		JButton btnImpBdConect = new JButton("Importar Banco Conectado");
		btnImpBdConect.setSize(intLargura, intAltura);
		btnImpBdConect.setLocation(intMargemesquerda, lblImpBdConect.getY() +18);
		btnImpBdConect.setBackground(Cinza);
		btnImpBdConect.setForeground(Branco);
		panel.add(btnImpBdConect);
		
		JLabel lblImpBdDesconect = new JLabel("Importar Banco Desconectado:");
		lblImpBdDesconect.setSize(intLargura, intAltura);
		lblImpBdDesconect.setLocation(intMargemesquerda, btnImpBdConect.getY() +18);
		panel.add(lblImpBdDesconect);
		
		JButton btnImpBdDesconect = new JButton("Importar Banco Desconectado");
		btnImpBdDesconect.setSize(intLargura, intAltura);
		btnImpBdDesconect.setLocation(intMargemesquerda, lblImpBdDesconect.getY() +18);
		btnImpBdDesconect.setBackground(Cinza);
		btnImpBdDesconect.setForeground(Branco);
		panel.add(btnImpBdDesconect);
		
		JLabel lblLimpTxt = new JLabel("Limpa Texto:");
		lblLimpTxt.setSize(intLargura, intAltura);
		lblLimpTxt.setLocation(intMargemesquerda, btnImpBdDesconect.getY() +18);
		panel.add(lblLimpTxt);
		
		JButton btnLimpTxt = new JButton("Limpa Texto");
		btnLimpTxt.setSize(intLargura, intAltura);
		btnLimpTxt.setLocation(intMargemesquerda, lblLimpTxt.getY() +18);
		btnLimpTxt.setBackground(Cinza);
		btnLimpTxt.setForeground(Branco);
		panel.add(btnLimpTxt);
		
		// Criando ListBox
		
		lstbxPreferencias = new JList<String>();
		lstbxPreferencias.setBounds(intMargemesquerda +220, intMargemSuperior +18, intLargLstbx, intAltLstbx);
		panel.add(lstbxPreferencias);
		
		// Criando Barra de rolagem
		
		scrLstbx = new JScrollPane(lstbxPreferencias);
		scrLstbx.setBounds(intMargemesquerda +220, intMargemSuperior +18, intLargLstbx, intAltLstbx);
		panel.add(lstbxPreferencias);
		
		// Criando eventos dos botões
		
		btnMensagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(minhaJanela, "BEM VINDO AO MEU PROGRAMA JAVA");
				
			}
		});
		
		btnDesvCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÕES", JOptionPane.OK_CANCEL_OPTION);
				if(opcao == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU OK!");
				}else {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR!");
				}
			}
		});
		
		btnDesvEncad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÕES", JOptionPane.YES_NO_CANCEL_OPTION);
				if(opcao == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU SIM!");
				}else if(opcao == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU NÃO!");
				}else {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR!");
				}
			}
		});
		
		btnSwitchCase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÕES", JOptionPane.YES_NO_CANCEL_OPTION)) {
				case JOptionPane.YES_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU SIM!");
				break;
				
				case JOptionPane.NO_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU NÃO!");
				break;
				
				case JOptionPane.CANCEL_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR!");
				break;
				}			
			}
		});
		
		
		btnImpTxtWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					while (linhaDoArquivo < totalLinhaDoArquivo) {
						modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));
						linhaDoArquivo++;						
					}lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		btnImpTxtDoWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					do {
						modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));
						linhaDoArquivo++;						
					} while (linhaDoArquivo < totalLinhaDoArquivo);					
											
					lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		btnImpTxtDoWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					for (linhaDoArquivo = 0; linhaDoArquivo < totalLinhaDoArquivo; linhaDoArquivo++) {
						modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));						
					}								
											
					lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		btnImpTxtFor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					for (linhaDoArquivo = 0; linhaDoArquivo < totalLinhaDoArquivo; linhaDoArquivo++) {
						modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));						
					}								
											
					lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		btnImpTxtForEachInterno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();			
					
					
					modelo.clear();
					
					for (String linha : arrayLinhaDoArquivo) {
						modelo.addElement(linha);						
					}								
											
					lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		btnImpTxtForEachExterno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();			
					
					
					modelo.clear();
					
					arrayLinhaDoArquivo.forEach(linha -> modelo.addElement(linha));											
											
					lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		btnImpBdConect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					String servDriver = "jdbc:ucanaccess://";
					String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
					String connectionString = servDriver + bancoDeDados.trim();
					
					con = DriverManager.getConnection(connectionString);
					
					String sql = "SELECT Descricao FROM Preferencias_3";
					
					PreparedStatement ps = con.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						modelo.addElement(rs.getString("Descricao"));						
					}
					lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(minhaJanela, "ERRO AO CONECTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(minhaJanela, "ERRO AO FECHAR A CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
			}
		});
		
		btnImpBdDesconect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				List<String> dadosLocais = new ArrayList<String>();
				try {
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					String servDriver = "jdbc:ucanaccess://";
					String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
					String connectionString = servDriver + bancoDeDados.trim();
					
					con = DriverManager.getConnection(connectionString);
					
					String sql = "SELECT Descricao FROM Preferencias_3";
					
					PreparedStatement ps = con.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						String descricao = rs.getString("Descricao");
						modelo.addElement(descricao);	
						
						dadosLocais.add(descricao);
					}
					lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(minhaJanela, "ERRO AO CONECTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(minhaJanela, "ERRO AO FECHAR A CONEXÃO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
			}
		});
		
		btnLimpTxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> modelo = new DefaultListModel<String>();
				modelo.clear();
				lstbxPreferencias.setModel(modelo);			
			}
		});
		
	}
	
	public static void main (String[] args) {
		new JanelaGrafica();
	}
}