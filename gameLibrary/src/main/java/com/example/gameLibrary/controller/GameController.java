package com.example.gameLibrary.controller;

import com.example.gameLibrary.model.Game;
import com.example.gameLibrary.model.dto.input.GameInputDTO;
import com.example.gameLibrary.model.dto.output.GameOutputDTO;
import com.example.gameLibrary.model.dto.update.GameUpdateDTO;
import com.example.gameLibrary.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
    private ResponseEntity<GameOutputDTO> updateGame(@PathVariable("id") Long id,
                                                     @RequestBody @Valid GameUpdateDTO gameUpdateDTO){
        GameOutputDTO gameOutputDTO = service.updateGame(id, gameUpdateDTO);
        return ResponseEntity.ok().body(gameOutputDTO);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteGame(@PathVariable("id") Long id){
        service.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
