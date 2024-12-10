package io.swagger.questions;

import io.swagger.models.PostDataModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ObjectPost implements Question <PostDataModel>{
    private final String value;

    public ObjectPost(String value){
        this.value = value;
    }


    @Override
    public PostDataModel answeredBy(Actor actor) {
      PostDataModel jsonPost = PostDataModel.builder()
              .name(value)
              .build();
        return jsonPost;
    }
}
