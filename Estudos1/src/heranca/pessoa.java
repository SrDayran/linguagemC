package heranca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class pessoa {
    /*Uma pessoa tem um NOME, IDADE, SEXO, CPF*/
    
    //SÓ O OBJETO PODE MANIPULAR OS SEUS ATRIBUTOS POR MEIO DOS MÉTODOS
    
    /*COM OS MODIFICADORES DE ACESSO, A SINTAXE DE DECLARAÇÃO DE VARIÁVIES FICA:
    <MODIFICADOR> <TIPO> <NOME>*/
    
    private String nome;
    private int idade;
    private char sexo;
    private String CPF;
    
    //EXPLICITAR VARIÁVEIS
    /*Quando um método da classe possui como parâmetro o mesmo nome de uma variável da classe, para dizer de onde é a variável
    nós usamos a palavra chave THIS
    A palavra chave THIS mostra que a variável é da CLASSE*/
    
    /*Para criar um objeto, precisamos do construtor dele, então, uma forma PADRÃO de criar objetos, é usar o construtor
    IMPLÍCITO sem argumentos*/
    
    
    public void setNome(String nome){
        //O NOME DA CLASSE RECEBE O NOME PASSADO COMO PARÂMETRO
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
    
    public void imprimirDados(){
        System.out.println("Objeto Pessoa");
        System.out.println(nome);
        System.out.println(idade);
        System.out.println(CPF);
        System.out.println(sexo);
        System.out.println("----------");
    }
    
    /*DESIGN PATTERN -
    TODA VEZ QUE O MÉTODO FOR PRA CAPTURAR UM VALOR, USA-SE O PREFIXO GET E O NOME DA VARIÁVEL LOGO EM SEGUIDA
    TODA VEZ QUE O MÉTODO FOR PARA ATRIBUIR UM VALOR, USA-SE O PREFIXO SET E O NOME DA VARIÁVEL LOGO EM SEGUIDA*/
    
    

}
