package com.example.quizapp;

import com.example.quizapp.controllers.RandomQuizController;
import com.example.quizapp.services.QuizService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class QuizAppApplicationTests {
    @Mock
    QuizService quizService;

    @InjectMocks
    RandomQuizController randomQuizController;

    @Test
    void notNullValue() throws JSONException {
        QuizService quizService = new QuizService();

        JSONObject jsonObject = new JSONObject(quizService.getRandomQuiz().replace('[', ' ').replace(']', ' '));

        assertNotNull(jsonObject.getString("value"));
    }

    @Test
    void apiRandomQuiz() {
        String resp = "good request";
        when(quizService.getRandomQuiz()).thenReturn(resp);

        HttpStatus response = randomQuizController.getRandom().getStatusCode();

        assertEquals(HttpStatus.OK, response);
    }

    @Test
    void apiRandomQuizWithCount() {
        String resp = "good request";
        when(quizService.getRandomQuizzes(3)).thenReturn(resp);

        HttpStatus response = randomQuizController.getRandomQuizzes(3).getStatusCode();

        assertEquals(HttpStatus.OK, response);
    }

    @Test
    void apiBadRequest() {
        String resp = "bad request";
        int numOfQuizzes = -3;
        when(quizService.getRandomQuizzes(numOfQuizzes)).thenReturn(resp);

        String response = randomQuizController.getRandomQuizzes(numOfQuizzes).getBody();

        assertEquals(resp, response);
    }
}
