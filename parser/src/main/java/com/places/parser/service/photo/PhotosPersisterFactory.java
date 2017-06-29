package com.places.parser.service.photo;


import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PhotosPersisterFactory {

    @Inject
    private LocalPhotosPersister localPhotosPersister;

    @Inject
    private S3PhotosPersister s3PhotosPersister;

    public PhotosPersister instance(){
        return localPhotosPersister;
    }
}
