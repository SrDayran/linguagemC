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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
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
    
    public void criptografar () throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
     KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
     SecretKey chaveDES = keygenerator.generateKey();
 
     Cipher cifraDES;
 
     // Cria a cifra 
     cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
 
     // Inicializa a cifra para o processo de encriptação
     cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
 
     // Texto puro
     byte[] textoPuro = "Exemplo de texto puro".getBytes();
 
     System.out.println("Texto [Formato de Byte] : " + textoPuro);
     System.out.println("Texto Puro : " + new String(textoPuro));
 
     // Texto encriptado
     byte[] textoEncriptado = cifraDES.doFinal(textoPuro);
 
     System.out.println("Texto Encriptado : " + textoEncriptado);
 
     // Inicializa a cifra também para o processo de decriptação
     cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
 
     // Decriptografa o texto
     byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado);
 
     System.out.println("Texto Decriptografado : " + new String(textoDecriptografado)); 
    }
}
