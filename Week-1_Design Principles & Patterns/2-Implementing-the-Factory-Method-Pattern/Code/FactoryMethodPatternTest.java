// Interface representing document operations
interface Document {
    void open();
    void close();
}

// Abstract factory for creating documents
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Concrete Word document class
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document.");
    }
    @Override
    public void close() {
        System.out.println("Closing Word document.");
    }
}

// Concrete PDF document class
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document.");
    }
    @Override
    public void close() {
        System.out.println("Closing PDF document.");
    }
}

// Concrete Excel document class
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document.");
    }
    @Override
    public void close() {
        System.out.println("Closing Excel document.");
    }
}

// Factory for creating WordDocument
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// Factory for creating PdfDocument
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// Factory for creating ExcelDocument
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Testing class for Factory Method Pattern
public class FactoryMethodPatternTest {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}
