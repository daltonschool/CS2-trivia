package org.dalton;

@Assignment(assignment = "trivia")
public class TriviaQuestion {
    String category;
    String question;
    String[] options = new String[4];
    int answer;
}
