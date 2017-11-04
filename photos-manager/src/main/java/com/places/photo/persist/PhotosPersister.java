package com.places.photo.persist;

/**
 * @author : Alexander Serebriyan
 */
public interface PhotosPersister {
    void persist(String path, byte[] content);
}
