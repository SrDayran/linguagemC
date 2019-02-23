#include <stdio.h>
#include <locale.h>

//STRUCTS

struct loja{
	char *nome;
	int numero;
};

//Structs em Funções
void mostrar(struct loja l){
	printf("\n\n--------------------\n");
	printf("Nome: %s\nNumero: %d\n", l.nome, l.numero);
	printf("--------------------");
}

main(){
	setlocale(LC_ALL, "");
	//Matrizes com Structs (Tratadas Normalmente)
	struct loja lojas[2][3];
	int i, j;
	lojas[0][0].nome = "Americanas LTDA";
	lojas[0][0].numero = 550;
	
	lojas[0][1].nome = "Esplanada LTDA";
	lojas[0][1].numero = 553;
	
	lojas[0][2].nome = "Casa Mais Moveis LTDA";
	lojas[0][2].numero = 556;
	
	lojas[1][0].nome = "Pastelaria do Chines";
	lojas[1][0].numero = 650;

	lojas[1][1].nome = "RR Bicicletas";
	lojas[1][1].numero = 653;
	
	lojas[1][2].nome = "Riachuelo LTDA";
	lojas[1][2].numero = 656;
	printf("Imprimindo Matriz de Struct...\n\n");
	for(i=0;i<2;i++){
		for(j=0;j<3;j++){
			printf("Nome: %s\nNumero: %d\n\n", lojas[i][j].nome, lojas[i][j].numero);
		}
	}
	
	//Structs em Funções:
	printf("\n\n\nStructs em Funções...");
	mostrar(lojas[0][0]);
	mostrar(lojas[0][2]);
}
