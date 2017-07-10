package com.places.service.read;

import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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

    public List<Place> list() {
        return repository.findAll();
    }

    public List<Place> listByCity(String city, PageInfo pageInfo ) {
        return repository.findByCity(city, pageInfo.toPageable());
    }

    public Place byId(String id){
        return repository.find(id);
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
