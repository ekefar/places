package com.places.service.util;

import com.places.service.read.dto.PlaceDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionsGenerator {

    public static final String SNIPPET_OPENING = "{";
    public static final String SNIPPET_CLOSING = "}";
    public static final String SNIPPET_DELIMITER = "|";

    public static String generateForPlace(final PlaceDTO place, File template) {
        final Map<String, Object> model = prepareModel(place);
        final String text = replaceSnippets(processTemplate(model, template));
        return text;
    }

    static String processTemplate(Map model, File templateFile) {
        Configuration configuration = prepareConfiguration();

        try {
            configuration.setDirectoryForTemplateLoading(templateFile.getParentFile());
            Template template = configuration.getTemplate(templateFile.getName());
            StringWriter stringWriter = new StringWriter();
            template.process(model, stringWriter);
            return stringWriter.toString();

        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    private static Configuration prepareConfiguration() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        return configuration;
    }

    static Map<String, Object> prepareModel(PlaceDTO place) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", place.getName());
        model.put("city", place.getCity());
        return model;
    }

    static String replaceSnippets(String text) {
        final List<String> snippets = extractSnippets(text);

        for (String snippet : snippets) {
            final List<String> options = extractOptions(snippet);
            Collections.shuffle(options);
            final String randomOption = options.get(0);

            text = text.replace(snippet, randomOption);
        }

        return text;
    }

    static List<String> extractOptions(String snippet) {
        final String noBrackets = snippet.replace(SNIPPET_OPENING, "")
                .replace(SNIPPET_CLOSING, "");

        final String[] split = noBrackets.split("\\" + SNIPPET_DELIMITER);
        return Arrays.stream(split).map(String::trim).collect(Collectors.toList());
    }

    static List<String> extractSnippets(String text) {
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
