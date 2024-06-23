package com.example.gameLibrary.service;

import com.example.gameLibrary.model.Game;
import com.example.gameLibrary.model.dto.input.GameInputDTO;
import com.example.gameLibrary.model.dto.output.GameOutputDTO;
import com.example.gameLibrary.model.dto.update.GameUpdateDTO;
import com.example.gameLibrary.repository.GameRepository;
import com.example.gameLibrary.service.exception.BadRequestException;
import com.example.gameLibrary.service.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final ModelMapper mapper;

    public void saveGame(GameInputDTO gameInputDTO) {
        Game game = mapper.map(gameInputDTO, Game.class);

        checkDuplicatedName(game.getId(), game.getName());
        checkDuplicatedImageUrl(game.getId(), game.getImageUrl());

        gameRepository.save(game);
    }

    public GameOutputDTO updateGame(Long id, GameUpdateDTO gameUpdateDTO) {
        Game game = findGameById(id);
        mapper.map(gameUpdateDTO, game);

        checkDuplicatedName(game.getId(), game.getName());
        checkDuplicatedImageUrl(game.getId(), game.getImageUrl());

        gameRepository.save(game);
        GameOutputDTO gameOutputDTO = mapper.map(game, GameOutputDTO.class);
        return gameOutputDTO;
    }

    public void deleteGame(Long id) {
        Game game = findGameById(id);
        if(Objects.nonNull(game)){
            gameRepository.deleteById(id);
        }
    }

    private Game findGameById(Long id){
        Game game = gameRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Game not found! Id: " + id));
        return game;
    }

    private void checkDuplicatedName(Long id, String name){
        Game game = gameRepository.findByName(name);
        if(Objects.nonNull(game) && !Objects.equals(id, game.getId())){
            throw new BadRequestException("There is already a Game with this name!");
        }
    }

    private void checkDuplicatedImageUrl(Long id, String imageUrl){
        Game game = gameRepository.findByImageUrl(imageUrl);
        if(Objects.nonNull(game) && !Objects.equals(id, game.getId())){
            throw new BadRequestException("There is already a Game with this image!");
        }
    }
}
