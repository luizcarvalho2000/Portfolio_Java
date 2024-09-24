import Business.PreferenciasBusiness;
import MODEL.PreferenciasVO;

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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FrmJanelaGrafica {
	JFrame minhaJanela;
	JList<String> lstbxPreferencias;
	JScrollPane scrlPreferencias;
	JPanel dtgvwPreferencias;
	DefaultTableModel modelo;
	JTable table;
	PreferenciasBusiness objPreferencias;
	
	// criando janela principal
	
	public FrmJanelaGrafica() {
		minhaJanela = new JFrame();
		minhaJanela.setTitle("Janela Grafica");
		minhaJanela.setSize(500,720);
		minhaJanela.setLocale(null);
		minhaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		minhaJanela.setResizable(true);
		
		ImageIcon backgroundImage = new ImageIcon("C:\\Curso programar\\Java\\ExercicioModel_01_10092024\\src\\imagens\\bg.jpg");
		Image originalImage = backgroundImage.getImage();
		Image resizedImage = originalImage.getScaledInstance(500, 720, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		
		JLabel backgroundLabel =  new JLabel(resizedIcon);
		backgroundLabel.setLayout(null);
		backgroundLabel.setBounds(0, 0, minhaJanela.getWidth(), minhaJanela.getHeight());
		
		minhaJanela.setContentPane(backgroundLabel);
		
		init();
		
		
		minhaJanela.setResizable(false);
		minhaJanela.setVisible(true);
	}
	
	private void init() {		
		Color Preto = Color.decode("#000000");
		Color Branco = Color.decode("#effafd");
		
		// Criando painel para agrupar componentes
		
		JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(0, 0, minhaJanela.getWidth(), minhaJanela.getHeight());
        minhaJanela.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBackground(Branco);
        
        // criando tamanho parta os componentes   
     
        //Padrão botões               
        final int intAltura = 25;
        final int intLargura = 200;
        final int intIncrementoY = 18;
        final int intDistanciaConsultarbtn = 25;
        
        
        final int intMargemEsquerda = 15;
        final int intMargemSuperior = 10;
        
        final int intIncrementoXLisBox = 220; 
        final int intAltLstbx = 423;
        final int intLargLstbx = 240;
        
        final int intDistanciaLblGrid = 450;
        final int intDistanciaConsultarLbl = 30;
        
        final int intAltDtgvw = 175;
        final int intLargDtgvw = 240;
        final int intIncrementoYGrid = 470;
        
        
        
        // criando botoes 
        
        JLabel lblMensagem = new JLabel("Mensagem :");
        lblMensagem.setSize(intLargura, intAltura);
        lblMensagem.setLocation(intMargemEsquerda, intMargemSuperior);
        lblMensagem.setForeground(Preto);
        panel.add(lblMensagem);        
        
        JButton btnMensagem = new JButton("Mensagem");
        btnMensagem.setSize(intLargura, intAltura);
        btnMensagem.setLocation(intMargemEsquerda, lblMensagem.getY() +intIncrementoY);
        btnMensagem.setBackground(Branco);
        btnMensagem.setForeground(Preto);
        panel.add(btnMensagem);
        
        JLabel lblDesvCond = new JLabel("Desvio Condicional :");
        lblDesvCond.setSize(intLargura, intAltura);
        lblDesvCond.setLocation(intMargemEsquerda, btnMensagem.getY() +intIncrementoY);
        lblDesvCond.setForeground(Preto);
        panel.add(lblDesvCond);
        
        JButton btnDesvCond = new JButton("Desvio Condicional");
        btnDesvCond.setSize(intLargura, intAltura);
        btnDesvCond.setLocation(intMargemEsquerda, lblDesvCond.getY() +intIncrementoY);
        btnDesvCond.setBackground(Branco);
        btnDesvCond.setForeground(Preto);
        panel.add(btnDesvCond);
        
        JLabel lblDesvEncad = new JLabel("Desvio Encadeado :");
        lblDesvEncad.setSize(intLargura, intAltura);
        lblDesvEncad.setLocation(intMargemEsquerda, btnDesvCond.getY() +intIncrementoY);
        lblDesvEncad.setForeground(Preto);
        panel.add(lblDesvEncad);
        
        JButton btnDesvEncad = new JButton("Desvio Encadeado");
        btnDesvEncad.setSize(intLargura, intAltura);
        btnDesvEncad.setLocation(intMargemEsquerda, lblDesvEncad.getY() +intIncrementoY);
        btnDesvEncad.setBackground(Branco);
        btnDesvEncad.setForeground(Preto);
        panel.add(btnDesvEncad);
        
        JLabel lblSwitchCase = new JLabel("Switch Case :");
        lblSwitchCase.setSize(intLargura, intAltura);
        lblSwitchCase.setLocation(intMargemEsquerda, btnDesvEncad.getY() +intIncrementoY);
        lblSwitchCase.setForeground(Preto);
        panel.add(lblSwitchCase);
        
        JButton btnSwitchCase = new JButton("Switch Case");
        btnSwitchCase.setSize(intLargura, intAltura);
        btnSwitchCase.setLocation(intMargemEsquerda, lblSwitchCase.getY() +intIncrementoY);
        btnSwitchCase.setBackground(Branco);
        btnSwitchCase.setForeground(Preto);
        panel.add(btnSwitchCase);
        
        JLabel lblImpTxtWhile = new JLabel("Importar Texto While :");
        lblImpTxtWhile.setSize(intLargura, intAltura);
        lblImpTxtWhile.setLocation(intMargemEsquerda, btnSwitchCase.getY() +intIncrementoY);
        lblImpTxtWhile.setForeground(Preto);
        panel.add(lblImpTxtWhile);
        
        JButton btnImpTxtWhile = new JButton("Importar Texto While");
        btnImpTxtWhile.setSize(intLargura, intAltura);
        btnImpTxtWhile.setLocation(intMargemEsquerda, lblImpTxtWhile.getY() +intIncrementoY);
        btnImpTxtWhile.setBackground(Branco);
        btnImpTxtWhile.setForeground(Preto);
        panel.add(btnImpTxtWhile);
        
        JLabel lblImpTxtDoWhile = new JLabel("Importar Texto Do While :");
        lblImpTxtDoWhile.setSize(intLargura, intAltura);
        lblImpTxtDoWhile.setLocation(intMargemEsquerda, btnImpTxtWhile.getY() +intIncrementoY);
        lblImpTxtDoWhile.setForeground(Preto);
        panel.add(lblImpTxtDoWhile);
        
        JButton btnImpTxtDoWhile = new JButton("Importar Texto Do While");
        btnImpTxtDoWhile.setSize(intLargura, intAltura);
        btnImpTxtDoWhile.setLocation(intMargemEsquerda, lblImpTxtDoWhile.getY() +intIncrementoY);
        btnImpTxtDoWhile.setBackground(Branco);
        btnImpTxtDoWhile.setForeground(Preto);
        panel.add(btnImpTxtDoWhile);
        
        JLabel lblImpTxtFor = new JLabel("Importar Texto For :");
        lblImpTxtFor.setSize(intLargura, intAltura);
        lblImpTxtFor.setLocation(intMargemEsquerda, btnImpTxtDoWhile.getY() +intIncrementoY);
        lblImpTxtFor.setForeground(Preto);
        panel.add(lblImpTxtFor);
        
        JButton btnImpTxtFor = new JButton("Importar Texto For");
        btnImpTxtFor.setSize(intLargura, intAltura);
        btnImpTxtFor.setLocation(intMargemEsquerda, lblImpTxtFor.getY() +intIncrementoY);
        btnImpTxtFor.setBackground(Branco);
        btnImpTxtFor.setForeground(Preto);
        panel.add(btnImpTxtFor);
        
        JLabel lblImpTxtForEachIntern = new JLabel("Importar Texto ForEach Interno :");
        lblImpTxtForEachIntern.setSize(intLargura, intAltura);
        lblImpTxtForEachIntern.setLocation(intMargemEsquerda, btnImpTxtFor.getY() +intIncrementoY);
        lblImpTxtForEachIntern.setForeground(Preto);
        panel.add(lblImpTxtForEachIntern);
        
        JButton btnImpTxtForEachIntern = new JButton("Importar Texto ForEach Interno");
        btnImpTxtForEachIntern.setSize(intLargura, intAltura);
        btnImpTxtForEachIntern.setLocation(intMargemEsquerda, lblImpTxtForEachIntern.getY() +intIncrementoY);
        btnImpTxtForEachIntern.setBackground(Branco);
        btnImpTxtForEachIntern.setForeground(Preto);
        panel.add(btnImpTxtForEachIntern);
        
        JLabel lblImpTxtForEachExt = new JLabel("Importar Texto ForEach Externo :");
        lblImpTxtForEachExt.setSize(intLargura, intAltura);
        lblImpTxtForEachExt.setLocation(intMargemEsquerda, btnImpTxtForEachIntern.getY() +intIncrementoY);
        lblImpTxtForEachExt.setForeground(Preto);
        panel.add(lblImpTxtForEachExt);
        
        JButton btnImpTxtForEachExt = new JButton("Importar Texto ForEach Externo");
        btnImpTxtForEachExt.setSize(intLargura, intAltura);
        btnImpTxtForEachExt.setLocation(intMargemEsquerda, lblImpTxtForEachExt.getY() +intIncrementoY);
        btnImpTxtForEachExt.setBackground(Branco);
        btnImpTxtForEachExt.setForeground(Preto);
        panel.add(btnImpTxtForEachExt);
        
        JLabel lblImpBdConect = new JLabel("Importar Banco Conectado :");
        lblImpBdConect.setSize(intLargura, intAltura);
        lblImpBdConect.setLocation(intMargemEsquerda, btnImpTxtForEachExt.getY() +intIncrementoY);
        lblImpBdConect.setForeground(Preto);
        panel.add(lblImpBdConect);
        
        JButton btnImpBdConect = new JButton("Importar Banco Conectado");
        btnImpBdConect.setSize(intLargura, intAltura);
        btnImpBdConect.setLocation(intMargemEsquerda, lblImpBdConect.getY() +intIncrementoY);
        btnImpBdConect.setBackground(Branco);
        btnImpBdConect.setForeground(Preto);
        panel.add(btnImpBdConect);
        
        JLabel lblImpBdDesconect = new JLabel("Desvio Encadeado :");
        lblImpBdDesconect.setSize(intLargura, intAltura);
        lblImpBdDesconect.setLocation(intMargemEsquerda, btnImpBdConect.getY() +intIncrementoY);
        lblImpBdDesconect.setForeground(Preto);
        panel.add(lblImpBdDesconect);
        
        JButton btnImpBdDesconect = new JButton("Importar Banco Desconectado");
        btnImpBdDesconect.setSize(intLargura, intAltura);
        btnImpBdDesconect.setLocation(intMargemEsquerda, lblImpBdDesconect.getY() +intIncrementoY);
        btnImpBdDesconect.setBackground(Branco);
        btnImpBdDesconect.setForeground(Preto);
        panel.add(btnImpBdDesconect);
        
        JLabel lblLimpTxt = new JLabel("Limpa Texto :");
        lblLimpTxt.setSize(intLargura, intAltura);
        lblLimpTxt.setLocation(intMargemEsquerda, btnImpBdDesconect.getY() +intIncrementoY);
        lblLimpTxt.setForeground(Preto);
        panel.add(lblLimpTxt);
        
        JButton btnLimpTxt = new JButton("Limpa Texto");
        btnLimpTxt.setSize(intLargura, intAltura);
        btnLimpTxt.setLocation(intMargemEsquerda, lblLimpTxt.getY() +intIncrementoY);
        btnLimpTxt.setBackground(Branco);
        btnLimpTxt.setForeground(Preto);
        panel.add(btnLimpTxt);
        
        // Criando ListBox
        
        JLabel lblLstbxPreferencias = new JLabel("Preferencias :");
        lblLstbxPreferencias.setSize(intLargura, intAltura);
        lblLstbxPreferencias.setLocation(intMargemEsquerda +intIncrementoXLisBox, intMargemSuperior);
        lblLstbxPreferencias.setForeground(Preto);
        panel.add(lblLstbxPreferencias);
        
        lstbxPreferencias = new JList<>();
        scrlPreferencias = new JScrollPane(lstbxPreferencias);
        scrlPreferencias.setBounds(intMargemEsquerda +intIncrementoXLisBox, intMargemSuperior +intIncrementoY, intLargLstbx, intAltLstbx);
        panel.add(scrlPreferencias);
        
        JSeparator LinhaSeparadora = new JSeparator(SwingConstants.HORIZONTAL);
        LinhaSeparadora.setBounds(intMargemEsquerda, btnLimpTxt.getY() +30, intLargura + 500, 50);
        LinhaSeparadora.setBackground(Preto);
        panel.add(LinhaSeparadora);       


        
        // Criando Botões Grid
        
        JLabel lblConsultarBd = new JLabel("Consultar Banco :");
        lblConsultarBd.setSize(intLargura, intAltura);
        lblConsultarBd.setLocation(intMargemEsquerda, btnLimpTxt.getY() +intDistanciaConsultarLbl);
        lblConsultarBd.setForeground(Preto);
        panel.add(lblConsultarBd);
        
        JButton btnConsultarBd = new JButton("Consultar Banco");
        btnConsultarBd.setSize(intLargura, intAltura);
        btnConsultarBd.setLocation(intMargemEsquerda, lblConsultarBd.getY() +intDistanciaConsultarbtn);
        btnConsultarBd.setBackground(Branco);
        btnConsultarBd.setForeground(Preto);
        panel.add(btnConsultarBd);
        
        JLabel lblInserirBd = new JLabel("Inserir Banco :");
        lblInserirBd.setSize(intLargura, intAltura);
        lblInserirBd.setLocation(intMargemEsquerda, btnConsultarBd.getY() +intIncrementoY);
        lblInserirBd.setForeground(Preto);
        panel.add(lblInserirBd);
        
        JButton btnInserirBd = new JButton("Inserir Banco");
        btnInserirBd.setSize(intLargura, intAltura);
        btnInserirBd.setLocation(intMargemEsquerda, lblInserirBd.getY() +intIncrementoY);
        btnInserirBd.setBackground(Branco);
        btnInserirBd.setForeground(Preto);
        panel.add(btnInserirBd);
        
        JLabel lblDeletarBd = new JLabel("Deletar Banco :");
        lblDeletarBd.setSize(intLargura, intAltura);
        lblDeletarBd.setLocation(intMargemEsquerda, btnInserirBd.getY() +intIncrementoY);
        lblDeletarBd.setForeground(Preto);
        panel.add(lblDeletarBd);
        
        JButton btnDeletarBd = new JButton("Deletar Banco");
        btnDeletarBd.setSize(intLargura, intAltura);
        btnDeletarBd.setLocation(intMargemEsquerda, lblDeletarBd.getY() +intIncrementoY);
        btnDeletarBd.setBackground(Branco);
        btnDeletarBd.setForeground(Preto);
        panel.add(btnDeletarBd);
        
        JLabel lblAlterarBd = new JLabel("Alterar Banco :");
        lblAlterarBd.setSize(intLargura, intAltura);
        lblAlterarBd.setLocation(intMargemEsquerda, btnDeletarBd.getY() +intIncrementoY);
        lblAlterarBd.setForeground(Preto);
        panel.add(lblAlterarBd);
        
        JButton btnAlterarBd = new JButton("Alterar Banco");
        btnAlterarBd.setSize(intLargura, intAltura);
        btnAlterarBd.setLocation(intMargemEsquerda, lblAlterarBd.getY() +intIncrementoY);
        btnAlterarBd.setBackground(Branco);
        btnAlterarBd.setForeground(Preto);
        panel.add(btnAlterarBd);

        JLabel lblLimparGridBd = new JLabel("Limpar Grid :");
        lblLimparGridBd.setSize(intLargura, intAltura);
        lblLimparGridBd.setLocation(intMargemEsquerda, btnAlterarBd.getY() +intIncrementoY);
        lblLimparGridBd.setForeground(Preto);
        panel.add(lblLimparGridBd);
        
        JButton btnLimparGridBd = new JButton("Limpar Grid");
        btnLimparGridBd.setSize(intLargura, intAltura);
        btnLimparGridBd.setLocation(intMargemEsquerda, lblLimparGridBd.getY() +intIncrementoY);
        btnLimparGridBd.setBackground(Branco);
        btnLimparGridBd.setForeground(Preto);
        panel.add(btnLimparGridBd);
        
        // Criando DataGrid
        
        JLabel lblDataGrid = new JLabel("Data Grid :");
        lblDataGrid.setSize(intLargura, intAltura);
        lblDataGrid.setLocation(intMargemEsquerda +intIncrementoXLisBox, intMargemSuperior +intDistanciaLblGrid);
        lblDataGrid.setForeground(Preto);
        panel.add(lblDataGrid);
        
        dtgvwPreferencias = new JPanel(new BorderLayout());
        dtgvwPreferencias.setBounds(intMargemEsquerda +intIncrementoXLisBox, intMargemSuperior +intIncrementoYGrid, intLargDtgvw, intAltDtgvw);
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
        
        ConsultarBd();
        
        btnMensagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(minhaJanela, "BEM VINDO AO MEU PROGRAMA JAVA");
				
			}
		});
        
        btnDesvCond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ECOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.OK_CANCEL_OPTION);
				
				if(opcao == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU OK");
				}
				
				else {
					JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU CANCELAR");
				}
				
			}
		});
        
        btnDesvEncad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(minhaJanela, "ECOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(opcao == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU SIM");
                }
				
				else if(opcao == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU NÃO");
                }
				
				else {
                    JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU CANCELAR");
                }
				
			}
		});
        
        btnSwitchCase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (JOptionPane.showConfirmDialog(minhaJanela, "ECOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION)) {
				case JOptionPane.YES_OPTION:
					JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU SIM");
                    break;
                
				case JOptionPane.NO_OPTION:
					JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU NÃO");
                    break;
                
				case JOptionPane.CANCEL_OPTION:
					JOptionPane.showMessageDialog(minhaJanela, "VOCE ESCOLHEU CANCELAR");
                    break;
                    
                default:
                	throw new IllegalArgumentException("Unexpected value:" + JOptionPane.showConfirmDialog(minhaJanela, "ESCOLHA UMA OPÇÃO", "OPÇÃO", JOptionPane.YES_NO_CANCEL_OPTION));
                
                  
				}
				
			}
		});
        
        btnImpTxtWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ImpTxtWhile();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnImpTxtDoWhile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ImpTxtDoWhile();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnImpTxtFor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ImpTxtFor();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnImpTxtForEachIntern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ImpTxtForEachIntern();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnImpTxtForEachExt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ImpTxtForEachExt();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnImpBdConect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ImpBdConect();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});                
        
        btnImpBdDesconect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					impBdDesconect();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnLimpTxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultListModel<String> modelo = new DefaultListModel<String>();
					modelo.clear();
					lstbxPreferencias.setModel(modelo);
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO LIMPAR O ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnConsultarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConsultarBd();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnInserirBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					InserirBd();
					ConsultarBd();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnDeletarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DeletarBd();
					ConsultarBd();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnAlterarBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AlterarBd();
					ConsultarBd();
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
        
        btnLimparGridBd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modelo.setRowCount(0);
				}
				
				catch (Exception ex) {
                    JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR LIMPAR" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
	}
	
	public void ImpTxtWhile() {
		try {
			objPreferencias = new PreferenciasBusiness();
			lstbxPreferencias.setModel(objPreferencias.impTxtWhile());
			
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void ImpTxtDoWhile() {
		try {
			objPreferencias = new PreferenciasBusiness();
			lstbxPreferencias.setModel(objPreferencias.impTxtDoWhile());
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void ImpTxtFor() {
		try {
			objPreferencias = new PreferenciasBusiness();
			lstbxPreferencias.setModel(objPreferencias.impTxtFor());
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void ImpTxtForEachIntern() {
		try {
			objPreferencias = new PreferenciasBusiness();
			lstbxPreferencias.setModel(objPreferencias.impTxtForInter());
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void ImpTxtForEachExt() {
		try {
			objPreferencias = new PreferenciasBusiness();
			lstbxPreferencias.setModel(objPreferencias.impTxtForExt());
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void ImpBdConect() {
		try {
			objPreferencias = new PreferenciasBusiness();
			lstbxPreferencias.setModel(objPreferencias.impBdConect());
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void impBdDesconect() {
		try {
			objPreferencias = new PreferenciasBusiness();
			lstbxPreferencias.setModel(objPreferencias.impBdDesconect());
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void ConsultarBd() {
		try {
			modelo.setRowCount(0);
			
			objPreferencias = new PreferenciasBusiness();
			ResultSet rsPreferencias = objPreferencias.ConsultarBd();
			
			while (rsPreferencias.next()) {
                String id = rsPreferencias.getString("ID");
                String descricao = rsPreferencias.getString("Descricao");
                modelo.addRow(new Object[] {id, descricao});
            }
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void InserirBd() {
		try {
			String strPreferenciasIncluidas = JOptionPane.showInputDialog(null, "DIGITE A PREFERENCIA A SER INCLUIDA");
			objPreferencias = new PreferenciasBusiness();
			PreferenciasVO preferencias = new PreferenciasVO();
			preferencias.setDescricao(strPreferenciasIncluidas);
			
			if (objPreferencias.InserirBd(preferencias)) {
				JOptionPane.showMessageDialog(minhaJanela, "PREFERENCIA INCLUIDA COM SUCESSO!");                
			}else {
				JOptionPane.showMessageDialog(minhaJanela, "ERRO AO INCLUIR PREFERENCIA!");
			}
			objPreferencias.ConsultarBd();			
			
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void DeletarBd() {
		try {
			JTable table = (JTable)((JScrollPane)dtgvwPreferencias.getComponent(0)).getViewport().getView();
			int selectedRow = table.getSelectedRow();
			
			if (selectedRow == -1) {
                JOptionPane.showMessageDialog(minhaJanela, "SELECIONE UMA PREFERENCIA PARA EXCLUIR");
                return;
            }
			
			int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
			objPreferencias = new PreferenciasBusiness();
			PreferenciasVO preferencias = new PreferenciasVO();
			preferencias.setId(id);
			
			if (objPreferencias.DeletarBd(preferencias)) {
				JOptionPane.showMessageDialog(minhaJanela, "PREFERENCIA EXCLUIDA COM SUCESSO!");
			}else {
				JOptionPane.showMessageDialog(minhaJanela, "ERRO AO EXCLUIR PREFERENCIA!");
			}
			objPreferencias.ConsultarBd();
			
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void AlterarBd() {
		try {
			String novaDescricao = JOptionPane.showInputDialog(null, "DIGITE A NOVA DESCRIÇÃO DE PREFERENCIAS");
			JTable table = (JTable)((JScrollPane)dtgvwPreferencias.getComponent(0)).getViewport().getView();
			int selectdRow = table.getSelectedRow();
			if (selectdRow == -1) {
				JOptionPane.showMessageDialog(null, "POR FAVOR, SELECIONE UMA LINHA PARA ALTERAR");
				return;
			}
			
			int id =Integer.parseInt((String) table.getValueAt(selectdRow, 0));
			objPreferencias = new PreferenciasBusiness();
			PreferenciasVO preferencias = new PreferenciasVO();
			preferencias.setDescricao(novaDescricao);
			preferencias.setId(id); 
			
			if (objPreferencias.AlterarBd(preferencias)) {
				JOptionPane.showMessageDialog(minhaJanela, "PREFERENCIA ALTERADA COM SUCESSO!");
			}else {
				JOptionPane.showMessageDialog(minhaJanela, "ERRO AO EXCLUIR PREFERENCIA!");
			}
			objPreferencias.ConsultarBd();
			
		}
		catch (Exception ex) {
            JOptionPane.showMessageDialog(minhaJanela, "ERRO AO IMPORTAR ARQUIVO" + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
	}	


}