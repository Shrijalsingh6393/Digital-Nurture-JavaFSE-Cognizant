package com.pattern.factory;

/**
 * Concrete factory that creates Word documents.
 */
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
