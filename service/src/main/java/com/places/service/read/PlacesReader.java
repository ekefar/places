package com.places.service.read;

import com.places.model.entity.Photo;
import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import com.places.service.read.dto.PlaceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PlacesReader {

    private final PlacesRepository repository;

    @Inject
    public PlacesReader(PlacesRepository repository) {
        this.repository = repository;
    }

    public List<PlaceDTO> list() {
        return toPlaceDtosList(repository.findAll());
    }

    public PagedResult<PlaceDTO> listByCity(String city, PageInfo pageInfo) {
        final Page<Place> places = repository.findByCity(city, pageInfo.toPageable());
        final List<PlaceDTO> dtos = places.getContent().stream()
                .map(this::toPlaceDto)
                .collect(Collectors.toList());

        return new PagedResult<>(dtos, places.getTotalElements(), places.getTotalPages());
    }

    public PagedResult<PlaceDTO> listByCityAndDistrict(String city, String district, PageInfo pageInfo) {
        final Page<Place> places = repository.findByCityAndDistrict(city, district, pageInfo.toPageable());
        final List<PlaceDTO> dtos = places.getContent().stream()
                .map(this::toPlaceDto)
                .collect(Collectors.toList());

        return new PagedResult<>(dtos, places.getTotalElements(), places.getTotalPages());
    }

    public PlaceDTO byId(String id) {
        return toPlaceDto(repository.find(id));
    }

    private List<PlaceDTO> toPlaceDtosList(List<Place> places) {
        return places.stream()
                .map(this::toPlaceDto)
                .collect(Collectors.toList());
    }

    private PlaceDTO toPlaceDto(Place place) {
        String photoUrl = place.getPhotos().size() > 0 ? preparepPhotoUrl(place, place.getPhotos().get(0)) : "";
        return new PlaceDTO.Builder()
                .setId(place.getId())
                .setName(place.getName())
                .setCountry(place.getCountry())
                .setState(place.getState())
                .setCity(place.getCity())
                .setAddress(Optional.ofNullable(place.getAddress()).orElse(""))
                .setLocation(place.getLocation())
                .setMapsId(place.getMapsId())
                .setMapUrl(Optional.ofNullable(place.getMapUrl()).orElse(""))
                .setPhoneNumber(Optional.ofNullable(place.getPhoneNumber()).orElse(""))
                .setPhotoUrls(preparePlacePhotoUrls(place))
                .setRating(place.getRating())
                .setReviews(place.getReviews())
                .setOpeningHours(place.getOpeningHours())
                .setThumbnailUrl(prepareThumbnailUrl(place))
                .setWebsiteUrl(Optional.ofNullable(place.getWebsiteUrl()).orElse(""))
                .build();
    }

    // check 59f9717ccb91bd68e1527d7e
    private String prepareThumbnailUrl(Place place) {
        final List<Photo> photos = place.getPhotos();

        if (photos.isEmpty()) {
            return "";
        }

        int bestPhotoIndex = 0;
        float targetRatio = 1.5f;    // width / height
        float currentBestRatioDiff = 2f;
        for (int i = 0; i < photos.size(); i++) {
            final Photo photo = photos.get(i);
            final float ratio = photo.getWidth() / photo.getHeight();
            final float ratioDiff = Math.abs(targetRatio - ratio);
            if (ratioDiff < currentBestRatioDiff) {
                bestPhotoIndex = i;
                currentBestRatioDiff = ratioDiff;
            }
        }

        final Photo bestPhoto = photos.get(bestPhotoIndex);
        return preparepPhotoUrl(place, bestPhoto);

    }

    private String preparepPhotoUrl(Place place, Photo photo) {
        final String cdnDomain = "d3rmegw3k8iy45.cloudfront.net";
        final String rootFolder = "places-photos";
        final String prefix = "https://" + cdnDomain + "/" + rootFolder + "/" + place.getMapsId() + "/";
        final String extention = ".png";
        return prefix + photo.getReference() + extention;
    }

    private List<String> preparePlacePhotoUrls(Place place) {
        final LinkedList<String> photos = new LinkedList<>();
        for (Photo photo : place.getPhotos()) {
            photos.add(preparepPhotoUrl(place, photo));
        }
        return photos;
    }

    public static class PagedResult<T> {
        public final List<T> content;
        public final long totalElements;
        public final int totalPages;

        public PagedResult(List<T> content, long totalElements, int totalPages) {
            this.content = content;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
        }
    }

    public static class PageInfo {

        public static final int DEFAULT_PAGE_SIZE = 10;

        private int page;
        private int size = DEFAULT_PAGE_SIZE;

        private PageInfo() {
        }

        public PageInfo(int page) {
            this.page = page;
        }

        public PageInfo(int page, int size) {
            this.page = page;
            this.size = size;
        }

        private PageRequest toPageable() {
            return new PageRequest(this.page, this.size);
        }
    }
}
