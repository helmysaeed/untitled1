import com.itextpdf.io.IOException
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import java.io.File
import java.io.FileNotFoundException

class Itx {



    fun main(args: Array<String>){

        val DEST = "D:/data2/hello_world.pdf"
        //   final String DEST = "C:\\Users\\saeed\\IdeaProjects\\untitled1\\src\\main\\kotlin\\p.pdf";
    //    val DEST = "C:\\Users\\saeed\\IdeaProjects\\untitled1\\src\\main\\kotlin\\p.pdf";
        val file = File(DEST)
        file.parentFile.mkdirs()
       // Itx().createPdf(DEST)

      }

    @Throws(IOException::class, FileNotFoundException::class)
    fun createPdf(dest: String?) {
        //Initialize PDF writer
        val writer = PdfWriter(dest)

        //Initialize PDF document
        val pdf = PdfDocument(writer)

        // Initialize document
        val document = Document(pdf)

        //Add paragraph to the document
        document.add(Paragraph("Hello World!"))

        //Close document
        document.close()
    }
}


