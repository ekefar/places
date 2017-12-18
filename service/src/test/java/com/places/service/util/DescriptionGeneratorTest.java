package com.places.service.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionGeneratorTest {

    @Test
    public void canExtractOptionsFromSnippet() {
        final String snippet = "{first | second | third}";

        final List<String> strings = DescriptionsGenerator.extractOptions(snippet);

        Assert.assertTrue(strings.contains("first"));
        Assert.assertTrue(strings.contains("second"));
        Assert.assertTrue(strings.contains("third"));
    }

    @Test
    public void canExtractSnippetFromText() {

        final String text = "Here goes some text with the snippet that has {first | second | third} option";

        final List<String> snippets = DescriptionsGenerator.extractSnippets(text);

        Assert.assertTrue(snippets.contains("{first | second | third}"));
    }

    @Test
    public void canExtractMultippleSnippetsFromText() {

        final String text = "Here goes some text with the snippet that has {first | second | third} option" +
                " and I'm very {excited | happy} about this";

        final List<String> snippets = DescriptionsGenerator.extractSnippets(text);

        Assert.assertTrue(snippets.contains("{first | second | third}"));
        Assert.assertTrue(snippets.contains("{excited | happy}"));
    }
}
