package lista8;

public class JogoDaForca {
	private Palavra[] dicionario;
	private int posSorteada;
	private String gabarito;
	
	public int getPosSorteada() {
		return posSorteada;
	}
	public String getGabarito() {
		return gabarito;
	}
	public void setDicionario(Palavra[] dicionario) {
		this.dicionario = dicionario;
	}
	public Palavra[] getDicionario() {
		return dicionario;
	}
	
	public String dica() {
		String dica = dicionario[posSorteada].getDica();
		return dica;
	}
	public void sortear() {
		posSorteada = (int)(Math.random()*(dicionario.length));
		while(dicionario[posSorteada] == null) {
			posSorteada = (int)(Math.random()*(dicionario.length));
		}
		String recebeNome = dicionario[posSorteada].getPalavra();
		String modificador = "";
		for(int c = 0;c < recebeNome.length();c++) {
				modificador += "?"; 
			}
			gabarito = modificador;
		}
	
	
	
	public boolean testarLetra(char teste) {
		String palavra = dicionario[posSorteada].getPalavra();
		String[] p = palavra.split("");
		String[] p2 = gabarito.split("");
		String conversao = teste+"";
		String gabaritoAtualizado = "" ;
		boolean flag = false;
		for(int c = 0; c< palavra.length();c++) {
			if(conversao.equals(p[c])) {
				flag = true;
				p2[c] = conversao;
				
			}
		}
		for(String concatenar: p2) {
			gabaritoAtualizado += concatenar;
		}
		gabarito = gabaritoAtualizado;
		return flag;
	}
	
	public boolean testaSeAcabou() {
		if (gabarito.contains("?")) {
			return false;
		}
		else {
			dicionario[posSorteada] = null;
			posSorteada = -1;
		}
		return true;
	}
}
