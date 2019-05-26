/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class implementando {
    public static void main(String[] args) {
     ArrayList<objeto> lista = new ArrayList<>();
     for(int i = 0; i <100; i++) lista.add(new objeto(i+1, i*2, "Nome " + i));
     for(objeto o: lista) {
         System.out.println("Objeto:");
         System.out.println("Nome: " + o.getNome() + " Idade: " + o.getIdade() + " Id: " + o.getId());
     }
     lista.remove(1);
    }
}
