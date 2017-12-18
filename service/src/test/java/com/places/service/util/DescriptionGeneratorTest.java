package com.places.service.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class DescriptionGeneratorTest {

    @Test
    public void extractOptionsFromSnippet() {
        final String snippet = "{first | second | third}";

        final List<String> strings = DescriptionsGenerator.extractOptions(snippet);

        Assert.assertTrue(strings.contains("first"));
        Assert.assertTrue(strings.contains("second"));
        Assert.assertTrue(strings.contains("third"));
    }
}
