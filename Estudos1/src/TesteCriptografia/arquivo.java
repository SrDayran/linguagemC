/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCriptografia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bruno
 */
public class arquivo {
    public void ler () {
            try {
                String caminho = "C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\teste_cripto.txt";
                FileReader fr = new FileReader( caminho );
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), "ISO-8859-1"));
                while(br.ready()){
                    System.out.println(br.readLine());
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    
}
}
