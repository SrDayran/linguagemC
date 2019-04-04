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
//PARA CRIAR HERANÇA DE CLASSE USA-SE A PALAVRA CHAVE extends
public class funcionario extends pessoa{
    private String email;
    private float salario;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    
    /*Quando estamos reescrevendo uma função QUE JÁ EXISTE EM SUA CLASSE PAI, é necessário adicionar uma anotação acima da função
    chamara @Override*/
    
    @Override
    public void imprimirDados(){
        System.out.println("Objeto Funcionário");
        System.out.println(getNome());
        System.out.println(getIdade());
        System.out.println(getCPF());
        System.out.println(getSexo());
        System.out.println(email);
        System.out.println(salario);
        System.out.println("----------");
    }
    
    
    
}
