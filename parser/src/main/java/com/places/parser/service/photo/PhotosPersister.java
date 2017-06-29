package com.places.parser.service.photo;

/**
 * @author : Alexander Serebriyan
 */
public interface PhotosPersister {
    void persist(String path, byte[] content);
}
