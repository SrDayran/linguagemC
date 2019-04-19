/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudosGraficos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author bruno
 */
public class graficos {
    public void comFreeChart(){
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(40.5, "maximo", "dia 1");
        ds.addValue(38.2, "maximo", "dia 2");
        ds.addValue(37.3, "maximo", "dia 3");
        ds.addValue(31.5, "maximo", "dia 4");
        ds.addValue(35.7, "maximo", "dia 5");
        ds.addValue(42.5, "maximo", "dia 6");
        JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia", 
    "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
        OutputStream arquivo;
        Document document = new Document(PageSize.A4, 25, 25, 40, 40);        
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\Teste.pdf"));
            document.open();
            arquivo = new FileOutputStream("grafico.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
            document.add((Element) grafico);
            //fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(graficos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(graficos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(graficos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getTotalizadorGrafico() {
            PdfContentByte content;
            PdfTemplate template;
            JFreeChart chart;
            DefaultCategoryDataset dataSet;
            Graphics2D graphics;
            Rectangle2D rectangle;

    try {
    	int x1 = 0,y1 = 0;
        int x2 = 400,y2 = 400;
        Document document = new Document(PageSize.A4, 25, 25, 40, 40); 
        PdfWriter writer = null;
        writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\bruno\\Documents\\Bruno Sana\\Dreamers\\Teste.pdf"));
        document.open();
        content = writer.getDirectContent();
        template = content.createTemplate(x2, y2);
        graphics = template.createGraphics(x2, y2);

        rectangle = new Rectangle2D.Double(x1, y1, x2, y2);

        dataSet = new DefaultCategoryDataset();
        dataSet.setValue(325, "Status", "Aberto");
        dataSet.setValue(100, "Status", "Cancelado");
        dataSet.setValue(659, "Status", "Fechada");
		
        chart = ChartFactory.createBarChart("Totalizador por Estado", null , null , dataSet, PlotOrientation.VERTICAL, true, true, true);

        chart.draw(graphics, rectangle);

        graphics.dispose();
        content.addTemplate(template, 0, 0);
        document.close();
         
    } catch (Exception e) {
        e.printStackTrace();
    }
  
}
    
}
