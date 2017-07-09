package com.places.parser.service.photo;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class S3PhotosPersister implements PhotosPersister {

    @Value("${active.bucket}")
    private String bucket;

    @Inject
    private AmazonS3 amazonS3;

    @Override
    public void persist(String key, byte[] content) {
        final File file = bytesToFile(content);
        amazonS3.putObject(new PutObjectRequest(bucket, key, file));
    }

    private File bytesToFile(byte[] bytes) {
        try {
            final File file = new File(String.valueOf(System.nanoTime()));
            FileUtils.writeByteArrayToFile(file, bytes);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
