package com.places.parser.service.photo;

import com.google.maps.PhotoRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.PhotoResult;
import com.places.model.entity.Photo;

import java.util.LinkedList;
import java.util.List;

import static com.places.parser.service.ContextProvider.getGeoContext;

/**
 * @author : Alexander Serebriyan
 */
public class PlacePhotosFetcher {

    public static List<byte[]> fetchPhotos(List<Photo> references) {
        final LinkedList<byte[]> bytes = new LinkedList<>();
        for (Photo photo : references) {
            bytes.add(fetchPhoto(photo));
        }
        return bytes;
    }

    public static byte[] fetchPhoto(Photo photo) {
        try {
            final PhotoRequest request = PlacesApi.photo(getGeoContext(), photo.getReference());
            request.maxWidth(photo.getWidth());
            request.maxHeight(photo.getHeight());
            final PhotoResult photoDetails = request.await();
            return photoDetails.imageData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
