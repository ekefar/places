package com.places.web.controller;

import com.places.service.read.LocationsReader;
import com.places.service.read.PlacesReader;
import com.places.service.read.PlacesReader.PageInfo;
import com.places.service.read.PlacesReader.PagedResult;
import com.places.service.read.dto.PlaceDTO;
import com.places.service.util.DescriptionsGenerator;
import com.places.web.BreadcrumbsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Map;
import java.util.Set;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class PlacesController {

    private static final Logger LOG = LoggerFactory.getLogger(PlacesController.class);

    private final PlacesReader placesReader;
    private final LocationsReader locationsReader;

    @Inject
    public PlacesController(PlacesReader placesReader,
                            LocationsReader locationsReader) {
        this.placesReader = placesReader;
        this.locationsReader = locationsReader;
    }

    @RequestMapping(value = "/{country}/{city}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("city") String city,
                                    @PathVariable("country") String country,
                                    @RequestParam(name = "page", required = false) Integer page,
                                    Map<String, Object> model) {


        LOG.info("# Displaying places by city: {}", city);

        int correctPage = page == null ? 0 : page - 1;
        final PageInfo pageInfo = new PageInfo(correctPage);
        final Set<String> districts = locationsReader.districtsByCity(city);
        final PagedResult<PlaceDTO> placesPage = placesReader.listByCity(city, pageInfo);
        model.put("totalItems", placesPage.totalElements);
        model.put("totalPages", placesPage.totalPages);
        model.put("currentPage", correctPage + 1);
        model.put("places", placesPage.content);
        model.put("city", city);
        model.put("country", country);
        model.put("districts", districts);
        model.put("breadcrumbs", BreadcrumbsBuilder.build(country, city));
        return "places/list";
    }

    @RequestMapping(value = "/{country}/{city}/{district}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("city") String city,
                                    @PathVariable("country") String country,
                                    @PathVariable("district") String district,
                                    @RequestParam(name = "page", required = false) Integer page,
                                    Map<String, Object> model) {


        LOG.info("# Displaying places by city {} and district {}", city, district);

        int correctPage = page == null ? 0 : page - 1;
        final PageInfo pageInfo = new PageInfo(correctPage);
        final Set<String> districts = locationsReader.districtsByCity(city);
        final PagedResult<PlaceDTO> placesPage = placesReader.listByCityAndDistrict(city, district, pageInfo);
        model.put("totalItems", placesPage.totalElements);
        model.put("totalPages", placesPage.totalPages);
        model.put("currentPage", correctPage + 1);
        model.put("places", placesPage.content);
        model.put("city", city);
        model.put("country", country);
        model.put("districts", districts);
        model.put("district", district);
        model.put("breadcrumbs", BreadcrumbsBuilder.build(country, city, district));
        return "places/list";
    }

    @RequestMapping(value = "/place/{id}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("id") String id,
                                    Map<String, Object> model) {
        final PlaceDTO place = placesReader.byId(id);
        final String description = DescriptionsGenerator.generateForPlace(place);
        model.put("place", place);
        model.put("description", description);
        model.put("photos", place.getPhotoUrls());
        model.put("breadcrumbs", BreadcrumbsBuilder.build(place.getName()));
        return "places/details";
    }
}
