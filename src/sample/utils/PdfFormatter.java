package sample.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfFormatter {

    public static void createPDF(String path, String content) throws DocumentException, IOException {
        Document document= new Document();
            PdfWriter.getInstance(document,new FileOutputStream(path));
            document.open();
            Paragraph paragraph = new Paragraph();
            paragraph.add(content);
            document.add(paragraph);
            document.close();
    }
}
