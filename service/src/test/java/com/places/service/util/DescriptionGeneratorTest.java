package com.places.service.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionGeneratorTest {

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
