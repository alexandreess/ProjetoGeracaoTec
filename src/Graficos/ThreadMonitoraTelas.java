package Graficos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Jogo.Jogador;

/**
 * Batalha Naval (Ultimate Battle) - Versao 2.0 de Interface Grafica (TelaChat) 
 * Thread (Processo Filho) que monitora o obejto Jogador, principalmente o numero de
 * rodadas para alterar a telaMenusImagens, trocando as imagens (Label`s) quando receber
 * um "click" na telaTabuleiro (troca imagem com  Peca/Navio por imagem com Mensagem OK).
 * Assim as Telas (JPanel) podem se relacionar...
 */

public class ThreadMonitoraTelas extends Thread {
	

	private TelaConexao telaConexao;
	private TelaTabuleiro telaTabuleiro;
	private TelaImagens telaImagens;
	
	private TelaChat telaChat;

	public ThreadMonitoraTelas(TelaConexao telaConexao, TelaTabuleiro telaTabuleiro, 
			TelaImagens telaImagens, TelaChat telaChat) {
		
		this.telaTabuleiro = telaTabuleiro;
		this.telaImagens = telaImagens;
		this.telaConexao = telaConexao;
		this.telaChat = telaChat;
	}
	// Metodo que executa start() a Thread (Processo Filho)
	public void run() {
		// Enquanto Numero de Jogadas for menor que 100 (Numero de posicao de um tabuleiro)
		while (telaImagens.getJogador().getNumRodadas() < 100) {
					// Comente a parte de baixo para nao ver o numero de Rodadas 
					//System.out.println("ThreadMonitoraRodadas - " + telaMenuImagens.getJogador().getNumRodadas());
					int numRodadas = telaImagens.getJogador().getNumRodadas();
					// Troca Imagem (JLabel) mostrando que Peca/Navio foi escolhido
					if (telaImagens.getJogador().getNumRodadas() == 1) {
						telaImagens.getLabel()[0]
										.setIcon(telaImagens.getIcons()[5]);
					}
					if (telaImagens.getJogador().getNumRodadas() == 2) {
						telaImagens.getLabel()[1]
										.setIcon(telaImagens.getIcons()[5]);
					}
					if (telaImagens.getJogador().getNumRodadas() == 3) {
						telaImagens.getLabel()[2]
									.setIcon(telaImagens.getIcons()[5]);
					}
					if (telaImagens.getJogador().getNumRodadas() == 4) {
						telaImagens.getLabel()[3]
									.setIcon(telaImagens.getIcons()[5]);
					}
					if 	(telaImagens.getJogador().getNumRodadas() == 5){
						for (int contLabel = 0; contLabel < 5; contLabel++) {
							telaImagens.getLabel()[contLabel].setVisible(false);
						}
						// Desabilita TelaMenuImagens ao final das 5 rodadas
						telaImagens.getPanelImagens().setEnabled(false);
				}				
					telaChat.getButtonChat().setActionCommand("atualiza");
					//
		}
	}
}
	
	
	