package com.pattern.factory;

/**
 * Test class to demonstrate the Factory Method Design Pattern.
 */
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Pattern ===");

        // Create a Word Document Factory and process a Word Document
        System.out.println("\n--- Word Document Factory ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        // Create a PDF Document Factory and process a PDF Document
        System.out.println("\n--- PDF Document Factory ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        // Create an Excel Document Factory and process an Excel Document
        System.out.println("\n--- Excel Document Factory ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();

        // Demonstrate template-method style processing via DocumentFactory base class
        System.out.println("\n--- Demonstration of base class processing method ---");
        System.out.println("Processing Word document via wordFactory.processDocument():");
        wordFactory.processDocument();
    }
}
