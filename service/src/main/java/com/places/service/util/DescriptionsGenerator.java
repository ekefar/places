package com.places.service.util;

import com.places.service.read.dto.PlaceDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionsGenerator {

    public static String generateForPlace(final PlaceDTO place) {
        return "";
    }

    static List<String> extractOptions(String snippet) {
        final String noBrackets = snippet.replaceFirst("\\{", "")
                .replaceFirst("}", "");

        final String[] split = noBrackets.split("\\|");
        return Arrays.stream(split).map(String::trim).collect(Collectors.toList());
    }
}
