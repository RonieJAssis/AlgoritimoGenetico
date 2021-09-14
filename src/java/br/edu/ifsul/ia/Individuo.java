package br.edu.ifsul.ia;

public class Individuo implements Comparable<Individuo> {
	
	private Cromossomo rato;
	private int notaFit;
	private Integer geracao;
	private boolean selecionado = false;
	
	public Individuo(Cromossomo rato) {
		super();
		this.notaFit = 0;
		this.geracao = 0;
		this.rato = rato;
	}
	
	public void avaliar() {
		Integer rgbRato = (this.rato.getR() + this.rato.getG() + this.rato.getB()) / 3;
		this.notaFit = 255 / rgbRato;
	}
	
	public Individuo cruzar(Individuo outro) {
		int cruzamento = 1 + (int) (Math.random() * 6);
		Cromossomo novoRato = null;
		
		if(cruzamento == 1) {
			novoRato = new Cromossomo(this.rato.getR(), outro.rato.getG(), outro.rato.getB());
		} else if(cruzamento == 2) {
			novoRato = new Cromossomo(this.rato.getR(), this.rato.getG(), outro.rato.getB());
		} else if(cruzamento == 3) {
			novoRato = new Cromossomo(outro.rato.getR(), outro.rato.getG(), this.rato.getB());
		} else if(cruzamento == 4) {
			novoRato = new Cromossomo(outro.rato.getR(), this.rato.getG(), this.rato.getB());
		} else if(cruzamento == 5) {
			novoRato = new Cromossomo(outro.rato.getR(), this.rato.getG(), outro.rato.getB());
		} else {
			novoRato = new Cromossomo(this.rato.getR(), outro.rato.getG(), this.rato.getB());
		}
		
		Individuo i = new Individuo(novoRato);
		i.setGeracao(this.geracao+1);
		
		return i;
	}
	
	public void mutar(int taxaMutacao) {
		int mutacao = 1 + (int) (Math.random() * 3);
		
		switch(mutacao) {
			case 1:
				if(this.rato.getR() - taxaMutacao < 1) {
					this.rato.setR(1);
				} else {
					this.rato.setR(this.rato.getR() - taxaMutacao);
				}
				
				break;
			case 2:
				if(this.rato.getG() - taxaMutacao < 1) {
					this.rato.setG(1);
				} else {
					this.rato.setG(this.rato.getG() - taxaMutacao);
				}
				
				break;
			default:
				if(this.rato.getB() - taxaMutacao < 1) {
					this.rato.setB(1);
				} else {
					this.rato.setB(this.rato.getB() - taxaMutacao);
				}
				
				break;
		}
	}
	
	public int compareTo(Individuo o) {
		if (this.notaFit > o.getNotaFit()) {
			return 1;
		}
		if (this.notaFit < o.getNotaFit()) {
			return -1;
		}
		return 0;
	}

	public Cromossomo getRato() {
		return rato;
	}

	public void setRato(Cromossomo rato) {
		this.rato = rato;
	}

	public int getNotaFit() {
		return notaFit;
	}

	public void setNotaFit(int notaFit) {
		this.notaFit = notaFit;
	}

	public Integer getGeracao() {
		return geracao;
	}

	public void setGeracao(Integer geracao) {
		this.geracao = geracao;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
	
}
