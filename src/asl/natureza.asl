
ratinhos(
	[
		[110, 55, 35],
		[244, 190, 206],
		[190, 210, 230],
		[215, 245, 232],
		[255, 255, 255],
		[230, 210, 188],
		[210, 255, 235],
		[240, 232, 243],
		[212, 231, 222],
		[89, 87, 89]
	]
).

taxaMutacao(1).
taxaFitAceita(5).

!start.

+!start : true <- 
   ?ratinhos(R);
   ?taxaMutacao(T);
   ?taxaFitAceita(F);
   .print("Ol� evolu��o, precisamos selecionar os ratos mais escuros para diminuir sua morte para os predadores.")
   .print("A popula��o de ratos iniciais que tenho comigo � essa: ")
   .print(R)
   .send(evolucao, tell, simulacaoRatos(R, T, F)).

+geracaoAntiPredador(G): true <- .print("Perfeito!\n").