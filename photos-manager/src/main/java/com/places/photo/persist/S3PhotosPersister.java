package com.places.photo.persist;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.File;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class S3PhotosPersister extends AbstractPhotosPersister {

    @Value("${active.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    @Inject
    public S3PhotosPersister(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @Override
    public void persist(String key, byte[] content) {
        final File file = bytesToTempFile(content);
        amazonS3.putObject(new PutObjectRequest(bucket, key, file));
    }


}
