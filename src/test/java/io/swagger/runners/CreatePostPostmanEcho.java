package io.swagger.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "io.swagger.stepDefinitions",
        tags = "@Post",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CreatePostPostmanEcho {
}
