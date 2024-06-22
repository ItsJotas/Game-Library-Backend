package com.example.gameLibrary.service;

import com.example.gameLibrary.model.Game;
import com.example.gameLibrary.model.dto.input.GameInputDTO;
import com.example.gameLibrary.repository.GameRepository;
import com.example.gameLibrary.service.exception.BadRequestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;
    private final ModelMapper mapper;

    @Transactional
    public void saveGame(GameInputDTO gameInputDTO) {
        Game game = mapper.map(gameInputDTO, Game.class);

        checkDuplicatedName(game.getName());
        checkDuplicatedImageUrl(game.getImageUrl());

        repository.save(game);
    }

    private void checkDuplicatedName(String name){
        Game game = repository.findByName(name);
        if(Objects.nonNull(game)){
            throw new BadRequestException("There is already a Game with this name!");
        }
    }

    private void checkDuplicatedImageUrl(String imageUrl){
        Game game = repository.findByImageUrl(imageUrl);
        if(Objects.nonNull(game)){
            throw new BadRequestException("There is already a Game with this image!");
        }
    }
}
