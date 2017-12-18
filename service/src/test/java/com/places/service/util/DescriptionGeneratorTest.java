package com.places.service.util;

import com.google.common.io.Resources;
import com.places.service.read.dto.PlaceDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionGeneratorTest {


    @Test
    public void canProcessTemplate() throws URISyntaxException {
        final File template = new File(Resources.getResource("test-template.ftl").toURI());

        final PlaceDTO place = new PlaceDTO.Builder().setName("Target").setCity("London").build();
        final Map<String, Object> model = DescriptionsGenerator.prepareModel(place);
        final String text = DescriptionsGenerator.processTemplate(model, template);

        assertEquals("Target located in London", text);
    }

    @Test
    public void canExtractOptionsFromSnippet() {
        final String snippet = "{first | second | third}";

        final List<String> strings = DescriptionsGenerator.extractOptions(snippet);

        assertTrue(strings.contains("first"));
        assertTrue(strings.contains("second"));
        assertTrue(strings.contains("third"));
    }

    @Test
    public void canExtractSnippetFromText() {

        final String text = "Here goes some text with the snippet that has {first | second | third} option";

        final List<String> snippets = DescriptionsGenerator.extractSnippets(text);

        assertTrue(snippets.contains("{first | second | third}"));
    }

    @Test
    public void canExtractMultipleSnippetsFromText() {

        final String text = "Here goes some text with the snippet that has {first | second | third} option" +
                " and I'm very {excited | happy} about this";

        final List<String> snippets = DescriptionsGenerator.extractSnippets(text);

        assertTrue(snippets.contains("{first | second | third}"));
        assertTrue(snippets.contains("{excited | happy}"));
    }

    @Test
    public void canLeaveOnlyOneOption() {
        final String text = "Text where only {first|second|third} option will be left.";

        final String replaced = DescriptionsGenerator.replaceSnippets(text);
        final List<String> words = Arrays.asList(replaced.split(" "));

        Assert.assertTrue(words.contains("first") || words.contains("second") || words.contains("third"));
    }
}
