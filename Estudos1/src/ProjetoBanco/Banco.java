/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoBanco;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Banco {
    //ArrayList - Vetor de Tipos
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    public static void main(String[] args) {
        for(int i = 0; i<10; i++){
            Cliente c1 = new Cliente();
            c1.setNome("Bruno " + i);
            c1.setCpf("123.456" + i);
            c1.setIdade(i+18);
            c1.setEmail("opa");
            c1.setRG("OK");
            c1.setTelefone("123456789");
            clientes.add(c1);
            
            ContaBancaria co1 = new ContaBancaria();
            co1.setCliente(c1);
            co1.setSaldo(150 + (i*5));
            contas.add(co1);
            
            co1.imprimir();
        }
    }
}
