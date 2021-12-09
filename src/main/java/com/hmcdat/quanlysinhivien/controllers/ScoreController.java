package com.hmcdat.quanlysinhivien.controllers;

import com.hmcdat.quanlysinhivien.dto.ScoreDto;
import com.hmcdat.quanlysinhivien.models.ScoreModel;
import com.hmcdat.quanlysinhivien.repositories.ScoreRepository;
import com.hmcdat.quanlysinhivien.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("scores")
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("")
    public ResponseEntity<Object> getAllScores() {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, scoreRepository.findAll());
    }

    @PostMapping("/{id}/edit")
    public ResponseEntity<Object> editScore(@PathVariable long id, @RequestBody ScoreDto data) {
        try {
            ScoreModel score = scoreRepository.findById(id);
            if (score == null) {
                return ResponseHandler.generateResponse("This id not found", HttpStatus.NOT_FOUND, null);
            }
            score.setLastScore(data.getLastScore());
            score.setFirstScore(data.getFirstScore());
            score.setSemester(data.getSemester());
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, scoreRepository.save(score));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
        }
    }
}
