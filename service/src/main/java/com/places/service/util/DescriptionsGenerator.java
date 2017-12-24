package com.places.service.util;

import com.places.service.read.dto.PlaceDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionsGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(DescriptionsGenerator.class);

    public static final String SNIPPET_OPENING = "{";
    public static final String SNIPPET_CLOSING = "}";
    public static final String SNIPPET_DELIMITER = "|";

    public static String generateForPlace(final PlaceDTO place) {
        try {

            final Map<String, Object> model = prepareModel(place);
            final File defaultTemplate = prepareDefaultTemplate();
            final String text = replaceSnippets(processTemplate(model, defaultTemplate));
            return text;
        } catch (Exception e) {
            LOG.error("Can't generate a description using a default template", e);
            throw new RuntimeException(e);
        }

    }
    private static File prepareDefaultTemplate() throws IOException {
        final InputStream templateStream = DescriptionsGenerator.class.getResourceAsStream("/templates/place-details.ftl");
        File tempFile = File.createTempFile("temp-templates/", String.valueOf(System.nanoTime()));
        tempFile.deleteOnExit();
        final FileOutputStream os = new FileOutputStream(tempFile);
        IOUtils.copy(templateStream, os);
        os.close();
        return tempFile;
    }

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
        model.put("address", place.getAddress());
        model.put("state", place.getState());
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
