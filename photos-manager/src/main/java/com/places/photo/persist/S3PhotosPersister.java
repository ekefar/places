package com.places.photo.persist;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.File;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class S3PhotosPersister extends AbstractPhotosPersister {

    private static final Logger LOG = LoggerFactory.getLogger(S3PhotosPersister.class);

    @Value("${photos.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    @Inject
    public S3PhotosPersister(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @Override
    public void persist(String key, byte[] content) {
        final File file = bytesToTempFile(content);

        LOG.info("# Persisting photo on S3 with next key: " + key);
        amazonS3.putObject(new PutObjectRequest(bucket, key, file));
    }


}
