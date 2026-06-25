package com.pattern.factory;

/**
 * Concrete factory that creates PDF documents.
 */
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
