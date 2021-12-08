package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.dto.ScoreDto;
import com.hmcdat.quanlysinhivien.repositories.ScoreRepository;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("scores")
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    @PostMapping("/{id}/edit")
    public ResponseEntity<Object> editScore(@PathVariable long id, @RequestBody ScoreDto data) {
        try {
//            scoreRepository
            return new ResponseEntity<Object>(null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }
}
