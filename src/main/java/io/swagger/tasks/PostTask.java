package io.swagger.tasks;

import io.restassured.http.ContentType;
import io.swagger.models.PostDataModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostTask implements Task {
    private final PostDataModel value;
    private final String endPoint;

    public PostTask(PostDataModel value, String endPoint) {
        this.value = value;
        this.endPoint = endPoint;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endPoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("accept","application/json")
                                .body(value).log().all()


                )
        );

    }
    public static Performable withData(PostDataModel value, String endPoint){
        return instrumented(PostTask.class,value,endPoint);
    }
}
