/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCriptografia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bruno
 */
public class arquivo {
    int seq[] = new int[300];
    String p_url = "jdbc:mysql://localhost:3306/santoamarofit_teste",
            p_user = "root", p_pass = "admin123";
    String caminho = "C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\teste_cripto.txt";
    String caminho_seq = "C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\seq.txt";
    String key = "ZE/pMbZJON8=";
    int max_indice;
    String[] dados = new String[6];
    public arquivo() {
    }
    public arquivo(String[] dados){
        this.dados = dados;
    }
    
    public void loadSequence(){
        //Divisor |
        try {
                FileReader fr = new FileReader( caminho_seq );
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho_seq), "ISO-8859-1"));
                String total = "";
                while(br.ready()){
                    total += br.readLine();
                }
                String[] valores = total.split(" - ");
                for (int i = 0; i<300; i++){
                    seq[i] = Integer.parseInt(valores[i]);
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    
    public String ler () {
            try {
                FileReader fr = new FileReader( caminho );
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), "ISO-8859-1"));
                br.ready();
                String linha = br.readLine();
                if (linha.length() != 300) return null;
                return linha;
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        return null;
    
    }
    
    
    public void gerarArquivoCriptografado(String url, String user, String pass){
        try {
            int indice = 0;
            loadSequence();
            
            if (url.length() + user.length() + pass.length() + 16 > 299) System.out.println("Vai dar merda");
            //Abrindo arquivo e setando Buffer de Escrita
            File arquivo = new File( caminho);
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter( fw );
            
            //Gerando Chave de Criptografia
            SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
            
            //Convertendo a Key em String para salvar no arquivo:
            String key_string = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            char key_values[] = key_string.toCharArray();
            System.out.println("Key Berore: " + key_string);
            
            //Criptografando os Dados:
            Cipher cifraDES;
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.ENCRYPT_MODE, secretKey);
            
            byte[] url_decript = url.getBytes();
            byte[] url_encript = cifraDES.doFinal(url_decript);
            
            byte[] user_decript = user.getBytes();
            byte[] user_encript = cifraDES.doFinal(user_decript);
            
            byte[] pass_decript = pass.getBytes();
            byte[] pass_encript = cifraDES.doFinal(pass_decript);
            
            String s_url_encript = Base64.getEncoder().encodeToString(url_encript);
            String s_user_encript = Base64.getEncoder().encodeToString(user_encript);
            String s_pass_encript = Base64.getEncoder().encodeToString(pass_encript);
            
            
            
            System.out.println("Criptografado url (Before) : " + s_url_encript);
            System.out.println("Criptografado user (Before) : " + s_user_encript);
            System.out.println("Criptografado pass (Before) : " + s_pass_encript);
            dados[0] = s_url_encript;
            dados[1] = s_user_encript;
            dados[2] = s_pass_encript;
            
            //INSERINDO KEY
            
            char linha[] = new char[300];
            for(int i = 0; i<12; i++){
                indice = i;
                linha[seq[i]] = key_values[i];
            }
            
            linha[seq[++indice]] = '#';
            
            //INSERINDO URL CRIPTOGRAFADA
            
            char url_values[] = s_url_encript.toCharArray();
            for(int i = 0; i<s_url_encript.length(); i++) {
                indice++;
                linha[seq[indice]] = url_values[i];
            }
            
            linha[seq[++indice]] = '#';
            
            //INSERINDO USER CRIPTOGRAFADO
            
            char user_values[] = s_user_encript.toCharArray();
            max_indice = indice;
            for(int i = 0; i<s_user_encript.length(); i++){
                indice++;
                linha[seq[indice]] = user_values[i];
            }
            
            linha[seq[++indice]] = '#';
            
            //INSERINDO PASS CRIPTOGRAFADO            
            
            char pass_values[] = s_pass_encript.toCharArray();
            
            for(int i = 0; i<s_pass_encript.length(); i++){
                indice++;
                linha[seq[indice]] = pass_values[i];
            }
            
            linha[seq[++indice]] = '#';
            java.util.Random gerador = new java.util.Random();
            for(int i = ++indice; i<300;i++){
                linha[seq[i]] = (char) (gerador.nextInt(58) + 64);
            }
            //TESTE EEEEEEEEEEEEEEE
            
            
            String f = "";
            
            for(int i = 0; i<300;i++){
                f += Character.toString(linha[i]);
            }
            System.out.println("Linha - " + f);
            
            
            
            
            
            
            bw.write(linha);
            bw.close();
            fw.close();
           //bw.newLine();
           capturarDados();
            
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void capturarDados(){
        try {
            FileReader fr = new FileReader( caminho );
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), "ISO-8859-1"));
            br.ready();
            String linha = br.readLine();
            if (linha.length() != 300) System.out.println("Deu merda");
            char values[] = linha.toCharArray();
            System.out.println("Values - " + values.toString());
            int indice = 0;
            String des_key = "";
            String des_url = "", des_user = "", des_pass = "";
            for (int i = 0; i<12; i++){
                des_key += Character.toString(values[seq[i]]);
            }
            for(int i = 13; i<300; i++) {
                indice = i;
                if(values[seq[i]] == '#') break;
                des_url += Character.toString(values[seq[i]]);  
            }
            for(int i = ++indice; i<300; i++){
                indice = i;
                if(values[seq[i]] == '#') break;
                des_user += Character.toString(values[seq[i]]);
            }
            for(int i = ++indice; i<300; i++){
                indice = i;
                if(values[seq[i]] == '#') break;
                des_pass += Character.toString(values[seq[i]]);
            }

            System.out.println("KEY: " + des_key);
            System.out.println("URL: " + des_url);
            System.out.println("USER: " + des_user);
            System.out.println("PASS: " + des_pass);
            
            
            //DESCRIPTOGRAFANDO ARQUIVOS:
            
            byte[] decodedKey = Base64.getDecoder().decode(des_key);
            byte[] decode_url = Base64.getDecoder().decode(des_url);
            byte[] decode_user = Base64.getDecoder().decode(des_user);
            byte[] decode_pass= Base64.getDecoder().decode(des_pass);
            
            SecretKey decripted_key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES"); 
            Cipher cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cifraDES.init(Cipher.DECRYPT_MODE, decripted_key);
            
            byte[] dec_url = cifraDES.doFinal(decode_url);
            byte[] dec_user = cifraDES.doFinal(decode_user);
            byte[] dec_pass = cifraDES.doFinal(decode_pass);
            
            String final_url = new String(dec_url);
            String final_user = new String(dec_user);
            String final_pass = new String(dec_pass);
            
            System.out.println("URL (DESCRIPTOGRAFADA): " + final_url);
            System.out.println("USER (DESCRIPTOGRAFADA): " + final_user);
            System.out.println("PASS (DESCRIPTOGRAFADA): " + final_pass);
            
            dados[3] = final_url;
            dados[4] = final_user;
            dados[5] = final_pass;
            
            
            fr.close();
            br.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
            Logger.getLogger(arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void criptografar () throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        /*     KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
        SecretKey chaveDES = keygenerator.generateKey();
        String chaveEncoded = Base64.getEncoder().encodeToString(chaveDES.getEncoded());
        Cipher cifraDES;
        
       */
    Cipher cifraDES;
    //Construindo a Chave com base nisso!
     byte[] decodedKey = Base64.getDecoder().decode(ler());
    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES"); 
     // Cria a cifra 
     cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
     
     // Inicializa a cifra para o processo de encriptação
     cifraDES.init(Cipher.ENCRYPT_MODE, originalKey);
 
     // Texto puro
     byte[] textoPuro = "Exemplo de texto puro".getBytes();
     
     System.out.println("Texto Puro : " + new String(textoPuro));
 
     // Texto encriptado
     byte[] textoEncriptado = cifraDES.doFinal(textoPuro);
 
     System.out.println("Texto Encriptado : " + textoEncriptado);
 for (byte b: textoEncriptado) System.out.println("Byte[] " + b);
     // Inicializa a cifra também para o processo de decriptação
     cifraDES.init(Cipher.DECRYPT_MODE, originalKey);
 
     // Decriptografa o texto
     byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado);
 
     System.out.println("Texto Decriptografado : " + new String(textoDecriptografado)); 
     
    }
}
