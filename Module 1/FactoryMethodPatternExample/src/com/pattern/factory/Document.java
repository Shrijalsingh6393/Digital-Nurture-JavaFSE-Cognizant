package com.pattern.factory;

/**
 * Interface representing a Document in the document management system.
 */
public interface Document {
    void open();
    void save();
    void close();
}
