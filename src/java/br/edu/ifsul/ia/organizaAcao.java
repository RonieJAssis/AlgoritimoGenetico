package br.edu.ifsul.ia;

import java.util.ArrayList;
import java.util.List;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.ListTerm;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.StringTerm;
import jason.asSyntax.StringTermImpl;
import jason.asSyntax.Term;

public class organizaAcao extends DefaultInternalAction {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
		
		ListTerm listaDeTermos = (ListTerm) args[0];
		int taxaMutacao = (int) ((NumberTerm) args[1]).solve();
		int taxaFitAceita = (int) ((NumberTerm) args[2]).solve(); // fator desejado	
		
		List<Individuo> ratos = new ArrayList<Individuo>();
		
		for (Term term : listaDeTermos) {
			ListTerm subList = (ListTerm) term;
		
			int r = (int) ((NumberTerm) subList.get(0)).solve();
			int g = (int) ((NumberTerm) subList.get(1)).solve();
			int b = (int) ((NumberTerm) subList.get(2)).solve();
			
			ratos.add(new Individuo(new Cromossomo(r, g, b)));
		}
		
		AlgoritmoGenetico a = new AlgoritmoGenetico(ratos, taxaMutacao);
		while(a.getPopulacao().get(0).getNotaFit() < taxaFitAceita) {
			a.resolver();
		}
		
		String s = "";
		for(Individuo i : a.getPopulacao()) {
			s += "[" + i.getRato().getR() + ", " + i.getRato().getG() + ", " + i.getRato().getB() + "]" +
				" Gen: " + i.getGeracao() + " Fit: " + i.getNotaFit() + "\n";
		}
		
		s += "Maior geração: " + a.getMaiorGeracao() + "\nMenor geração: " + a.getMenorGeracao();
		
		StringTerm result =  new StringTermImpl(s);
		return un.unifies(result, args[3]);
		
	}

}