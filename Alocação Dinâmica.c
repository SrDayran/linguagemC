#include <stdio.h>
#include <locale.h>

//ALOCA��O DIN�MICA DE MEM�RIA COM CALLOC E MALLOC



main(){
setlocale(LC_ALL, "");
//Aloca��o Est�tica (Padr�o)
int x, i, old; //Reserva de mem�ria para a vari�vel inteira X.

//Aloca��o Din�mica Usando o malloc:

int *vetor;
printf("Elementos do vetor (qtd): ");
scanf("%d", &x);
//A fun��o � void *malloc(unsigned int num) recebe a quantidade de bytes para aloca��o e retorna um ponteiro void para o inicio do bloco de mem�ria
//Ou seja, retorna o ponteiro para com o tamanho alocado, e por meio do ponteiro que recebe a fun��o � poss�vel acessar os endere�os
vetor = malloc(x*sizeof(int));

//Verificando se o ponteiro est� apontando para alguma coisa, ou seja, se a mem�ria foi alocada
if(vetor){
	printf("Mem�ria Alocada!\n");
}else{
	printf("Mem�ria N�o Alocada!\n\n");
}

for(i=0; i<x; i++){
	vetor[i]=i;
}
for(i=0; i<x; i++){
	printf("Vetor [%d] -> %d\n", i, vetor[i]);
}
//Diferen�a entre malloc e calloc � que a fun��o void *calloc(unsigned int num, unsignet int size) aloca a mem�ria de acordo com a opera��o num*size
//Ou seja, � indicada para trabalhar com vari�veis que se multipliquem, que possuam multidimens�es ou multidados

vetor = calloc(x, sizeof(int));

//A fun��o realloc(void *prt, unsignet int num) modifica o tamanho da mem�ria alocada pelo ponteiro ptr
old = x;
printf("\nQuer adicionar mais quantas posi��es de mem�ria no vetor? ");
scanf("%d", &x);

vetor = realloc(vetor, x*sizeof(int));

if(vetor){
	printf("Mem�ria Realocada!");
}else{
	printf("Mem�ria n�o realocada!");
}
printf("\n\nImprimindo Vetor depois da mem�ria realocada!\n\n");
for(i=0; i<old+x; i++){
	printf("Vetor [%d] -> %d\n", i, vetor[i]);
}

free(vetor);
}
