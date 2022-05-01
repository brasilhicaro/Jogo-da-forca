package lista8;

import java.util.Scanner;

public class Front {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		JogoDaForca jdf = new JogoDaForca();
		Palavra[] palavras = new Palavra[10];
		for(int c = 0; c < palavras.length ;c++) {
			Palavra p = new Palavra();
			System.out.printf("Insira a sua %dª dica: \n", c+1);
			p.setDica(input.nextLine());
			System.out.printf("Insira a sua %dª palavra: \n", c+1);		
			p.setPalavra(input.nextLine());
			palavras[c] = p;
		}
		jdf.setDicionario(palavras);
		jdf.sortear();
		int cErro = 0;
		int pontFinal = 0;
		int pontuacao= 0;
		int newGame = 1;
		int contador = 1;
		do{
			if(contador> palavras.length) {
				break;
			}
			jdf.sortear();	
			while(jdf.testaSeAcabou() == false) {
					System.out.println(jdf.dica());
					System.out.println(jdf.getGabarito());
					char verificador = input.next().charAt(0);
					if(jdf.testarLetra(verificador)) {
						System.out.println("Tem essa letra na palavra.");
					}
					else {
						cErro++;
					}
					pontuacao = 2* jdf.getGabarito().length() - cErro;
					System.out.println(jdf.getGabarito());
					}
			System.out.printf("Sua pontuação da rodada é de: %d\n", pontuacao);
			pontFinal += pontuacao;
			System.out.println("Deseja continuar no jogo? !nsira '1' para continuar jogando.");
			newGame = input.nextInt();
			
				
			++contador;
		}while(newGame == 1);
		System.out.println("Não há mais palavras, fim de jogo");
		System.out.printf("Sua pontuação final é de %d", pontFinal);
		input.close();
	}
}
