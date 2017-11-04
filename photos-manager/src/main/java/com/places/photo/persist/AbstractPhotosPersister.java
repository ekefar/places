package com.places.photo.persist;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author : Alexander Serebriyan
 */
public abstract class AbstractPhotosPersister implements PhotosPersister {

    public final String EXTENSION = ".PNG";

    public abstract void persist(String path, byte[] content);

    File storeBytes(String path, byte[] bytes) {
        try {
            final File file = new File(path);
            FileUtils.writeByteArrayToFile(file, bytes);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    File bytesToTempFile(byte[] bytes) {
        try {
            final File file = File.createTempFile(String.valueOf(System.nanoTime()), "");
            FileUtils.writeByteArrayToFile(file, bytes);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
