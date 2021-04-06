
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloWorld {


    public static void main(String[] args) {
        System.out.println("Hello, World !!!");
        final String DEST = "D:/data/hello_world.pdf";
        //   final String DEST = "C:\\Users\\saeed\\IdeaProjects\\untitled1\\src\\main\\kotlin\\p.pdf";

        File file = new File(DEST);
        file.getParentFile().mkdirs();
        try {
            new HelloWorld().createPdf(DEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void createPdf(String dest) throws IOException, FileNotFoundException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        Document document;
        try (PdfDocument pdf = new PdfDocument(writer)) {

            // Initialize document
            document = new Document(pdf);
        }

        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));

        //Close document
        document.close();
    }
}
