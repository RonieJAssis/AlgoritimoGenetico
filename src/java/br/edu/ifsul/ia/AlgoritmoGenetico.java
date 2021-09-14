package br.edu.ifsul.ia;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritmoGenetico {

	private int tamanhoPopulacao;
	private List<Individuo> populacao = new ArrayList<Individuo>();
	private int mortalidade;
	private int taxaMutacao;
	
	public AlgoritmoGenetico(List<Individuo> populacaoInicial, int taxaMutacao) {
		this.mortalidade = (int) (populacaoInicial.size() * 0.2); // 20% da populacao inicial
		this.taxaMutacao = taxaMutacao; 
		this.inicializaPopulacao(populacaoInicial);
	}
	
	public int getMenorGeracao() {
		int menor = populacao.get(0).getGeracao();
		
		for(Individuo i : populacao) {
			if(i.getGeracao() < menor) {
				menor = i.getGeracao();
			}
		}
		
		return menor;
	}
	
	public int getMaiorGeracao() {
		int maior = populacao.get(0).getGeracao();
		
		for(Individuo i : populacao) {
			if(i.getGeracao() > maior) {
				maior = i.getGeracao();
			}
		}
		
		return maior;
	}
	
	public void inicializaPopulacao(List<Individuo> ratos) {
		for(Individuo rato : ratos) {
			this.populacao.add(rato);
		}
		
		this.tamanhoPopulacao = populacao.size();
		this.avaliarOrdenarPopulacao();
	}
	
	public void ordenarPopulacao() {
		Collections.sort(this.populacao);
	}
	
	public int somaAvaliacao() {
		int soma = 0;
		for (Individuo individuo : populacao) {
			soma += individuo.getNotaFit();
		}
		return soma;
	}
	
	public Individuo roleta() {
		int total = this.somaAvaliacao();
		int selecionado = 0 + (int) (Math.random() * total);
		int soma = 0;
		Individuo i = null;
		
		for(Individuo ind : populacao) {
			if(!ind.isSelecionado()) {
				if(selecionado >= soma && selecionado <= (ind.getNotaFit() + soma)) { // i 
					i = ind;
					ind.setSelecionado(true);
					return i;
				} else {
					soma += ind.getNotaFit();
				}
			}
		}
		
		return i;
	}
	
	public void fazALimpa() {
		List<Individuo> novaPopulacao = new ArrayList<Individuo>();
		
		int cont = 0;
		while(cont < (tamanhoPopulacao-mortalidade)) {
			Individuo i = roleta();
			
			if(i != null) {
				novaPopulacao.add(i);
				cont++;
			}
		}
		
		this.populacao = novaPopulacao;
		this.desselecionar();
	}
	
	public void desselecionar() {
		for(Individuo i : populacao) {
			i.setSelecionado(false);
		}
	}
	
	public void resolver() {
		this.fazALimpa();
		
		// cruzamento
		for(int i=0; i<mortalidade; i++) {
			Individuo pai = null;
			while(pai == null) {
				pai = this.roleta();
			}
			
			Individuo mae = null;
			while(mae == null) {
				mae = this.roleta();
			}
			
			this.desselecionar();
			
			Individuo filhote = pai.cruzar(mae); // explicit :O

			// mutacao
			if (java.lang.Math.random() < 0.5) {
				filhote.mutar(taxaMutacao);
			}
			
			populacao.add(filhote);
		}
		
		this.avaliarOrdenarPopulacao();
	}
	
	private void avaliarOrdenarPopulacao() {
		
		for (Individuo individuo : populacao) {
			individuo.avaliar();
		}
		
		this.ordenarPopulacao();
	}

	public int getTamanhoPopulacao() {
		return tamanhoPopulacao;
	}

	public void setTamanhoPopulacao(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public List<Individuo> getPopulacao() {
		return populacao;
	}

	public void setPopulacao(List<Individuo> populacao) {
		this.populacao = populacao;
	}

	public int getMortalidade() {
		return mortalidade;
	}

	public void setMortalidade(int mortalidade) {
		this.mortalidade = mortalidade;
	}

	public int getTaxaMutacao() {
		return taxaMutacao;
	}

	public void setTaxaMutacao(int taxaMutacao) {
		this.taxaMutacao = taxaMutacao;
	}
	
}
