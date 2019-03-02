/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heranca;

/**
 *
 * @author bruno
 */
public class main {
    
    public static void main(String[] args) {
        //CRIAÇÃO DE OBJETOS CRIADOS
        //Declaração de Variável: pessoa <NOME>
        
        /*Na linguagem Java quando você escreve uma linha de comando de criação de variável, o Java NÃO ARMAZENA NADA NA MEMÓRIA,
        ele só declara*/
        pessoa p = new pessoa();
        p.setNome("José Araújo Penedo Costa da Silva Fernandes de Lima Peixoto Azevedo");
        p.setCPF("123.456.789-10");
        p.setIdade(21);
        p.setSexo('M');
        p.imprimirDados();
        
        funcionario f = new funcionario();
        f.setNome("Augusto Pereira Agular Santos Silva Amoedo Bolsonaro 13 Lula dos Santos");
        f.setCPF("987.654.321-99");
        f.setIdade(40);
        f.setSexo('M');
        f.setEmail("augustopereiraagu@gmail.com");
        f.setSalario(998.57f);
        
        f.imprimirDados();
        
    }
    
}
