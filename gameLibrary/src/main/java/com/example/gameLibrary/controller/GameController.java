package com.example.gameLibrary.controller;

import com.example.gameLibrary.model.dto.input.GameInputDTO;
import com.example.gameLibrary.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("games")
@RequiredArgsConstructor
public class GameController {

    private final GameService service;

    @PostMapping
    private ResponseEntity<?> createGame(@RequestBody @Valid GameInputDTO gameInputDTO){
        service.saveGame(gameInputDTO);
        URI location = URI.create("http://localhost:8080/games");
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping
    private ResponseEntity<?> deleteGame(@RequestParam("id") Long id){
        service.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
