#include <stdio.h>

//UNION
//Forma de declaração:
union key{
	short int value1;
	char value2;
};

union Uniao{
	int Codigo;
};

//Função Main
main(){
	union key valor;
	valor.value1 = 50;
	valor.value2 = 'T';
	
	printf("Valor:\nInt -> %d\nChar -> %c", valor.value1, valor.value2);
	
	
}
