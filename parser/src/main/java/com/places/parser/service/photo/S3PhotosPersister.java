package com.places.parser.service.photo;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class S3PhotosPersister implements PhotosPersister {

    @Value("${active.bucket}")
    private String bucket;

    @Override
    public void persist(String key, byte[] content) {
        final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider()).build();
        final File file = bytesToFile(content);
        s3Client.putObject(new PutObjectRequest(bucket, key, file));
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
