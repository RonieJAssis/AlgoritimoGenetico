

!start.

+!start : true <- .print("Ol� m�e natureza...").
   
+simulacaoRatos(R, T, F): true <-
	.print("Okay... Vamos � sele��o natural!");
	br.edu.ifsul.ia.organizaAcao(R, T, F, G);
	.print("Esta � a gera��o que consegue se esconder dos predadores: \n", G);
	.send(natureza, tell, geracaoAntiPredador(G)).
