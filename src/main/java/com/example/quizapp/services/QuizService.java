package com.example.quizapp.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuizService {
    public String getRandomQuiz() {
        final RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://jservice.io/api/random", String.class);
    }

    public String getRandomQuizzes(int count) {
        final RestTemplate restTemplate = new RestTemplate();
        String result = "https://jservice.io/api/random?count=" + count;
        return restTemplate.getForObject(result, String.class);
    }
}
