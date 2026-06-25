package com.pattern.factory;

/**
 * Concrete factory that creates Excel documents.
 */
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
