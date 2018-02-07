package org.dalton;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.Random;

/* max question: https://qriusity.com/v1/questions/17904 */
@Assignment(assignment = "trivia")
public class QriusityDemo {
    public static void main(String[] args) throws UnirestException, InterruptedException {
        //declarations:
        Random gen = new Random();

        //make the api request:
        HttpResponse<JsonNode> response = Unirest.get("https://hudelabs-qriusity-v1.p.mashape.com/v1/questions/"
                + (gen.nextInt(17903)+1))
                .header("X-Mashape-Key", "7VvWMlHBbJmsheFwoSuamkgveI5Up1faL1ajsn48nOMbYXvhRS")
                .asJson();
        JSONObject trivia1 = response.getBody().getArray().getJSONObject(0);

        //print some info:
        System.out.println("question: " + trivia1.getString("question"));
        System.out.println("1. " + trivia1.getString("option1"));
        System.out.println("2. " + trivia1.getString("option2"));
        System.out.println("3. " + trivia1.getString("option3"));
        System.out.println("4. " + trivia1.getString("option4"));
        Thread.sleep(3000);
        System.out.println(trivia1.getString("option" + trivia1.getInt("answers")));
    }
}
