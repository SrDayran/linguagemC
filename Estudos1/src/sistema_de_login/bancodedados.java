/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_de_login;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class bancodedados {
    
    ArrayList<usuario> usuarios = new ArrayList<>();
    
    public bancodedados(){
        usuarios.add(new usuario("brunosana", "br543"));
        usuarios.add(new usuario("johnyMT", "pirocao123"));
        usuarios.add(new usuario("felipe_matias", "soufoda"));
        usuarios.add(new usuario("dayran", "comedor"));
        usuarios.add(new usuario("tarsis", "gadod+"));
        usuarios.add(new usuario("euflavia", "tuflavia"));
    }
    
    public boolean autenticar(String login, String senha){
       for(usuario u: usuarios)
           if (login.equals(u.login) && senha.equals(u.senha)) return true;
    return false;
    }
    
    class usuario{
        
        public usuario(String login, String senha){
            this.login = login;
            this.senha = senha;
        }
        
        String login;
        String senha;
    }
}
