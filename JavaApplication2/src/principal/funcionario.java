/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author bruno
 */
public class funcionario extends pessoa {    
    private String emprego;
    private float salario;
    private int ferias;
    private float horaextra;    
    
    public funcionario(){super();}
    
    public funcionario(String nome, int idade, String cpf, String email, String emprego, float salario, int ferias, float horaextra){
        super(nome, idade, cpf, email);
        this.emprego = emprego;
        this.salario = salario;
        this.ferias = ferias;
        this.horaextra = horaextra;
    }
    /*CLASSE FUNCIONÁRIO É CHAMADA DE CLASSE FIHLA | PESSOA É A CLASSE MÃE*/
    
    /*PARA ACESSAR OS ATRIBUTOS E MÉTODOS DA CLASSE MÃE, USAMOS A PALAVRA CHAVE SUPER*/

    public String getEmprego() {
        return emprego;
    }

    public void setEmprego(String emprego) {
        this.emprego = emprego;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getFerias() {
        return ferias;
    }

    public void setFerias(int ferias) {
        this.ferias = ferias;
    }

    public float getHoraextra() {
        return horaextra;
    }

    public void setHoraextra(float horaextra) {
        this.horaextra = horaextra;
    }
    
}
