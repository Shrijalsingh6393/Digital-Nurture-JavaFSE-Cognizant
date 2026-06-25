package com.pattern.factory;

/**
 * Abstract creator class implementing the Factory Method Design Pattern.
 */
public abstract class DocumentFactory {
    
    /**
     * Factory Method to be implemented by concrete factories.
     *
     * @return a concrete Document instance
     */
    public abstract Document createDocument();

    /**
     * Helper method that performs operations on a Document.
     * Illustrates how the creator depends on the product interface rather than concrete classes.
     */
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}
