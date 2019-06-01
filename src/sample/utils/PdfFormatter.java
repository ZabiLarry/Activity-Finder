package sample.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfFormatter {

    private static void createPDF(String path, String content) throws DocumentException, IOException {
        Document document= new Document();
        PdfWriter.getInstance(document,new FileOutputStream(path));
        document.open();
        Paragraph paragraph = new Paragraph();
        paragraph.add(content);
        document.add(paragraph);
        document.close();
    }

    public static void openPDFRecipeSaver(ActionEvent event, String contnt) {
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        fileChooser.setTitle("Save recipe");
        File file = fileChooser.showSaveDialog(theStage);

        if (file != null) {
            try {
                createPDF(file.getAbsolutePath(), contnt);
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
