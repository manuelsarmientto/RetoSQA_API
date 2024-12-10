package io.swagger.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.swagger.models.PostDataModel;
import io.swagger.questions.ObjectPost;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import io.swagger.tasks.PostTask;
import static io.swagger.constants.Constants.URL_Base;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CreatePostPostmanEcho {

    private static final String  restAPIUrl = URL_Base;

    @When("I send a request to the endpoint {string} with the {string} and the {string}")
    public void iSendARequestToTheEndpointWithTheAndThe(String endpoint, String key, String value) {
        Actor user  = Actor.named("user").whoCan(CallAnApi.at(restAPIUrl));
        ObjectPost objectPost = new ObjectPost(value);
        PostDataModel postDataModel = objectPost.answeredBy(null);
        user.attemptsTo(
                PostTask.withData(postDataModel,endpoint)
        );
    }

    @Then("I Validate that the response code is {string}")
    public void iValidateThatTheResponseCodeIs(String code) {
        Actor user = Actor.named("user");
        String codeRest = String.valueOf(SerenityRest.lastResponse().getStatusCode());
        user.should(
                seeThat("The responde code is",res->codeRest,equalTo(code))
        );
    }


    @Then("that data contains {string} {string}")
    public void thatDataContains(String key, String value) {
        Actor user = Actor.named("user");
        String response  = String.valueOf(SerenityRest.lastResponse().getBody().asString());
        String expectedText = "\"" + key + "\": \"" + value + "\"";
        user.should(
                seeThat("The body contains the key-value pair",
                        res -> response.contains(expectedText),
                        equalTo(true)
                )
        );
    }
}
