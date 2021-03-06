package com.places.photo.persist;


import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PhotosPersisterFactory {

    private final LocalPhotosPersister localPhotosPersister;
    private final S3PhotosPersister s3PhotosPersister;

    @Inject
    public PhotosPersisterFactory(LocalPhotosPersister localPhotosPersister,
                                  S3PhotosPersister s3PhotosPersister) {
        this.localPhotosPersister = localPhotosPersister;
        this.s3PhotosPersister = s3PhotosPersister;
    }

    public PhotosPersister getPersister() {
//        return localPhotosPersister;
        return s3PhotosPersister;
    }
}
