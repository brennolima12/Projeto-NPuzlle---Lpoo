package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exception.CelulaException;
import exception.NumeroException;
import jogo.Comunicacao;
import jogo.Inicio;
import jogo.Jogador;
import repositorio.RepositorioJogador;
import repositorio.RepositorioTabuleiro;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro3x3;

public class Container implements ActionListener {

	private static JLabel userLabel;
	private static JTextField userText;
	private static JButton button;
	private static JLabel succes;
	private static JButton ajuda, salvar, carregar, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	
	static Tabuleiro tabuleiro;
	static int[][] Matriz;
	static long tempoInicial;

	public static void main(String[] args) {

		JPanel panel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel auxPanel = new JPanel();
		JFrame frame = new JFrame();

		buttonPanel.setLayout(new GridLayout(3, 3));
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(buttonPanel);
		panel.add(auxPanel);

		
		
		
		userLabel = new JLabel("Seu nome");

		panel.add(userLabel);

		userText = new JTextField(20);
		// userText.setBounds(100, 20, 50, 25);
		panel.add(userText);

		button = new JButton("Clique para jogar");
		button.setBounds(20, 20, 20, 20);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = userText.getText();
				button = new JButton("1");
				button.setBounds(20, 50, 50, 50);
				tempoInicial = System.currentTimeMillis();
				
			}

		});

		String[] choices = { "Fácil", "Médio", "Difícil" };
		final JComboBox<String> cb = new JComboBox<String>(choices);
		cb.setVisible(true);
		panel.add(cb);
		
		button.addActionListener(e -> {
			userLabel.setVisible(false);
			cb.setVisible(false);
			userText.setVisible(false);
			button.setVisible(false);
			Matriz = new int[3][3];
			tabuleiro = new Tabuleiro3x3();
			int contador = 0;
			for (int linha = 0; linha < Matriz.length; linha++) {
				for (int coluna = 0; coluna < Matriz[0].length; coluna++) {
					Matriz[linha][coluna] = contador;
					contador++;
				}
			}
			Inicio.shuffle(Matriz);
			try {
				tabuleiro.setCelula(Matriz);
			} catch (CelulaException e1) {
				e1.printStackTrace();
			}
			
			ajuda = new JButton("Ajuda");
			salvar = new JButton("Salvar");
			carregar = new JButton ("Carregar");
			auxPanel.add(ajuda);
			auxPanel.add(salvar);
			auxPanel.add(carregar);
			
			carregar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					RepositorioTabuleiro r = new RepositorioTabuleiro();
					Tabuleiro jogoSalvo = null;
					try {
						jogoSalvo = (Tabuleiro) r.buscarArquivoPorId(1);
						Matriz = jogoSalvo.getCelula();
						tabuleiro.setCelula(jogoSalvo.getCelula());
						carregaJogo();
						JOptionPane.showMessageDialog(null, "Jogo foi carregado");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					panel.validate();
				}

				private void carregaJogo() {
					b1.setText(Integer.toString(Matriz[0][0]));
					b2.setText(Integer.toString(Matriz[0][1]));
					b3.setText(Integer.toString(Matriz[0][2]));
					b4.setText(Integer.toString(Matriz[1][0]));
					b5.setText(Integer.toString(Matriz[1][1]));
					b6.setText(Integer.toString(Matriz[1][2]));
					b7.setText(Integer.toString(Matriz[2][0]));
					b8.setText(Integer.toString(Matriz[2][1]));
					b9.setText(Integer.toString(Matriz[2][2]));
				}		
			});
			
			salvar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					RepositorioTabuleiro r = new RepositorioTabuleiro();
					try {
						r.salvarJogo(1, tabuleiro);
						JOptionPane.showMessageDialog(null, "Seu jogo foi salvo");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				
			});
			
			ajuda.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Comunicacao c = new Comunicacao();
					try {
						JOptionPane.showMessageDialog(null, c.help(91));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				
			});
			
			b1 = new JButton(Integer.toString(Matriz[0][0]));
			b2 = new JButton(Integer.toString(Matriz[0][1]));
			b3 = new JButton(Integer.toString(Matriz[0][2]));
			b4 = new JButton(Integer.toString(Matriz[1][0]));
			b5 = new JButton(Integer.toString(Matriz[1][1]));
			b6 = new JButton(Integer.toString(Matriz[1][2]));
			b7 = new JButton(Integer.toString(Matriz[2][0]));
			b8 = new JButton(Integer.toString(Matriz[2][1]));
			b9 = new JButton(Integer.toString(Matriz[2][2]));
			b1.addActionListener(new Container());
			b2.addActionListener(new Container());
			b3.addActionListener(new Container());
			b4.addActionListener(new Container());
			b5.addActionListener(new Container());
			b6.addActionListener(new Container());
			b7.addActionListener(new Container());
			b8.addActionListener(new Container());
			b9.addActionListener(new Container());
			buttonPanel.add(b1);
			buttonPanel.add(b2);
			buttonPanel.add(b3);
			buttonPanel.add(b4);
			buttonPanel.add(b5);
			buttonPanel.add(b6);
			buttonPanel.add(b7);
			buttonPanel.add(b8);
			buttonPanel.add(b9);
			panel.validate();
		});

		panel.add(button);

		succes = new JLabel("BrennoPuzzle");
		succes.setBounds(10, 110, 300, 35);
		panel.add(succes);
		frame.getContentPane().add(panel);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean flag = true;
		String s = "";
		if (e.getSource() == b1) {
			s = b1.getText();
			if (b2.getText().equals("0")) {
				b2.setText(s);
				b1.setText("0");
			} else if (b4.getText().equals("0")) {
				b4.setText(s);
				b1.setText("0");
			} else {
				flag = false;
			}
		} else if(e.getSource()==b3){  
			s=b3.getText();  
			if(b2.getText().equals("0")){ 
				b2.setText(s);
				b3.setText("0");
			} else if(b6.getText().equals("0")) { 
				b6.setText(s); 
				b3.setText("0");
			} else {
				flag = false;
			} 
		} else if(e.getSource()==b2) {  
			s=b2.getText();  
			if(b1.getText().equals("0")){ 
				b1.setText(s); 
				b2.setText("0"); 
			} else if(b3.getText().equals("0")){ 
				b3.setText(s); 
				b2.setText("0");
			} else if(b5.getText().equals("0")) { 
				b5.setText(s); 
				b2.setText("0");
			}else {
				flag = false;
			}
		} else if(e.getSource()==b4){  
			s=b4.getText();  
			if(b1.getText().equals("0")){ 
				b1.setText(s);
				b4.setText("0");  
			} else if(b7.getText().equals("0")) { 
				b7.setText(s); 
				b4.setText("0");  
			} else if(b5.getText().equals("0")){ 
				b5.setText(s); 
				b4.setText("0");  
			}else {
				flag = false;
			}
		} else if(e.getSource()==b5){  
			s=b5.getText();  
			if(b2.getText().equals("0")){ 
				b2.setText(s); b5.setText("0");  
			}
			else if(b4.getText().equals("0")){ 
				b4.setText(s); 
				b5.setText("0");  
			}
			else if(b6.getText().equals("0")){ 
				b6.setText(s); 
				b5.setText("0");  
			}
			else if(b8.getText().equals("0")){ 
				b8.setText(s); 
				b5.setText("0");
			}else {
				flag = false;
			}
		} else if(e.getSource()==b6){  
	        s=b6.getText();  
	        if(b9.getText().equals("0")){  
	            b9.setText(s);  
	            b6.setText("0");  
	        } else if(b3.getText().equals("0")){  
	            b3.setText(s);  
	            b6.setText("0");  
	        }  else if(b5.getText().equals("0")){  
	            b5.setText(s);  
	            b6.setText("0");  
	        }  
	        else {
				flag = false;
	        }
	    } else if(e.getSource()==b7){  
	    	s=b7.getText();  
	    	if(b4.getText().equals("0")){ 
	    		b4.setText(s); 
	    		b7.setText("0");  
	    	} else if(b8.getText().equals("0")){ 
	    		b8.setText(s); 
	    		b7.setText("0");  
	    	}else {
				flag = false;
			}
	    } else if(e.getSource()==b8){  
	    	s=b8.getText();  
	    	if(b7.getText().equals("0")){ 
	    		b7.setText(s); 
	    		b8.setText("0");  
	    	} else if(b9.getText().equals("0")){ 
	    		b9.setText(s); 
	    		b8.setText("0");  
	    	} else if(b5.getText().equals("0")){ 
	    		b5.setText(s); 
	    		b8.setText("0");
	    	}else {
				flag = false;
			}
	    } if(e.getSource()==b9){  
	    	s=b9.getText();  
	    	if(b6.getText().equals("0")){ 
	    		b6.setText(s); 
	    		b9.setText("0");  
	    	}else if(b8.getText().equals("0")){ 
	    		b8.setText(s); 
	    		b9.setText("0");  
	    	}else {
				flag = false;
			}
	    }
		
		if (flag) {
			try {
				tabuleiro.setNumero(Integer.valueOf(s));
			} catch (NumberFormatException | NumeroException e1) {
				e1.printStackTrace();
			}
		}
		tabuleiro.getVerificarNum();
		//CHECA SE GANHOU
		if (tabuleiro.getGanhou()) {
			salvarJogador();
			JOptionPane.showMessageDialog(null, "Parabuains, você ganhou!");
		}
	}
	
	public void salvarJogador() {
		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		RepositorioJogador repoJogador = new RepositorioJogador();
		Jogador j = new Jogador(userText.getText(), tempoFinal);
		long id = repoJogador.tamanhoBanco();
		try {
			repoJogador.salvarPontuacao(id, j);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
		
		//Listar todos os jogadores
		for (int i = 0; i < repoJogador.tamanhoBanco(); i++) {
			Jogador listaJogador = null;
			try {
				listaJogador = (Jogador) repoJogador.buscarArquivoPorId(i);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			float tempo = (float) (listaJogador.getTempo()/1000);		
			listaJogadores.add(listaJogador);
		}
		List<Jogador> jogadoresMenorTempo = listaJogadores.stream()
			    .sorted(Comparator.comparing(Jogador::getTempo))
			    .collect(Collectors.toList());
		
		for (int i = 0; i < 10; i++) {
			float tempo = (float) (((Jogador) jogadoresMenorTempo.get(i)).getTempo()/1000);
			String n = (((Jogador) jogadoresMenorTempo.get(i)).getNome());
			System.out.println("------------------------------------------------------------");
			System.out.println("Tempo: " + tempo +  "s");
			System.out.println("Nome: " + n);
		}
	}
}
