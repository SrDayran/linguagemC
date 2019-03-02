/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class Relatorio {
    public void criar(){
        
        //Criando Document
       Document document = new Document(PageSize.A4, 25, 25, 40, 40);
       
       //FONTES
       Font title = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
       Font data = new Font(Font.FontFamily.COURIER, 12);
       Font rodape = new Font(Font.FontFamily.COURIER, 8);
       
       
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\PDF_DevMedia.pdf"));
            document.open();
            Paragraph head = new Paragraph("Comprovante de Troca", title);
            head.setAlignment(Paragraph.ALIGN_CENTER);
            head.setSpacingBefore(-20);
            head.setSpacingAfter(40);
            //Image img = Image.getInstance("C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\logo.png");
            
            //document.add(img);
            document.add(head);
            document.add(new Paragraph("Eu, BRUNO SANTANA ANDRADE, confirmo receber os itens abaixo descritos para uso pesosal"
                    + " e intransferível segundo as normas da Iury Transportes LTDA."));
            
            
            
            PdfPTable tabela = new PdfPTable(4);
            
            
            PdfPCell c11 = new PdfPCell(new Paragraph("Item"));
            PdfPCell c12 = new PdfPCell(new Paragraph("Tamanho"));
            PdfPCell c13 = new PdfPCell(new Paragraph("Quantidade"));
            PdfPCell c14 = new PdfPCell(new Paragraph("Série"));
            

            c11.setBorder(Rectangle.BOTTOM);
            c12.setBorder(Rectangle.BOTTOM);
            c13.setBorder(Rectangle.BOTTOM);
            c14.setBorder(Rectangle.BOTTOM);
            
            
            tabela.addCell(c11);
            tabela.addCell(c12);
            tabela.addCell(c13);
            tabela.addCell(c14);
            
                        
            for (int i =0; i<5; i++){
                PdfPCell c15 = new PdfPCell(new Paragraph("Item " + i, data));
                PdfPCell c16 = new PdfPCell(new Paragraph("Tamanho " + i));
                PdfPCell c17 = new PdfPCell(new Paragraph("Quantidade " + i));
                PdfPCell c18 = new PdfPCell(new Paragraph("Série " + i));
                c15.setBorder(Rectangle.NO_BORDER);
                c16.setBorder(Rectangle.NO_BORDER);
                c17.setBorder(Rectangle.NO_BORDER);
                c18.setBorder(Rectangle.NO_BORDER);
                tabela.addCell(c15);
                tabela.addCell(c16);
                tabela.addCell(c17);
                tabela.addCell(c18);
            }
            
            tabela.setSpacingBefore(50);
            document.add(tabela);
            
            Paragraph ass = new Paragraph("______________________________________________");
            ass.setSpacingBefore(50);
            ass.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph name = new Paragraph("BRUNO SANTANA ANDRADE");
            name.setSpacingAfter(8);
            name.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph dados = new Paragraph("Gerado em 26/02/2019 - 10:02 - Operador: Mirian", rodape);
            dados.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(ass);
            document.add(name);
            document.add(dados);
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            document.close();
        }
        
    }
}
