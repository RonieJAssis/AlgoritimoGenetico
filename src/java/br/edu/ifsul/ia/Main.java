package br.edu.ifsul.ia;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Individuo> ratos = new ArrayList<Individuo>();
		
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 1
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 2
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 3
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 4
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 5
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 6
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 7 
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 8
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 9
		ratos.add(new Individuo(new Cromossomo(geraCor(), geraCor(), geraCor()))); // 10
		
		int taxaMutacao = 1;
		int taxaFitAceita = 5; // fator desejado		
		
		AlgoritmoGenetico a = new AlgoritmoGenetico(ratos, taxaMutacao);
		
		while(a.getPopulacao().get(0).getNotaFit() < taxaFitAceita) {
			a.resolver();
			System.out.println("MinGen: " + (a.getMenorGeracao()+1) +
							   " MaxGen: " + (a.getMaiorGeracao()+1) +
							   " +claro: (" + a.getPopulacao().get(0).getRato().getR() + "," +
							   a.getPopulacao().get(0).getRato().getG() + "," +
							   a.getPopulacao().get(0).getRato().getB() + ") [" +
							   a.getPopulacao().get(0).getNotaFit() + "] " +
							   " +escuro: (" + a.getPopulacao().get(a.getPopulacao().size()-1).getRato().getR() + "," +
							   a.getPopulacao().get(a.getPopulacao().size()-1).getRato().getG() + "," +
							   a.getPopulacao().get(a.getPopulacao().size()-1).getRato().getB() + ") [" +
							   a.getPopulacao().get(a.getPopulacao().size()-1).getNotaFit() + "] ");
		}
		
		System.out.println("Alo galera de caubói");
		
	}
	
	static int geraCor() {
		int cor = 1 + (int) (Math.random() * 255);
		return cor;
	}

}
