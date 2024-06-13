import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MinhaJanela {
	JFrame minhaJanela;
	JList<String> lstbxPreferencias;
	JScrollPane scrlPreferencias;
	JPanel dtgdvwPreferencias;
	DefaultTableModel modelo;
	JTable table;
	
	// Criando janela principal
	
	public MinhaJanela() {
		minhaJanela = new JFrame();
		minhaJanela.setTitle("Janela Grafica");
		minhaJanela.setSize(500, 650);
		minhaJanela.setLocale(null);
		minhaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// iniciando componentes graficos
		
		init();
		minhaJanela.setVisible(true);
		
	}
	
	private void init() {
		Color Cinza = Color.decode("#708090");
		Color Prata = Color.decode("#c9c9c9");
		Color Branco = Color.decode("#effafd");
		
		// Criando painel para agrupar componentes
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Prata);
		
		//definindo tamanho e largura padrão
		
		int intLargura = 200;
		int intAltura = 15;
		int intMargEsquerda = 15;
		int intMargSuperior = 10;
		int intAltLstbx = 300;
		int intLargLstbx = 240;
		int intAltDtgdvw = 250;
		int intLargDtgdvw = 240;
		
		// adicionando panel a janela principal
		
		minhaJanela.getContentPane().add(panel, BorderLayout.CENTER);
		
		// Criando Botões
		
		JLabel lblMensagem = new JLabel("Mensagem :");
		lblMensagem.setSize(intLargura, intAltura);
		lblMensagem.setLocation(intMargEsquerda, intMargSuperior);
		panel.add(lblMensagem);
		
		JButton btnMensagem = new JButton("Mensagem");
		btnMensagem.setSize(intLargura, intAltura);
		btnMensagem.setLocation(intMargEsquerda, lblMensagem.getY() +18);
		btnMensagem.setBackground(Cinza);
		btnMensagem.setForeground(Branco);
		panel.add(btnMensagem);
		
		JLabel lblDesvCond = new JLabel("Desvio Condicional :");
		lblDesvCond.setSize(intLargura, intAltura);
		lblDesvCond.setLocation(intMargEsquerda, btnMensagem.getY() +18);
		panel.add(lblDesvCond);
		
		JButton btnDesvCond = new JButton("Desvio Condicional");
		btnDesvCond.setSize(intLargura, intAltura);
		btnDesvCond.setLocation(intMargEsquerda, lblDesvCond.getY() +18);
		btnDesvCond.setBackground(Cinza);
		btnDesvCond.setForeground(Branco);
		panel.add(btnDesvCond);
		
		JLabel lblDesvEncad = new JLabel("Desvio Encadeado :");
		lblDesvEncad.setSize(intLargura, intAltura);
		lblDesvEncad.setLocation(intMargEsquerda, btnDesvCond.getY() +18);
		panel.add(lblDesvEncad);
		
		JButton btnDesvEncad = new JButton("Desvio Encadeado");
		btnDesvEncad.setSize(intLargura, intAltura);
		btnDesvEncad.setLocation(intMargEsquerda, lblDesvEncad.getY() +18);
		btnDesvEncad.setBackground(Cinza);
		btnDesvEncad.setForeground(Branco);
		panel.add(btnDesvEncad);
		
		JLabel lblSwitchCase = new JLabel("Switch Case :");
		lblSwitchCase.setSize(intLargura, intAltura);
		lblSwitchCase.setLocation(intMargEsquerda, btnDesvEncad.getY() +18);
		panel.add(lblSwitchCase);
		
		JButton btnSwitchCase = new JButton("Switch Case");
		btnSwitchCase.setSize(intLargura, intAltura);
		btnSwitchCase.setLocation(intMargEsquerda, lblSwitchCase.getY() +18);
		btnSwitchCase.setBackground(Cinza);
		btnSwitchCase.setForeground(Branco);
		panel.add(btnSwitchCase);
		
		JLabel lblImpTxtWhile = new JLabel("Importa Texto While :");
		lblImpTxtWhile.setSize(intLargura, intAltura);
		lblImpTxtWhile.setLocation(intMargEsquerda, btnSwitchCase.getY() +18);
		panel.add(lblImpTxtWhile);
		
		JButton btnImpTxtWhile = new JButton("Importa Texto While");
		btnImpTxtWhile.setSize(intLargura, intAltura);
		btnImpTxtWhile.setLocation(intMargEsquerda, lblImpTxtWhile.getY() +18);
		btnImpTxtWhile.setBackground(Cinza);
		btnImpTxtWhile.setForeground(Branco);
		panel.add(btnImpTxtWhile);
		
		JLabel lblImpTxtDoWhile = new JLabel("Importa Texto Do While :");
		lblImpTxtDoWhile.setSize(intLargura, intAltura);
		lblImpTxtDoWhile.setLocation(intMargEsquerda, btnImpTxtWhile.getY() +18);
		panel.add(lblImpTxtDoWhile);
		
		JButton btnImpTxtDoWhile = new JButton("Importa Texto Do While");
		btnImpTxtDoWhile.setSize(intLargura, intAltura);
		btnImpTxtDoWhile.setLocation(intMargEsquerda, lblImpTxtDoWhile.getY() +18);
		btnImpTxtDoWhile.setBackground(Cinza);
		btnImpTxtDoWhile.setForeground(Branco);
		panel.add(btnImpTxtDoWhile);
		
		JLabel lblImpTxtFor = new JLabel("Importa Texto For :");
		lblImpTxtFor.setSize(intLargura, intAltura);
		lblImpTxtFor.setLocation(intMargEsquerda, btnImpTxtDoWhile.getY() +18);
		panel.add(lblImpTxtFor);
		
		JButton btnImpTxtFor = new JButton("Importa Texto For");
		btnImpTxtFor.setSize(intLargura, intAltura);
		btnImpTxtFor.setLocation(intMargEsquerda, lblImpTxtFor.getY() +18);
		btnImpTxtFor.setBackground(Cinza);
		btnImpTxtFor.setForeground(Branco);
		panel.add(btnImpTxtFor);
		
		JLabel lblImpTxtForEachInterno = new JLabel("Importa Texto ForEach Interno :");
		lblImpTxtForEachInterno.setSize(intLargura, intAltura);
		lblImpTxtForEachInterno.setLocation(intMargEsquerda, btnImpTxtFor.getY() +18);
		panel.add(lblImpTxtForEachInterno);
		
		JButton btnImpTxtForEachInterno = new JButton("Importa Texto ForEach Interno");
		btnImpTxtForEachInterno.setSize(intLargura, intAltura);
		btnImpTxtForEachInterno.setLocation(intMargEsquerda, lblImpTxtForEachInterno.getY() +18);
		btnImpTxtForEachInterno.setBackground(Cinza);
		btnImpTxtForEachInterno.setForeground(Branco);
		panel.add(btnImpTxtForEachInterno);
		
		JLabel lblImpTxtForEachExterno = new JLabel("Importa Texto ForEach Externo :");
		lblImpTxtForEachExterno.setSize(intLargura, intAltura);
		lblImpTxtForEachExterno.setLocation(intMargEsquerda, btnImpTxtForEachInterno.getY() +18);
		panel.add(lblImpTxtForEachExterno);
		
		JButton btnImpTxtForEachExterno = new JButton("Importa Texto ForEach Externo");
		btnImpTxtForEachExterno.setSize(intLargura, intAltura);
		btnImpTxtForEachExterno.setLocation(intMargEsquerda, lblImpTxtForEachExterno.getY() +18);
		btnImpTxtForEachExterno.setBackground(Cinza);
		btnImpTxtForEachExterno.setForeground(Branco);
		panel.add(btnImpTxtForEachExterno);
		
		JLabel lblImpBdConect = new JLabel("Importar Banco Conectado :");
		lblImpBdConect.setSize(intLargura, intAltura);
		lblImpBdConect.setLocation(intMargEsquerda, btnImpTxtForEachExterno.getY() +18);
		panel.add(lblImpBdConect);
		
		JButton btnImpBdConect = new JButton("Importar Banco Conectado");
		btnImpBdConect.setSize(intLargura, intAltura);
		btnImpBdConect.setLocation(intMargEsquerda, lblImpBdConect.getY() +18);
		btnImpBdConect.setBackground(Cinza);
		btnImpBdConect.setForeground(Branco);
		panel.add(btnImpBdConect);
		
		JLabel lblImpBdDesconect = new JLabel("Importar Banco Desconectado :");
		lblImpBdDesconect.setSize(intLargura, intAltura);
		lblImpBdDesconect.setLocation(intMargEsquerda, btnImpBdConect.getY() +18);
		panel.add(lblImpBdDesconect);
		
		JButton btnImpBdDesconect = new JButton("Importar Banco Desconectado");
		btnImpBdDesconect.setSize(intLargura, intAltura);
		btnImpBdDesconect.setLocation(intMargEsquerda, lblImpBdDesconect.getY() +18);
		btnImpBdDesconect.setBackground(Cinza);
		btnImpBdDesconect.setForeground(Branco);
		panel.add(btnImpBdDesconect);
		
		JLabel lblLimpaTxt = new JLabel("Limpa Texto :");
		lblLimpaTxt.setSize(intLargura, intAltura);
		lblLimpaTxt.setLocation(intMargEsquerda, btnImpBdDesconect.getY() +18);
		panel.add(lblLimpaTxt);
		
		JButton btnLimpaTxt = new JButton("Limpa Texto");
		btnLimpaTxt.setSize(intLargura, intAltura);
		btnLimpaTxt.setLocation(intMargEsquerda, lblLimpaTxt.getY() +18);
		btnLimpaTxt.setBackground(Cinza);
		btnLimpaTxt.setForeground(Branco);
		panel.add(btnLimpaTxt);
		
		JLabel lblConsultarBd = new JLabel("ConsultarBd :");
		lblConsultarBd.setSize(intLargura, intAltura);
		lblConsultarBd.setLocation(intMargEsquerda, btnLimpaTxt.getY() +36);
		panel.add(lblConsultarBd);
		
		JButton btnConsultarBd = new JButton("ConsultarBd");
		btnConsultarBd.setSize(intLargura, intAltura);
		btnConsultarBd.setLocation(intMargEsquerda, lblConsultarBd.getY() +18);
		btnConsultarBd.setBackground(Cinza);
		btnConsultarBd.setForeground(Branco);
		panel.add(btnConsultarBd);
		
		JLabel lblLimpaGrid = new JLabel("Limpa Grid :");
		lblLimpaGrid.setSize(intLargura, intAltura);
		lblLimpaGrid.setLocation(intMargEsquerda, btnConsultarBd.getY() +18);
		panel.add(lblLimpaGrid);
		
		JButton btnLimpaGrid = new JButton("Limpa Grid");
		btnLimpaGrid.setSize(intLargura, intAltura);
		btnLimpaGrid.setLocation(intMargEsquerda, lblLimpaGrid.getY() +18);
		btnLimpaGrid.setBackground(Cinza);
		btnLimpaGrid.setForeground(Branco);
		panel.add(btnLimpaGrid);
		
		// Criando ListBox
		
		lstbxPreferencias =  new JList<>();
		scrlPreferencias =  new JScrollPane(lstbxPreferencias);
		scrlPreferencias.setBounds(intMargEsquerda +220, intMargSuperior +18, intLargLstbx, intAltLstbx);
		panel.add(scrlPreferencias);
		
		// Criando Jtable
		
		dtgdvwPreferencias =  new JPanel(new BorderLayout());
		dtgdvwPreferencias.setBounds(intMargEsquerda +220, intMargSuperior +330, intLargDtgdvw, intAltDtgdvw);
		panel.add(dtgdvwPreferencias);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Descricao");
		
		table = new JTable(modelo);
		
		JScrollPane scrollPane = new JScrollPane(table);
		dtgdvwPreferencias.add(scrollPane, BorderLayout.CENTER);
		
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(0);
		column.setHeaderValue("ID");
		column = columnModel.getColumn(1);
		column.setHeaderValue("Descricao");
		table.getTableHeader().repaint();
		
		// Criando evento dos botões
		
		btnMensagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(minhaJanela, "BEM VINDO AO MEU PROGRAMA JAVA");
				
			}
		});
		
		btnDesvCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO :", "OPÇÃO", JOptionPane.OK_CANCEL_OPTION);
				if (opcao == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU OK");
				}else {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR");
				}
				
			}
		});
		
		btnDesvCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO :", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU SIM");
				}else if (opcao == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU NÃO");
				}else {
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR");
				}
				
			}
		});
		
		btnSwitchCase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO :", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION)) {
				case JOptionPane.YES_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU SIM");
				break;
				
				case JOptionPane.NO_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU NÃO");
				break;
				
				case JOptionPane.CANCEL_OPTION: 
					JOptionPane.showMessageDialog(minhaJanela, "VOCÊ ESCOLHEU CANCELAR");
				break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO :", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION));
				}
				
			}
		});
		
		btnImpTxtWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Curso programar\\Java\\Preferencias\\importar texto.txt");
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo =  new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					while (linhaDoArquivo < totalLinhaDoArquivo) {
						modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));
						linhaDoArquivo++;						
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
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo =  new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					do {
						modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));
						linhaDoArquivo++;
					} while (linhaDoArquivo < totalLinhaDoArquivo);
					
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
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo =  new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					for (linhaDoArquivo = 0; linhaDoArquivo < totalLinhaDoArquivo; linhaDoArquivo++) {
						 modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));
						
					}					
					
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
					List<String> arrayLinhaDoArquivo = Files.readAllLines(file.toPath());
					
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					
					int linhaDoArquivo = 0;
					int totalDeLinhaDoArquivo = arrayLinhaDoArquivo.size();
					
					modelo.clear();
					
					for (linhaDoArquivo = 0; linhaDoArquivo < totalDeLinhaDoArquivo; linhaDoArquivo++) {
						modelo.addElement(arrayLinhaDoArquivo.get(linhaDoArquivo));
						
					}	
					
					lstbxPreferencias.setModel(modelo);
					
					
				} catch (Exception ex) {
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
		
		btnLimpaTxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> modelo = new DefaultListModel<String>();
				modelo.clear();
				lstbxPreferencias.setModel(modelo);
				
			}
		});
		
		btnConsultarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultarBD();
				
				}		
		});
		
		btnLimpaGrid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.setRowCount(0);
				
			}
		});	
		
		
	}
	
	public void ConsultarBD() {
	    Connection con = null;
	    try {
	        modelo.setRowCount(0);
	        
	        String servidorDriver = "jdbc:ucanaccess://";
	        String bancoDeDados = "C:/Curso programar/Java/Preferencias/Preferencias_3_09022024.accdb";
	        String connectionString = servidorDriver + bancoDeDados.trim();
	        con = DriverManager.getConnection(connectionString);

	        String strSql = "SELECT ID, Descricao FROM Preferencias_3";
	        PreparedStatement psql = con.prepareStatement(strSql);
	        ResultSet rsPreferencias = psql.executeQuery();

	        while (rsPreferencias.next()) {
	            String id = rsPreferencias.getString("ID");
	            String descricao = rsPreferencias.getString("Descricao");
	            modelo.addRow(new Object[]{id, descricao});
	        }
	        
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Erro ao Executar: " + ex.getMessage());
	    } finally {
	        if (con != null) {
	            try {
	                con.close();
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados: " + ex.getMessage());
	            }
	        }
	    }	    
	    
	}
	
	public static void main(String[] args) {
		new MinhaJanela();
	}
}