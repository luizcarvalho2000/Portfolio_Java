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
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class JanelaGrafica {
	JFrame minhaJanela;
	JList<String> lstbxPreferencias;
	JScrollPane scrlPreferencias;
	JPanel dtgvwPreferencias;
	DefaultTableModel modelo;
	JTable table;
	
	// Criando Janel Principal
	
	public JanelaGrafica() {
		minhaJanela = new JFrame();
		minhaJanela.setTitle("Janela Grafica");
		minhaJanela.setSize(980, 500);
		minhaJanela.setLocale(null);
		minhaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// iniciando componetes graficos

		init();
		ConsultarBd();
		minhaJanela.setVisible(true);
	}
	
	private void init() {
		Color Cinza = Color.decode("#708090");
		Color Prata = Color.decode("#c9c9c9");
		Color Branco = Color.decode("#effafd");
		
		// Criando Painel para agrupar componentes
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Prata);
		
		// Criando Tamanho dos componentes
		
		int intLargura = 200;
		int intAltura = 20;
		int intMargemEsquerda = 15;
		int intMargemSuperior =+ 10;
		int intAltLstbx = 415;
		int intLargLstbx = 240;
		int intAltDtgvw = 250;
		int intLargDtgvw = 240;
		
		// Adicionando panel a janela principal
		
		minhaJanela.getContentPane().add(panel, BorderLayout.CENTER);
		
		// Criando Botões
		
		JLabel lblMensagem =  new JLabel("Mensagem :");
		lblMensagem.setSize(intLargura, intAltura);
		lblMensagem.setLocation(intMargemEsquerda, intMargemSuperior);
		panel.add(lblMensagem);
		
		JButton btnMensagem = new JButton("Mensagem");
		btnMensagem.setSize(intLargura, intAltura);
		btnMensagem.setLocation(intMargemEsquerda, lblMensagem.getY() +18);
		btnMensagem.setBackground(Cinza);
		btnMensagem.setForeground(Branco);
		panel.add(btnMensagem);
		
		JLabel lblDesvCond =  new JLabel("Desvio Condicional :");
		lblDesvCond.setSize(intLargura, intAltura);
		lblDesvCond.setLocation(intMargemEsquerda, btnMensagem.getY() +18);
		panel.add(lblDesvCond);
		
		JButton btnDesvCond = new JButton("Desvio Condicional");
		btnDesvCond.setSize(intLargura, intAltura);
		btnDesvCond.setLocation(intMargemEsquerda, lblDesvCond.getY() +18);
		btnDesvCond.setBackground(Cinza);
		btnDesvCond.setForeground(Branco);
		panel.add(btnDesvCond);
		
		JLabel lblDesvEncad =  new JLabel("Desvio Encadeado :");
		lblDesvEncad.setSize(intLargura, intAltura);
		lblDesvEncad.setLocation(intMargemEsquerda, btnDesvCond.getY() +18);
		panel.add(lblDesvEncad);
		
		JButton btnDesvEncad = new JButton("Desvio Encadeado");
		btnDesvEncad.setSize(intLargura, intAltura);
		btnDesvEncad.setLocation(intMargemEsquerda, lblDesvEncad.getY() +18);
		btnDesvEncad.setBackground(Cinza);
		btnDesvEncad.setForeground(Branco);
		panel.add(btnDesvEncad);
		
		JLabel lblSwitchCase =  new JLabel("Switch Case :");
		lblSwitchCase.setSize(intLargura, intAltura);
		lblSwitchCase.setLocation(intMargemEsquerda, btnDesvEncad.getY() +18);
		panel.add(lblSwitchCase);
		
		JButton btnSwitchCase = new JButton("Switch Case");
		btnSwitchCase.setSize(intLargura, intAltura);
		btnSwitchCase.setLocation(intMargemEsquerda, lblSwitchCase.getY() +18);
		btnSwitchCase.setBackground(Cinza);
		btnSwitchCase.setForeground(Branco);
		panel.add(btnSwitchCase);
		
		JLabel lblImpTxtWhile =  new JLabel("Importar Texto While :");
		lblImpTxtWhile.setSize(intLargura, intAltura);
		lblImpTxtWhile.setLocation(intMargemEsquerda, btnSwitchCase.getY() +18);
		panel.add(lblImpTxtWhile);
		
		JButton btnImpTxtWhile = new JButton("Importar Texto While");
		btnImpTxtWhile.setSize(intLargura, intAltura);
		btnImpTxtWhile.setLocation(intMargemEsquerda, lblImpTxtWhile.getY() +18);
		btnImpTxtWhile.setBackground(Cinza);
		btnImpTxtWhile.setForeground(Branco);
		panel.add(btnImpTxtWhile);
		
		JLabel lblImpTxtDoWhile =  new JLabel("Importar Texto Do While :");
		lblImpTxtDoWhile.setSize(intLargura, intAltura);
		lblImpTxtDoWhile.setLocation(intMargemEsquerda, btnImpTxtWhile.getY() +18);
		panel.add(lblImpTxtDoWhile);
		
		JButton btnImpTxtDoWhile = new JButton("Importar Texto Do While");
		btnImpTxtDoWhile.setSize(intLargura, intAltura);
		btnImpTxtDoWhile.setLocation(intMargemEsquerda, lblImpTxtDoWhile.getY() +18);
		btnImpTxtDoWhile.setBackground(Cinza);
		btnImpTxtDoWhile.setForeground(Branco);
		panel.add(btnImpTxtDoWhile);
		
		JLabel lblImpTxtFor =  new JLabel("Importar Texto For :");
		lblImpTxtFor.setSize(intLargura, intAltura);
		lblImpTxtFor.setLocation(intMargemEsquerda, btnImpTxtDoWhile.getY() +18);
		panel.add(lblImpTxtFor);
		
		JButton btnImpTxtFor = new JButton("Importar Texto For");
		btnImpTxtFor.setSize(intLargura, intAltura);
		btnImpTxtFor.setLocation(intMargemEsquerda, lblImpTxtFor.getY() +18);
		btnImpTxtFor.setBackground(Cinza);
		btnImpTxtFor.setForeground(Branco);
		panel.add(btnImpTxtFor);
		
		JLabel lblImpTxtForEachInter =  new JLabel("Importar Texto ForEach Interno :");
		lblImpTxtForEachInter.setSize(intLargura, intAltura);
		lblImpTxtForEachInter.setLocation(intMargemEsquerda, btnImpTxtFor.getY() +18);
		panel.add(lblImpTxtForEachInter);
		
		JButton btnImpTxtForEachInter = new JButton("Importar Texto ForEach Interno");
		btnImpTxtForEachInter.setSize(intLargura, intAltura);
		btnImpTxtForEachInter.setLocation(intMargemEsquerda, lblImpTxtForEachInter.getY() +18);
		btnImpTxtForEachInter.setBackground(Cinza);
		btnImpTxtForEachInter.setForeground(Branco);
		panel.add(btnImpTxtForEachInter);
		
		JLabel lblImpTxtForEachExtern =  new JLabel("Importar Texto ForEach Externo :");
		lblImpTxtForEachExtern.setSize(intLargura, intAltura);
		lblImpTxtForEachExtern.setLocation(intMargemEsquerda, btnImpTxtForEachInter.getY() +18);
		panel.add(lblImpTxtForEachExtern);
		
		JButton btnImpTxtForEachExtern = new JButton("Importar Texto ForEach Externo");
		btnImpTxtForEachExtern.setSize(intLargura, intAltura);
		btnImpTxtForEachExtern.setLocation(intMargemEsquerda, lblImpTxtForEachExtern.getY() +18);
		btnImpTxtForEachExtern.setBackground(Cinza);
		btnImpTxtForEachExtern.setForeground(Branco);
		panel.add(btnImpTxtForEachExtern);
		
		JLabel lblImpBdConect =  new JLabel("Importar Banco Conectado :");
		lblImpBdConect.setSize(intLargura, intAltura);
		lblImpBdConect.setLocation(intMargemEsquerda, btnImpTxtForEachExtern.getY() +18);
		panel.add(lblImpBdConect);
		
		JButton btnImpBdConect = new JButton("Importar Banco Conectado");
		btnImpBdConect.setSize(intLargura, intAltura);
		btnImpBdConect.setLocation(intMargemEsquerda, lblImpBdConect.getY() +18);
		btnImpBdConect.setBackground(Cinza);
		btnImpBdConect.setForeground(Branco);
		panel.add(btnImpBdConect);
		
		JLabel lblImpBdDesconect =  new JLabel("Importar Banco Desconectado :");
		lblImpBdDesconect.setSize(intLargura, intAltura);
		lblImpBdDesconect.setLocation(intMargemEsquerda, btnImpBdConect.getY() +18);
		panel.add(lblImpBdDesconect);
		
		JButton btnImpBdDesconect = new JButton("Importar Banco Desconectado");
		btnImpBdDesconect.setSize(intLargura, intAltura);
		btnImpBdDesconect.setLocation(intMargemEsquerda, lblImpBdDesconect.getY() +18);
		btnImpBdDesconect.setBackground(Cinza);
		btnImpBdDesconect.setForeground(Branco);
		panel.add(btnImpBdDesconect);
		
		JLabel lblLimpTxt =  new JLabel("Limpar Texto :");
		lblLimpTxt.setSize(intLargura, intAltura);
		lblLimpTxt.setLocation(intMargemEsquerda, btnImpBdDesconect.getY() +18);
		panel.add(lblLimpTxt);
		
		JButton btnLimpTxt = new JButton("Limpar Texto");
		btnLimpTxt.setSize(intLargura, intAltura);
		btnLimpTxt.setLocation(intMargemEsquerda, lblLimpTxt.getY() +18);
		btnLimpTxt.setBackground(Cinza);
		btnLimpTxt.setForeground(Branco);
		panel.add(btnLimpTxt);		
		
		// ListBox
		
		JLabel lblLstbx =  new JLabel("Preferencias :");
		lblLstbx.setSize(intLargura, intAltura);
		lblLstbx.setLocation(intMargemEsquerda +220, intMargemSuperior);
		panel.add(lblLstbx);
		
		lstbxPreferencias = new JList<>();
		scrlPreferencias = new JScrollPane(lstbxPreferencias);
		scrlPreferencias.setBounds(intMargemEsquerda +220, intMargemSuperior +18, intLargLstbx, intAltLstbx);
		panel.add(scrlPreferencias);
		
		// Botões da grid
		
		JLabel lblConsultBd =  new JLabel("Consultar Banco :");
		lblConsultBd.setSize(intLargura, intAltura);
		lblConsultBd.setLocation(intMargemEsquerda + 480, intMargemSuperior);
		panel.add(lblConsultBd);
		
		JButton btnConsultBd = new JButton("Consultar Banco");
		btnConsultBd.setSize(intLargura, intAltura);
		btnConsultBd.setLocation(intMargemEsquerda + 480, lblConsultBd.getY() +18);
		btnConsultBd.setBackground(Cinza);
		btnConsultBd.setForeground(Branco);
		panel.add(btnConsultBd);
		
		JLabel lblInserirBd =  new JLabel("Inserir Banco :");
		lblInserirBd.setSize(intLargura, intAltura);
		lblInserirBd.setLocation(intMargemEsquerda + 480, btnConsultBd.getY() +18);
		panel.add(lblInserirBd);
		
		JButton btnInserirBd = new JButton("Inserir Banco");
		btnInserirBd.setSize(intLargura, intAltura);
		btnInserirBd.setLocation(intMargemEsquerda  + 480, lblInserirBd.getY() +18);
		btnInserirBd.setBackground(Cinza);
		btnInserirBd.setForeground(Branco);
		panel.add(btnInserirBd);
		
		JLabel lblDeletarBd =  new JLabel("Deletar Banco :");
		lblDeletarBd.setSize(intLargura, intAltura);
		lblDeletarBd.setLocation(intMargemEsquerda  + 480, btnInserirBd.getY() +18);
		panel.add(lblDeletarBd);
		
		JButton btnDeletarBd = new JButton("Deletar Banco");
		btnDeletarBd.setSize(intLargura, intAltura);
		btnDeletarBd.setLocation(intMargemEsquerda  + 480, lblDeletarBd.getY() +18);
		btnDeletarBd.setBackground(Cinza);
		btnDeletarBd.setForeground(Branco);
		panel.add(btnDeletarBd);
		
		JLabel lblAlterarBd =  new JLabel("Alterar Banco :");
		lblAlterarBd.setSize(intLargura, intAltura);
		lblAlterarBd.setLocation(intMargemEsquerda  + 480, btnDeletarBd.getY() +18);
		panel.add(lblAlterarBd);
		
		JButton btnAlterarBd = new JButton("Alterar Banco");
		btnAlterarBd.setSize(intLargura, intAltura);
		btnAlterarBd.setLocation(intMargemEsquerda  + 480, lblAlterarBd.getY() +18);
		btnAlterarBd.setBackground(Cinza);
		btnAlterarBd.setForeground(Branco);
		panel.add(btnAlterarBd);
		
		JLabel lblLimpaGrid =  new JLabel("Limpa Grid :");
		lblLimpaGrid.setSize(intLargura, intAltura);
		lblLimpaGrid.setLocation(intMargemEsquerda  + 480, btnAlterarBd.getY() +18);
		panel.add(lblLimpaGrid);
		
		JButton btnLimpaGrid = new JButton("Limpa Grid");
		btnLimpaGrid.setSize(intLargura, intAltura);
		btnLimpaGrid.setLocation(intMargemEsquerda  + 480, lblLimpaGrid.getY() +18);
		btnLimpaGrid.setBackground(Cinza);
		btnLimpaGrid.setForeground(Branco);
		panel.add(btnLimpaGrid);
		
		//Criando JTable
		
		JLabel lblDataGrid =  new JLabel("Tabela de Preferencias :");
		lblDataGrid.setSize(intLargura, intAltura);
		lblDataGrid.setLocation(intMargemEsquerda + 700, intMargemSuperior);
		panel.add(lblDataGrid);
		
		dtgvwPreferencias = new JPanel(new BorderLayout());
		dtgvwPreferencias.setBounds(intMargemEsquerda + 700, intMargemSuperior +18, intLargDtgvw, intAltDtgvw);
		panel.add(dtgvwPreferencias);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Descricao");
		
		table = new JTable(modelo);
		
		JScrollPane scrollPane = new JScrollPane(table);
		dtgvwPreferencias.add(scrollPane, BorderLayout.CENTER);
		
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(0);
		column.setHeaderValue("ID");
		column = columnModel.getColumn(1);
		column.setHeaderValue("Descricao");
		table.getTableHeader().repaint();
		
		btnMensagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(minhaJanela, "BEM VINDO AO MEU PROGRAMA EM JAVA!");
				
			}
		});
		
		btnDesvCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.OK_CANCEL_OPTION);
				
				if (opcao == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU OK!");
				}
				else {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR!");
				}
				
			}
		});
		
		btnDesvEncad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if (opcao == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU SIM!");
				}
				else if (opcao == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU NÃO!");
					
				}				
				else  {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR!");
				}
				
			}
		});
		
		btnSwitchCase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION)) {
				case JOptionPane.YES_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU SIM!");
					break;
					
				case JOptionPane.NO_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU NÃO!");
					break;
					
				case JOptionPane.CANCEL_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR!");
					break;			
					
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION));
				}		
				
				
			}
		});
		
		btnImpTxtWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					
					List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					
					int linhaDoarquivo = 0;
					int totalDeLinhaDoArquivo = arrLinhaDoArquivo.size();
					
					modelo.clear();
					
					while (linhaDoarquivo < totalDeLinhaDoArquivo) {
						modelo.addElement(arrLinhaDoArquivo.get(linhaDoarquivo));
						
						linhaDoarquivo++;
						
					}lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpTxtDoWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpTxtFor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpTxtForEachInter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpTxtForEachExtern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					
					List<String> arrLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					
					modelo.clear();
					
					arrLinhaDoArquivo.forEach(linha -> modelo.addElement(linha));

					
				    lstbxPreferencias.setModel(modelo);
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpBdConect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		
		btnImpBdDesconect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		
		btnLimpTxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> modelo = new DefaultListModel<String>();
				modelo.clear();
				lstbxPreferencias.setModel(modelo);
				
			}
		});
		
		btnConsultBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultarBd();
				
			}
		});
		
		btnInserirBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strPreferenciasIncluidas = JOptionPane.showInputDialog(null, "DIGITE A PREFERENCIA A SER INCLUIDA");
				InserirBd(strPreferenciasIncluidas);
				ConsultarBd();
				
			}
		});
		
		btnDeletarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable)((JScrollPane)dtgvwPreferencias.getComponent(0)).getViewport().getView();
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "POR FAVOR, SELECIONE UMA LINHA PARA EXCLUIR!");
					return;
				}
				
				int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
				DeletarBd(id);
				
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.removeRow(selectedRow);
				modelo.fireTableDataChanged();
				ConsultarBd();
				
			}
		});
		
		btnAlterarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String novaDescricao = JOptionPane.showInputDialog(null, "DIGITE A NOVA DESCRIÇÃO DE PREFERENCIA:");
				JTable table = (JTable)((JScrollPane)dtgvwPreferencias.getComponent(0)).getViewport().getView();
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "POR FAVOR, SELECIONE UMA LINHA PARA ALTERAR!");
					return;
				}
				
				int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));			
				
				AlterarBd(novaDescricao, id);
				ConsultarBd();
				
			}
		});
		
		btnLimpaGrid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.setRowCount(0);
				
			}
		});		
		
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
	
	public static void main (String[] args) {
		new JanelaGrafica();
	}
}