/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudosEmail;

import java.io.File;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author bruno
 */
public class ExecutavelCommons {
    public void sendNormalEmailTest(){
        SimpleEmail email = new SimpleEmail();  

      try {  
      email.setDebug(true);  
      email.setHostName("smtp.gmail.com");  
      email.setAuthentication("dreamersep3@gmail.com","brikiujo");  
      email.setSSL(true);  
      email.addTo("brunosana@outlook.com.br"); //pode ser qualquer email  
      email.setFrom("dreamersep3@gmail.com"); //será passado o email que você fará a autenticação
      email.setSubject("Enviando email de Teste");  
      email.setMsg("Enviando Email!");  
      email.send();  

      } catch (EmailException e) {  

      System.out.println(e.getMessage());  

      }   

  }        


    public void sendAnexoEmailTest(){
        File f = new File("C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\RelatorioFuncionario.pdf");   
                  
        EmailAttachment attachment = new EmailAttachment();  
        attachment.setPath(f.getPath()); // Obtem o caminho do arquivo  
        attachment.setDisposition(EmailAttachment.ATTACHMENT);  
        attachment.setDescription("Anexo");  
        attachment.setName(f.getName()); // Obtem o nome do arquivo  

        try {  
          // Create the email message  
            MultiPartEmail email = new MultiPartEmail();  
            email.setDebug(true);  
            email.setHostName("smtp.gmail.com");  
            email.setAuthentication("dreamersep3@gmail.com","brikiujo");  
            email.setSSL(true);  
            email.addTo("brunosana@outlook.com.br"); //pode ser qualquer email  
            email.setFrom("dreamersep3@gmail.com"); //será passado o email que você fará a autenticação
            email.setSubject("Enviando email de Teste");  
            email.setMsg("Enviando Email!");  

          // add the attachment  
          email.attach(attachment);  

          // send the email  
          email.send();  
      } catch (EmailException e) {  
          e.printStackTrace();  
      }  
  }  

}
