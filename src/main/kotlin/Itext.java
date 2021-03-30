import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import kotlin.jvm.JvmStatic;

import java.io.File;
import java.io.FileNotFoundException;

public class Itext {
    final String DEST = "C:\\Users\\saeed\\IdeaProjects\\untitled1\\src\\main\\kotlin\\p.pdf";



    public static void main(String args[]) throws IOException, FileNotFoundException {
          final String DEST = "D:/data/hello_world.pdf";
     //   final String DEST = "C:\\Users\\saeed\\IdeaProjects\\untitled1\\src\\main\\kotlin\\p.pdf";

        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Itext().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, FileNotFoundException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));

        //Close document
        document.close();
    }


}