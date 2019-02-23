#include <stdio.h>
#include <stdlib.h>
//Enum
enum dias_semana {Segunda = 1, Terca, Quarta, Quinta, Sexta, Sabado, Domingo}dias;

main(){
	int op;
	printf("Digite o dia: ");
	scanf("%d", &op);
	switch(op){
		case Segunda: {
			printf("Digitou %d - Segunda", op);
			break;
		}
		case Terca: {
			printf("Digitou %d - Terca", op);
			break;
		}
		case Quarta: {
			printf("Digitou %d - Quarta", op);
			break;
		}
	}
}
