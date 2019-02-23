#include <stdio.h>
#include <locale.h>

//ALOCAÇÃO DINÂMICA DE MEMÔRIA COM CALLOC E MALLOC



main(){
setlocale(LC_ALL, "");
//Alocação Estática (Padrão)
int x, i, old; //Reserva de memória para a variável inteira X.

//Alocação Dinâmica Usando o malloc:

int *vetor;
printf("Elementos do vetor (qtd): ");
scanf("%d", &x);
//A função é void *malloc(unsigned int num) recebe a quantidade de bytes para alocação e retorna um ponteiro void para o inicio do bloco de memória
//Ou seja, retorna o ponteiro para com o tamanho alocado, e por meio do ponteiro que recebe a função é possível acessar os endereços
vetor = malloc(x*sizeof(int));

//Verificando se o ponteiro está apontando para alguma coisa, ou seja, se a memória foi alocada
if(vetor){
	printf("Memória Alocada!\n");
}else{
	printf("Memória Não Alocada!\n\n");
}

for(i=0; i<x; i++){
	vetor[i]=i;
}
for(i=0; i<x; i++){
	printf("Vetor [%d] -> %d\n", i, vetor[i]);
}
//Diferença entre malloc e calloc é que a função void *calloc(unsigned int num, unsignet int size) aloca a memória de acordo com a operação num*size
//Ou seja, é indicada para trabalhar com variáveis que se multipliquem, que possuam multidimensões ou multidados

vetor = calloc(x, sizeof(int));

//A função realloc(void *prt, unsignet int num) modifica o tamanho da memória alocada pelo ponteiro ptr
old = x;
printf("\nQuer adicionar mais quantas posições de memória no vetor? ");
scanf("%d", &x);

vetor = realloc(vetor, x*sizeof(int));

if(vetor){
	printf("Memória Realocada!");
}else{
	printf("Memória não realocada!");
}
printf("\n\nImprimindo Vetor depois da memória realocada!\n\n");
for(i=0; i<old+x; i++){
	printf("Vetor [%d] -> %d\n", i, vetor[i]);
}

free(vetor);
}
