package com.places.service.util;

import com.places.service.read.dto.PlaceDTO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionsGenerator {

    public static final String SNIPPET_OPENING = "{";
    public static final String SNIPPET_CLOSING = "}";
    public static final String SNIPPET_DELIMITER = "|";

    public static String generateForPlace(final PlaceDTO place) {
        return "";
    }

    static List<String> extractOptions(String snippet) {
        final String noBrackets = snippet.replaceFirst("\\" + SNIPPET_OPENING, "")
                .replaceFirst("\\" + SNIPPET_CLOSING, "");

        final String[] split = noBrackets.split("\\" + SNIPPET_DELIMITER);
        return Arrays.stream(split).map(String::trim).collect(Collectors.toList());
    }

    public static List<String> extractSnippets(String text) {
        final char[] chars = text.toCharArray();
        final char openingChar = SNIPPET_OPENING.toCharArray()[0];
        final char closingChar = SNIPPET_CLOSING.toCharArray()[0];

        final LinkedList<String> snippets = new LinkedList<>();

        int startIndex = -1;

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == openingChar) {
                startIndex = i;
            }

            if (aChar == closingChar) {
                if (startIndex == -1) {
                    throw new IllegalArgumentException("Inner snippets is not supported");
                }

                snippets.add(text.substring(startIndex, i + 1));
            }
        }

        return snippets;
    }
}
