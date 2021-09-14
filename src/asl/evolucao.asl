

!start.

+!start : true <- .print("Olá mãe natureza...").
   
+simulacaoRatos(R, T, F): true <-
	.print("Okay... Vamos à seleção natural!");
	br.edu.ifsul.ia.organizaAcao(R, T, F, G);
	.print("Esta é a geração que consegue se esconder dos predadores: \n", G);
	.send(natureza, tell, geracaoAntiPredador(G)).
