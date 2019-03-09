/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoBanco;

/**
 *
 * @author bruno
 */
public class ContaBancaria {
    Cliente cliente = new Cliente();
    private float saldo;
    private static final float limite = 800;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }  
    
    public void depositar(float quantidade){
        if (quantidade <=0) {
            System.out.println("Ops, quantidade incorreta!");
        }else this.saldo += quantidade;
    }
    
    public void sacar(float valor){
        if (saldo+limite < valor){
            System.out.println("Ops, você não tem crédito suficiente!");
        }else {
            this.saldo -= valor;
        }
    }
 
    public void imprimir(){
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Saldo: " + this.saldo);
    }
    
}
