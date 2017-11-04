package com.places.photo.persist;

import org.springframework.stereotype.Service;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class LocalPhotosPersister extends AbstractPhotosPersister {

    @Override
    public void persist(String path, byte[] content) {
        storeBytes(path, content);
    }
}
