package com.example.quizapp.controllers;


import com.example.quizapp.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/api/quiz"))
public class RandomQuizController {

    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<String> getRandom() {
        try {
            return ResponseEntity.ok(quizService.getRandomQuiz());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{count}")
    public ResponseEntity<String> getRandomQuizzes(@PathVariable Integer count) {
        try {
            return ResponseEntity.ok(quizService.getRandomQuizzes(count));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
