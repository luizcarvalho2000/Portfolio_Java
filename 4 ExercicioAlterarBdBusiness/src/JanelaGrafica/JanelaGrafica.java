package JanelaGrafica;
import JanelaGrafica.Business.Preferencias;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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


public class JanelaGrafica {
	JFrame minhaJanela;
	JList<String> lstbxPreferencias;
	JScrollPane scrlPreferencias;
	JPanel dtgvwPreferencias;
	DefaultTableModel modelo;
	JTable table;
	Preferencias objPreferencias;
	
	// Criando Janela Principal
	
	public JanelaGrafica() {
		minhaJanela = new JFrame();
		minhaJanela.setTitle("Janela Grafica");
		minhaJanela.setSize(980, 500);
		minhaJanela.setLocale(null);
		minhaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\v_and\\Pictures\\bg.jpg");
		Image originalImage = backgroundIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(980, 500, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		
		
        JLabel backgroundLabel = new JLabel(resizedIcon);
        backgroundLabel.setLayout(null);
        backgroundLabel.setBounds(0, 0, minhaJanela.getWidth(), minhaJanela.getHeight());
        
        minhaJanela.setContentPane(backgroundLabel);
		
		init();
		ConsultarBd();	
		ImpTxtWhile();
		minhaJanela.setResizable(false);
		minhaJanela.setVisible(true);	

	}
	
	private void init() {
		Color Cinza = Color.decode("#708090");
		Color Preto = Color.decode("#000000");
		Color Branco = Color.decode("#effafd");
		
		// Criando Painel para agrupar componentes
		
		JPanel panel = new JPanel();
		panel.setLayout(null);				
		panel.setLayout(null);
	    panel.setOpaque(false);
	    panel.setBounds(0, 0, minhaJanela.getWidth(), minhaJanela.getHeight());
		minhaJanela.getContentPane().add(panel, BorderLayout.CENTER);	
		
		// Criando Tamanho dos componentes
		
		int intLargura = 200;
		int intAltura = 20;
		int intMargemEsquerda = 15;
		int intMargemSuperior =+ 10;
		int intAltLstbx = 415;
		int intLargLstbx = 240;
		int intAltDtgvw = 415;
		int intLargDtgvw = 240;
		
		// Criando Botões
		
		JLabel lblMensagem =  new JLabel("Mensagem :");
		lblMensagem.setSize(intLargura, intAltura);
		lblMensagem.setLocation(intMargemEsquerda, intMargemSuperior);
		lblMensagem.setForeground(Preto);
		panel.add(lblMensagem);
		
		JButton btnMensagem = new JButton("Mensagem");
		btnMensagem.setSize(intLargura, intAltura);
		btnMensagem.setLocation(intMargemEsquerda, lblMensagem.getY() +18);
		btnMensagem.setBackground(Branco);
		btnMensagem.setForeground(Preto);
		panel.add(btnMensagem);
		
		JLabel lblDesvCond =  new JLabel("Desvio Condicional :");
		lblDesvCond.setSize(intLargura, intAltura);
		lblDesvCond.setLocation(intMargemEsquerda, btnMensagem.getY() +18);
		lblDesvCond.setForeground(Preto);
		panel.add(lblDesvCond);
		
		JButton btnDesvCond = new JButton("Desvio Condicional");
		btnDesvCond.setSize(intLargura, intAltura);
		btnDesvCond.setLocation(intMargemEsquerda, lblDesvCond.getY() +18);
		btnDesvCond.setBackground(Branco);
		btnDesvCond.setForeground(Preto);
		panel.add(btnDesvCond);
		
		JLabel lblDesvEncad =  new JLabel("Desvio Encadeado :");
		lblDesvEncad.setSize(intLargura, intAltura);
		lblDesvEncad.setLocation(intMargemEsquerda, btnDesvCond.getY() +18);
		lblDesvCond.setForeground(Preto);
		panel.add(lblDesvEncad);
		
		JButton btnDesvEncad = new JButton("Desvio Encadeado");
		btnDesvEncad.setSize(intLargura, intAltura);
		btnDesvEncad.setLocation(intMargemEsquerda, lblDesvEncad.getY() +18);
		btnDesvEncad.setBackground(Branco);
		btnDesvEncad.setForeground(Preto);
		panel.add(btnDesvEncad);
		
		JLabel lblSwitchCase =  new JLabel("Switch Case :");
		lblSwitchCase.setSize(intLargura, intAltura);
		lblSwitchCase.setLocation(intMargemEsquerda, btnDesvEncad.getY() +18);
		lblSwitchCase.setForeground(Preto);
		panel.add(lblSwitchCase);
		
		JButton btnSwitchCase = new JButton("Switch Case");
		btnSwitchCase.setSize(intLargura, intAltura);
		btnSwitchCase.setLocation(intMargemEsquerda, lblSwitchCase.getY() +18);
		btnSwitchCase.setBackground(Branco);
		btnSwitchCase.setForeground(Preto);
		panel.add(btnSwitchCase);
		
		JLabel lblImpTxtWhile =  new JLabel("Importar Texto While :");
		lblImpTxtWhile.setSize(intLargura, intAltura);
		lblImpTxtWhile.setLocation(intMargemEsquerda, btnSwitchCase.getY() +18);
		lblImpTxtWhile.setForeground(Preto);
		panel.add(lblImpTxtWhile);
		
		JButton btnImpTxtWhile = new JButton("Importar Texto While");
		btnImpTxtWhile.setSize(intLargura, intAltura);
		btnImpTxtWhile.setLocation(intMargemEsquerda, lblImpTxtWhile.getY() +18);
		btnImpTxtWhile.setBackground(Branco);
		btnImpTxtWhile.setForeground(Preto);
		panel.add(btnImpTxtWhile);
		
		JLabel lblImpTxtDoWhile =  new JLabel("Importar Texto Do While :");
		lblImpTxtDoWhile.setSize(intLargura, intAltura);
		lblImpTxtDoWhile.setLocation(intMargemEsquerda, btnImpTxtWhile.getY() +18);
		lblImpTxtDoWhile.setForeground(Preto);
		panel.add(lblImpTxtDoWhile);
		
		JButton btnImpTxtDoWhile = new JButton("Importar Texto Do While");
		btnImpTxtDoWhile.setSize(intLargura, intAltura);
		btnImpTxtDoWhile.setLocation(intMargemEsquerda, lblImpTxtDoWhile.getY() +18);
		btnImpTxtDoWhile.setBackground(Branco);
		btnImpTxtDoWhile.setForeground(Preto);
		panel.add(btnImpTxtDoWhile);
		
		JLabel lblImpTxtFor =  new JLabel("Importar Texto For :");
		lblImpTxtFor.setSize(intLargura, intAltura);
		lblImpTxtFor.setLocation(intMargemEsquerda, btnImpTxtDoWhile.getY() +18);
		lblImpTxtFor.setForeground(Preto);
		panel.add(lblImpTxtFor);
		
		JButton btnImpTxtFor = new JButton("Importar Texto For");
		btnImpTxtFor.setSize(intLargura, intAltura);
		btnImpTxtFor.setLocation(intMargemEsquerda, lblImpTxtFor.getY() +18);
		btnImpTxtFor.setBackground(Branco);
		btnImpTxtFor.setForeground(Preto);
		panel.add(btnImpTxtFor);
		
		JLabel lblImpTxtForEachInter =  new JLabel("Importar Texto ForEach Interno :");
		lblImpTxtForEachInter.setSize(intLargura, intAltura);
		lblImpTxtForEachInter.setLocation(intMargemEsquerda, btnImpTxtFor.getY() +18);
		lblImpTxtForEachInter.setForeground(Preto);
		panel.add(lblImpTxtForEachInter);
		
		JButton btnImpTxtForEachInter = new JButton("Importar Texto ForEach Interno");
		btnImpTxtForEachInter.setSize(intLargura, intAltura);
		btnImpTxtForEachInter.setLocation(intMargemEsquerda, lblImpTxtForEachInter.getY() +18);
		btnImpTxtForEachInter.setBackground(Branco);
		btnImpTxtForEachInter.setForeground(Preto);
		panel.add(btnImpTxtForEachInter);
		
		JLabel lblImpTxtForEachExtern =  new JLabel("Importar Texto ForEach Externo :");
		lblImpTxtForEachExtern.setSize(intLargura, intAltura);
		lblImpTxtForEachExtern.setLocation(intMargemEsquerda, btnImpTxtForEachInter.getY() +18);
		lblImpTxtForEachExtern.setForeground(Preto);
		panel.add(lblImpTxtForEachExtern);
		
		JButton btnImpTxtForEachExtern = new JButton("Importar Texto ForEach Externo");
		btnImpTxtForEachExtern.setSize(intLargura, intAltura);
		btnImpTxtForEachExtern.setLocation(intMargemEsquerda, lblImpTxtForEachExtern.getY() +18);
		btnImpTxtForEachExtern.setBackground(Branco);
		btnImpTxtForEachExtern.setForeground(Preto);
		panel.add(btnImpTxtForEachExtern);
		
		JLabel lblImpBdConect =  new JLabel("Importar Banco Conectado :");
		lblImpBdConect.setSize(intLargura, intAltura);
		lblImpBdConect.setLocation(intMargemEsquerda, btnImpTxtForEachExtern.getY() +18);
		lblImpBdConect.setForeground(Preto);
		panel.add(lblImpBdConect);
		
		JButton btnImpBdConect = new JButton("Importar Banco Conectado");
		btnImpBdConect.setSize(intLargura, intAltura);
		btnImpBdConect.setLocation(intMargemEsquerda, lblImpBdConect.getY() +18);
		btnImpBdConect.setBackground(Branco);
		btnImpBdConect.setForeground(Preto);
		panel.add(btnImpBdConect);
		
		JLabel lblImpBdDesconect =  new JLabel("Importar Banco Desconectado :");
		lblImpBdDesconect.setSize(intLargura, intAltura);
		lblImpBdDesconect.setLocation(intMargemEsquerda, btnImpBdConect.getY() +18);
		lblImpBdDesconect.setForeground(Preto);
		panel.add(lblImpBdDesconect);
		
		JButton btnImpBdDesconect = new JButton("Importar Banco Desconectado");
		btnImpBdDesconect.setSize(intLargura, intAltura);
		btnImpBdDesconect.setLocation(intMargemEsquerda, lblImpBdDesconect.getY() +18);
		btnImpBdDesconect.setBackground(Branco);
		btnImpBdDesconect.setForeground(Preto);
		panel.add(btnImpBdDesconect);
		
		JLabel lblLimpTxt =  new JLabel("Limpar Texto :");
		lblLimpTxt.setSize(intLargura, intAltura);
		lblLimpTxt.setLocation(intMargemEsquerda, btnImpBdDesconect.getY() +18);
		lblLimpTxt.setForeground(Preto);
		panel.add(lblLimpTxt);
		
		JButton btnLimpTxt = new JButton("Limpar Texto");
		btnLimpTxt.setSize(intLargura, intAltura);
		btnLimpTxt.setLocation(intMargemEsquerda, lblLimpTxt.getY() +18);
		btnLimpTxt.setBackground(Branco);
		btnLimpTxt.setForeground(Preto);
		panel.add(btnLimpTxt);		
		
		// ListBox
		
		JLabel lblLstbx =  new JLabel("Preferencias :");
		lblLstbx.setSize(intLargura, intAltura);
		lblLstbx.setLocation(intMargemEsquerda +220, intMargemSuperior);
		lblLstbx.setForeground(Preto);
		panel.add(lblLstbx);
		
		lstbxPreferencias = new JList<>();
		scrlPreferencias = new JScrollPane(lstbxPreferencias);
		scrlPreferencias.setBounds(intMargemEsquerda +220, intMargemSuperior +18, intLargLstbx, intAltLstbx);
		panel.add(scrlPreferencias);
		
		// Botões da grid
		
		JLabel lblConsultBd =  new JLabel("Consultar Banco :");
		lblConsultBd.setSize(intLargura, intAltura);
		lblConsultBd.setLocation(intMargemEsquerda + 480, intMargemSuperior);
		lblConsultBd.setForeground(Preto);
		panel.add(lblConsultBd);
		
		JButton btnConsultBd = new JButton("Consultar Banco");
		btnConsultBd.setSize(intLargura, intAltura);
		btnConsultBd.setLocation(intMargemEsquerda + 480, lblConsultBd.getY() +18);
		btnConsultBd.setBackground(Branco);
		btnConsultBd.setForeground(Preto);
		panel.add(btnConsultBd);
		
		JLabel lblInserirBd =  new JLabel("Inserir Banco :");
		lblInserirBd.setSize(intLargura, intAltura);
		lblInserirBd.setLocation(intMargemEsquerda + 480, btnConsultBd.getY() +18);
		lblInserirBd.setForeground(Preto);
		panel.add(lblInserirBd);
		
		JButton btnInserirBd = new JButton("Inserir Banco");
		btnInserirBd.setSize(intLargura, intAltura);
		btnInserirBd.setLocation(intMargemEsquerda  + 480, lblInserirBd.getY() +18);
		btnInserirBd.setBackground(Branco);
		btnInserirBd.setForeground(Preto);
		panel.add(btnInserirBd);
		
		JLabel lblDeletarBd =  new JLabel("Deletar Banco :");
		lblDeletarBd.setSize(intLargura, intAltura);
		lblDeletarBd.setLocation(intMargemEsquerda  + 480, btnInserirBd.getY() +18);
		lblDeletarBd.setForeground(Preto);
		panel.add(lblDeletarBd);
		
		JButton btnDeletarBd = new JButton("Deletar Banco");
		btnDeletarBd.setSize(intLargura, intAltura);
		btnDeletarBd.setLocation(intMargemEsquerda  + 480, lblDeletarBd.getY() +18);
		btnDeletarBd.setBackground(Branco);
		btnDeletarBd.setForeground(Preto);
		panel.add(btnDeletarBd);
		
		JLabel lblAlterarBd =  new JLabel("Alterar Banco :");
		lblAlterarBd.setSize(intLargura, intAltura);
		lblAlterarBd.setLocation(intMargemEsquerda  + 480, btnDeletarBd.getY() +18);
		lblAlterarBd.setForeground(Preto);
		panel.add(lblAlterarBd);
		
		JButton btnAlterarBd = new JButton("Alterar Banco");
		btnAlterarBd.setSize(intLargura, intAltura);
		btnAlterarBd.setLocation(intMargemEsquerda  + 480, lblAlterarBd.getY() +18);
		btnAlterarBd.setBackground(Branco);
		btnAlterarBd.setForeground(Preto);
		panel.add(btnAlterarBd);
		
		JLabel lblLimpaGrid =  new JLabel("Limpa Grid :");
		lblLimpaGrid.setSize(intLargura, intAltura);
		lblLimpaGrid.setLocation(intMargemEsquerda  + 480, btnAlterarBd.getY() +18);
		lblLimpaGrid.setForeground(Preto);
		panel.add(lblLimpaGrid);
		
		JButton btnLimpaGrid = new JButton("Limpa Grid");
		btnLimpaGrid.setSize(intLargura, intAltura);
		btnLimpaGrid.setLocation(intMargemEsquerda  + 480, lblLimpaGrid.getY() +18);
		btnLimpaGrid.setBackground(Branco);
		btnLimpaGrid.setForeground(Preto);
		panel.add(btnLimpaGrid);
		
		//Criando JTable
		
		JLabel lblDataGrid =  new JLabel("Tabela de Preferencias :");
		lblDataGrid.setSize(intLargura, intAltura);
		lblDataGrid.setLocation(intMargemEsquerda + 700, intMargemSuperior);
		lblDataGrid.setForeground(Preto);
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
		column.setPreferredWidth(10);
		column = columnModel.getColumn(1);
		column.setHeaderValue("Descricao");
		column.setPreferredWidth(60);
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
					
					ImpTxtWhile();			
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
		
		btnImpTxtDoWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					ImpTxtDoWhile();
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpTxtFor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					ImpTxtFor();					
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpTxtForEachInter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
						ImpTxtForEachInter();
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpTxtForEachExtern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
						ImpTxtForEachExtern();
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnImpBdConect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
						objPreferencias = new Preferencias();
						lstbxPreferencias.setModel(objPreferencias.impBdConect());
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}				
			
		});
		
		btnImpBdDesconect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
						objPreferencias = new Preferencias();
						lstbxPreferencias.setModel(objPreferencias.impBdDesconect());
					
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O BANCO DE DADOS" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
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
				InserirBd();
				ConsultarBd();
						
			}
		});
		
		btnDeletarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeletarBd();
				ConsultarBd();
				
			}
		});
		
		btnAlterarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AlterarBd();
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
	
	public void ImpTxtWhile() {
		try {					
				objPreferencias = new Preferencias();
				lstbxPreferencias.setModel(objPreferencias.impTxtWhile());					
				
			} catch (Exception ex) {
				JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void ImpTxtDoWhile() {
		try {					
				objPreferencias = new Preferencias();
				lstbxPreferencias.setModel(objPreferencias.impTxtDoWhile());			
				
			} catch (Exception ex) {
				JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void ImpTxtFor() {
		try {					
				
				objPreferencias = new Preferencias();
				lstbxPreferencias.setModel(objPreferencias.impTxtFor());					
				
			} catch (Exception ex) {
				JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void ImpTxtForEachInter() {
		try {					
				objPreferencias = new Preferencias();
				lstbxPreferencias.setModel(objPreferencias.impTxtForEachInter());					
				
			} catch (Exception ex) {
				JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void ImpTxtForEachExtern() {
		try {					
				objPreferencias = new Preferencias();
				lstbxPreferencias.setModel(objPreferencias.impTxtForEachExter());				
				
			} catch (Exception ex) {
				JOptionPane.showConfirmDialog(minhaJanela, "ERRO AO IMPORTAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	
	public void ConsultarBd() {
		try {
			modelo.setRowCount(0);
							
			objPreferencias = new Preferencias();
			ResultSet rsPreferencias = objPreferencias.ConsultarBd();
			
			while (rsPreferencias.next()) {
				String id = rsPreferencias.getString("ID");
				String descricao = rsPreferencias.getString("Descricao");
				modelo.addRow(new Object[] {id, descricao});
			}
				
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela,  "Erro ao Executar" + ex.getMessage().toString());
		}	
	}
	
	public void InserirBd() {
		try {
			
			String strPreferenciasIncluidas = JOptionPane.showInputDialog(null, "DIGITE A PREFERENCIA A SER INCLUIDA");
			objPreferencias = new Preferencias();
			
			if (objPreferencias.InserirBd(strPreferenciasIncluidas)) {
				JOptionPane.showMessageDialog(minhaJanela, "INSERIDO COM SUCESSO");
			}else {
				JOptionPane.showMessageDialog(minhaJanela, "ERRO AIO INSERIR");
			}
			objPreferencias.ConsultarBd();
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO EXECULTAR" + ex.getMessage().toString());						
		}		
	}
	
	public void DeletarBd() {
		try {					
			
			JTable table = (JTable)((JScrollPane)dtgvwPreferencias.getComponent(0)).getViewport().getView();
			int selectedRow = table.getSelectedRow();
			
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "POR FAVOR, SELECIONE UMA LINHA PARA EXCLUIR!");
				return;
			}
			
			int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
			objPreferencias = new Preferencias();
			
			if (objPreferencias.DeletarBd(id)) {
				JOptionPane.showMessageDialog(minhaJanela, "EXCLUIDO COM SUCESSO");
			}else {
				JOptionPane.showMessageDialog(minhaJanela, "ERRO AIO EXCLUIR");
			}
			objPreferencias.ConsultarBd();			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO EXECULTAR" + ex.getMessage().toString());
		}				
	}
	
	public void AlterarBd() {
		try {
			
			String novaDescricao = JOptionPane.showInputDialog(null, "DIGITE A NOVA DESCRIÇÃO DE PREFERENCIA:");
			JTable table = (JTable)((JScrollPane)dtgvwPreferencias.getComponent(0)).getViewport().getView();
			int selectedRow = table.getSelectedRow();						
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "POR FAVOR, SELECIONE UMA LINHA PARA ALTERAR!");
				return;
			}
			
			int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));		
			objPreferencias = new Preferencias();
			
			if (objPreferencias.AlterarBd(novaDescricao, id)) {
				JOptionPane.showMessageDialog(minhaJanela, "ALTERADO COM SUCESSO");
			}else {
				JOptionPane.showMessageDialog(minhaJanela, "ERRO AIO ALTERAR");
			}
			objPreferencias.ConsultarBd();
			
			
		}  catch (Exception ex) {
			JOptionPane.showMessageDialog(minhaJanela, "ERRO AO EXECULTAR" + ex.getMessage().toString());
		}
	}
	
	
	public static void main (String[] args) {
		new JanelaGrafica();
	}
}