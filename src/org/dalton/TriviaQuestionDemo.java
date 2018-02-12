package org.dalton;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Random;

public class TriviaQuestionDemo {
    public static void main(String[] args) throws UnirestException {
        Random gen = new Random();


        // These code snippets use an open-source library. http://unirest.io/java
        HttpResponse<JsonNode> response = Unirest.get("https://hudelabs-qriusity-v1.p.mashape.com/v1/questions/"
                + (gen.nextInt(17903)+1))
                .header("X-Mashape-Key", "7VvWMlHBbJmsheFwoSuamkgveI5Up1faL1ajsn48nOMbYXvhRS")
                .asJson();

        System.out.println(response.getBody());
        System.out.println();

        TriviaQuestion pregunta = new TriviaQuestion();
        pregunta.category = response.getBody().getArray().getJSONObject(0).getJSONObject("category").getString("name");
        pregunta.question = response.getBody().getArray().getJSONObject(0).get("question").toString();
        pregunta.options[0] = response.getBody().getArray().getJSONObject(0).get("option1").toString();
        pregunta.options[1] = response.getBody().getArray().getJSONObject(0).get("option2").toString();
        pregunta.options[2] = response.getBody().getArray().getJSONObject(0).get("option3").toString();
        pregunta.options[3] = response.getBody().getArray().getJSONObject(0).get("option4").toString();
        pregunta.answer = response.getBody().getArray().getJSONObject(0).getInt("answers")-1;;

        System.out.println();


    }

}
